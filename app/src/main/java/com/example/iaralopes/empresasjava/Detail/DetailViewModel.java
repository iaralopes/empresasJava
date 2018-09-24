package com.example.iaralopes.empresasjava.Detail;

import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.iaralopes.empresasjava.Base.BaseViewModel;
import com.example.iaralopes.empresasjava.Enterprise.EnterpriseList;
import com.example.iaralopes.empresasjava.Enterprise.EnterprisePayload;

import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


public class DetailViewModel extends BaseViewModel {


    private DetailRepository detailRepository;
    private DetailViewInterface detailViewInterface;

    public ObservableField<String> detailEnterprise;


    public void setupMVVM (DetailViewInterface detailViewInterface,
                           DetailRepository detailRepository) {
        this.detailRepository = detailRepository;
        this.detailViewInterface = detailViewInterface;

        detailEnterprise = new ObservableField<>();
    }

    public void showDetails (int enterpriseID) {
       detailRepository.getEnterpriseObservable(enterpriseID)
               .subscribeWith(getEnterpriseObserver());

    }

    private DisposableObserver<EnterprisePayload> getEnterpriseObserver(){
        return new DisposableObserver<EnterprisePayload>() {

            @Override
            public void onNext(@NonNull EnterprisePayload response) {
                detailEnterprise.set(response.getEnterprise().getDescription());
                detailViewInterface.setTitle(response.getEnterprise().getEnterpriseName());
            }

            @Override
            public void onError(@NonNull Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {

            }
        };
    }



}
