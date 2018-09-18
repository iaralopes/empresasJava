package com.example.iaralopes.empresasjava.Detail;

import com.example.iaralopes.empresasjava.Enterprise.Enterprise;
import com.example.iaralopes.empresasjava.Enterprise.EnterprisePayload;
import com.example.iaralopes.empresasjava.Login.Credentials;
import com.example.iaralopes.empresasjava.Login.UserPayload;
import com.example.iaralopes.empresasjava.Service.RetrofitClient;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class DetailRepository {

    public Observable<EnterprisePayload> getEnterpriseObservable(int enterpriseID){
        return RetrofitClient.getAPIService()
                .getEnterprise(enterpriseID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
