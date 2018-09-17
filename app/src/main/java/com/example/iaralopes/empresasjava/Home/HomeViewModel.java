package com.example.iaralopes.empresasjava.Home;

import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
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

    private HomeRepository repository;
    public ListEnterpriseAdapter adapter;
    private List<Enterprise> listEnterprises;


    public void setupMVVM () {
        repository = new HomeRepository();
        adapter = new ListEnterpriseAdapter();
    }

    public void listAll () {
        adapter.addItems(listEnterprises);
    }

    public void getEnterpriseList () {
        repository.getEnterpriseListObservable().subscribeWith(getEnterpriseListObserver());
    }

    private DisposableObserver<EnterpriseList> getEnterpriseListObserver(){
        return new DisposableObserver<EnterpriseList>() {

            @Override
            public void onNext(@NonNull EnterpriseList response) {
                Log.d("response", response.toString());
                listEnterprises = response.getEnterprises();
                adapter.addItems(listEnterprises);
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


    public void getEnterpriseListWithFilter (SearchView searchView) {
        repository.getResultsBasedOnQuery(searchView).subscribeWith(getEnterpriseListWithFilterObserver());
    }

    public DisposableObserver<EnterpriseList> getEnterpriseListWithFilterObserver(){
        return new DisposableObserver<EnterpriseList>() {

            @Override
            public void onNext(@NonNull EnterpriseList response) {
                adapter.addItems(response.getEnterprises());

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
    }


}
