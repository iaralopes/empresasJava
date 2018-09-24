package com.example.iaralopes.empresasjava.Home;

import android.content.Intent;
import android.net.wifi.hotspot2.pps.HomeSp;
import android.support.annotation.NonNull;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.example.iaralopes.empresasjava.Base.BaseViewModel;
import com.example.iaralopes.empresasjava.Enterprise.Enterprise;
import com.example.iaralopes.empresasjava.Enterprise.EnterpriseList;

import java.util.List;

import io.reactivex.observers.DisposableObserver;

public class HomeViewModel extends BaseViewModel implements HomeViewModelInterface {

    private HomeViewModelInterface homeViewModelInterface;
    private HomeViewInterface homeViewInterface;
    private HomeRepository repository;

    public ListEnterpriseAdapter adapter;
    private List<Enterprise> listEnterprises;



    public void setupMVVM (HomeViewInterface homeViewInterface) {
        homeViewModelInterface = this;
        repository = new HomeRepository();
        this.homeViewInterface = homeViewInterface;

        adapter = new ListEnterpriseAdapter();
    }

    public void listAll () {

        adapter.addItems(homeViewModelInterface, listEnterprises);
    }

    public void getEnterpriseList () {

        repository.getEnterpriseListObservable().subscribeWith(getEnterpriseListObserver());

    }


    private DisposableObserver<EnterpriseList> getEnterpriseListObserver(){
        return new DisposableObserver<EnterpriseList>() {

            @Override
            public void onNext(@NonNull EnterpriseList response) {
                listEnterprises = response.getEnterprises();
                adapter.addItems(homeViewModelInterface, listEnterprises);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

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
                adapter.addItems(homeViewModelInterface, response.getEnterprises());

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
    }


    public void getDetails(int enterpriseID) {

        homeViewInterface.getDetails(enterpriseID);
    }



}
