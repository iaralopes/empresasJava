package com.example.iaralopes.empresasjava.Detail;

import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.iaralopes.empresasjava.Base.BaseViewModel;
import com.example.iaralopes.empresasjava.Enterprise.EnterpriseList;
import com.example.iaralopes.empresasjava.Enterprise.EnterprisePayload;

import io.reactivex.observers.DisposableObserver;


public class DetailViewModel extends BaseViewModel {

    public ObservableField<String> detailEnterprise;

    private DetailRepository repository;

    private DetailViewInterface detailViewInterface;

    public void setupMVVM (DetailViewInterface detailViewInterface) {
        repository = new DetailRepository();
        detailEnterprise = new ObservableField<>();
        this.detailViewInterface = detailViewInterface;
    }

    public void showDetails (int enterpriseID) {
        repository.getEnterpriseObservable(enterpriseID).subscribeWith(getEnterpriseObserver());
    }

    private DisposableObserver<EnterprisePayload> getEnterpriseObserver(){
        return new DisposableObserver<EnterprisePayload>() {

            @Override
            public void onNext(@NonNull EnterprisePayload response) {
                Log.d("response", response.toString());
                detailEnterprise.set(response.getEnterprise().getDescription());
                detailViewInterface.setTitle(response.getEnterprise().getEnterpriseName());


            }

            @Override
            public void onError(@NonNull Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                //  homeViewInterface.displayEnterprises(adapter);

            }
        };
    }


}
