package com.example.iaralopes.empresasjava.Login;

import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.iaralopes.empresasjava.Base.BaseViewModel;

import io.reactivex.observers.DisposableObserver;

public class LoginViewModel extends BaseViewModel implements LoginViewModelInterface  {

    public ObservableField<String> email;
    public ObservableField<String> password;

    private LoginViewInterface loginViewInterface;
    private LoginRepository repository;

    private Credentials credentials;


    public void setupMVVM (LoginViewInterface loginViewInterface) {
        email = new ObservableField<>();
        password = new ObservableField<>();

        repository = new LoginRepository();
        this.loginViewInterface = loginViewInterface;
    }

    public int getAuthHeaders() {
       String mEmail = email.get();
       String mPassword = password.get();

       credentials = new Credentials(mEmail, mPassword);

       int statusCode = credentials.isValidData();

       if (statusCode == 2) {
           repository.getLoginObservable(credentials).subscribeWith(getLoginObserver());

           loginViewInterface.loadingData();
       }
       else if (statusCode == 1) {
           loginViewInterface.loginError("Seu e-mail é inválido!");
       }
       else if (statusCode == 0) {
           loginViewInterface.loginError("Insira os dados de acesso para continuar.");
       }
       else if (statusCode == -1) {
           loginViewInterface.loginError("Algo deu errado! Tente novamente.");
       }

       return statusCode;

    }


    private DisposableObserver<UserPayload> getLoginObserver(){
        return new DisposableObserver<UserPayload>() {

            @Override
            public void onNext(@NonNull UserPayload response) {

            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d("LoginViewModel","Error"+e);
                loginViewInterface.progressDialogDismiss();
                loginViewInterface.userUnauthorized();
            }

            @Override
            public void onComplete() {
                Log.d("LoginViewModel","Completed");
                loginViewInterface.userAuthorized();

            }
        };
    }



}
