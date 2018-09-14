package com.example.iaralopes.empresasjava.Home;

import com.example.iaralopes.empresasjava.Login.Credentials;
import com.example.iaralopes.empresasjava.Login.UserPayload;
import com.example.iaralopes.empresasjava.Service.RetrofitClient;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class HomeRepository {

    public Observable<EnterpriseList> getEnterpriseListObservable(){
        return RetrofitClient.getAPIService()
                .getEnterprises()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }
}
