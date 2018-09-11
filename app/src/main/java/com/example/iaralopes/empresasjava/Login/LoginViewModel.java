package com.example.iaralopes.empresasjava.Login;

import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.iaralopes.empresasjava.Base.BaseViewModel;
import com.example.iaralopes.empresasjava.MyApplication;
import com.example.iaralopes.empresasjava.Service.APIServices;
import com.example.iaralopes.empresasjava.Service.RetrofitClient;
import com.example.iaralopes.empresasjava.SharedPreference.SharedPreferenceUtils;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class LoginViewModel extends BaseViewModel implements LoginViewModelInterface  {

    public ObservableField<String> email = new ObservableField<>();
    public ObservableField<String> password = new ObservableField<>();

    private LoginViewInterface loginViewInterface;
    private Credentials credentials;

    private LoginRepository repository = new LoginRepository();

    public void setupMVVM (LoginViewInterface loginViewInterface) {
        this.loginViewInterface = loginViewInterface;
    }

    public void getAuthHeaders() {
       String mEmail = email.get();
       String mPassword = password.get();

       credentials = new Credentials(mEmail, mPassword);

       repository.getObservable(credentials).subscribeWith(getObserver());


    }


    public DisposableObserver<Response<UserPayload>> getObserver(){
        return new DisposableObserver<Response<UserPayload>>() {

//            Response<UserPayload> response;

            @Override
            public void onNext(@NonNull Response<UserPayload> response) {
                SharedPreferenceUtils.getInstance(MyApplication.getAppContext()).setValue("uid", response.headers().get("uid"));
                SharedPreferenceUtils.getInstance(MyApplication.getAppContext()).setValue("client", response.headers().get("client"));
                SharedPreferenceUtils.getInstance(MyApplication.getAppContext()).setValue("access-token", response.headers().get("access-token"));

            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d("LoginViewModel","Error"+e);
                e.printStackTrace();
//                mvi.displayError("Error fetching Movie Data");
            }

            @Override
            public void onComplete() {
                Log.d("LoginViewModel","Completed");
                loginViewInterface.userAuthorized();

            }
        };
    }


//    public void onLoginClick() {

//
//        repository.login(mEmail, mPassword);
//      //  Log.i("AuthHeaders", SharedPreferenceUtils.getInstance(MyApplication.getAppContext()).getStringValue("uid", null));
//    }








}
