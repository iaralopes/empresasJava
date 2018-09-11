package com.example.iaralopes.empresasjava.Service;


import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String ROOT_URL = "http://54.94.179.135:8090/api/v1/";


    private static Retrofit getRetrofitInstance() {


        return new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static APIServices getAPIService() {

        return getRetrofitInstance().create(APIServices.class);
    }




}

