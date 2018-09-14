package com.example.iaralopes.empresasjava.Home;

import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.iaralopes.empresasjava.Base.BaseViewModel;
import com.example.iaralopes.empresasjava.Login.LoginViewInterface;
import com.example.iaralopes.empresasjava.Login.UserPayload;
import com.example.iaralopes.empresasjava.R;
import com.genius.groupie.GroupAdapter;

import java.nio.file.attribute.GroupPrincipal;
import java.util.List;

import io.reactivex.observers.DisposableObserver;

public class HomeViewModel extends BaseViewModel {

//    public ObservableField<String> name = new ObservableField<>();
//    public ObservableField<String> category = new ObservableField<>();
//    public ObservableField<String> country = new ObservableField<>();

    private HomeRepository repository = new HomeRepository();

    private HomeViewInterface homeViewInterface;


    private EnterpriseList data = new EnterpriseList();

    public ListEnterpriseAdapter adapter = new ListEnterpriseAdapter();


    public void setupMVVM (HomeViewInterface homeViewInterface) {
        this.homeViewInterface = homeViewInterface;

    }

    public void getEnterpriseList () {
        repository.getEnterpriseListObservable().subscribeWith(getEnterpriseListObserver());
    }

    private DisposableObserver<EnterpriseList> getEnterpriseListObserver(){
        return new DisposableObserver<EnterpriseList>() {

            @Override
            public void onNext(@NonNull EnterpriseList response) {
                Log.d("response", response.toString());
   //             adapter = new ListEnterpriseAdapter(response.getEnterprises());
                data = response;
                adapter.addItems(data.getEnterprises());
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d("HomeViewModel","Error"+e);
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                Log.d("HomeViewModel","Completed");
              //  homeViewInterface.displayEnterprises(adapter);

            }
        };
    }


}
