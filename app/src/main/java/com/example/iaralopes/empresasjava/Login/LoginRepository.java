package com.example.iaralopes.empresasjava.Login;

import com.example.iaralopes.empresasjava.Service.RetrofitClient;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;


public class LoginRepository {


    public Observable<UserPayload> getLoginObservable(Credentials credentials){
        return RetrofitClient.getAPIService()
                .authorizeUser(credentials)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
