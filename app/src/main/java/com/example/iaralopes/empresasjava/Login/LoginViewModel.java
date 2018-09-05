package com.example.iaralopes.empresasjava.Login;

import android.databinding.ObservableField;

import com.example.iaralopes.empresasjava.Base.BaseViewModel;

public class LoginViewModel extends BaseViewModel {

    public ObservableField<String> email = new ObservableField<>();
    public ObservableField<String> password = new ObservableField<>();


    public void onLoginClick() {
        String mEmail = email.get();
        String mPassword = password.get();




    }



}
