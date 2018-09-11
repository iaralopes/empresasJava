package com.example.iaralopes.empresasjava.Login;

import com.example.iaralopes.empresasjava.Service.APIServices;
import com.example.iaralopes.empresasjava.Service.RetrofitClient;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;


public class LoginRepository {

    private APIServices mAPIServices = RetrofitClient.getAPIService();

    public Observable<Response<UserPayload>> getObservable(Credentials credentials){
        return RetrofitClient.getAPIService()
                .authorizeUser(credentials)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }



//    public void login(String email, String password) {
//
//        Credentials credentials = new Credentials(email, password);
//
////        mAPIServices.authorizeUser(credentials).enqueue(new Callback<UserPayload>() {
////            @Override
////            public void onResponse(Call<UserPayload> call, Response<UserPayload> response) {
////
////                if (response.code() == 200) {
////
//                    SharedPreferenceUtils.getInstance(MyApplication.getAppContext()).setValue("uid", response.headers().get("uid"));
//                    SharedPreferenceUtils.getInstance(MyApplication.getAppContext()).setValue("client", response.headers().get("client"));
//                    SharedPreferenceUtils.getInstance(MyApplication.getAppContext()).setValue("access-token", response.headers().get("access-token"));

////                    Log.i("response", "OK");
////
////                }
////
////            }
////
////            @Override
////            public void onFailure(Call<UserPayload> call, Throwable t) {
//////                Toast.makeText(LoginActivity.this, "Usuário ou senha inválidos", Toast.LENGTH_SHORT).show();
////
////            }
////        });
//
//
//    }
}
