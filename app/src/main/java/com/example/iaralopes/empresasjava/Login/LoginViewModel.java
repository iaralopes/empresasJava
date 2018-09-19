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
    private Credentials credentials;

    private LoginRepository repository = new LoginRepository();

    public void setupMVVM (LoginViewInterface loginViewInterface) {
        email = new ObservableField<>();
        password = new ObservableField<>();
        this.loginViewInterface = loginViewInterface;
    }

    public void getAuthHeaders() {
       String mEmail = email.get();
       String mPassword = password.get();

       credentials = new Credentials(mEmail, mPassword);

       int errorCode = credentials.isValidData();

       if (errorCode == 2) {
           repository.getLoginObservable(credentials).subscribeWith(getLoginObserver());

           loginViewInterface.loginSuccess();

       }
       else if (errorCode == 0) {
           loginViewInterface.loginError("Insira os dados de acesso para continuar.");
       }
       else if (errorCode == 1) {
            loginViewInterface.loginError("Seu e-mail é inválido!");
       }
       else if (errorCode == -1) {
           loginViewInterface.loginError("Algo deu errado! Tente novamente.");
       }

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
