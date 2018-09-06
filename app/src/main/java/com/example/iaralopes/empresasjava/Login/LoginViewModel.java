package com.example.iaralopes.empresasjava.Login;

import android.databinding.ObservableField;

import com.example.iaralopes.empresasjava.Base.BaseViewModel;

public class LoginViewModel extends BaseViewModel implements LoginViewModelInterface  {

    public ObservableField<String> email = new ObservableField<>();
    public ObservableField<String> password = new ObservableField<>();

    LoginViewInterface loginViewInterface;

    LoginRepository repository = new LoginRepository();


    public void onLoginClick() {
        String mEmail = email.get();
        String mPassword = password.get();

        repository.login(mEmail, mPassword);
      //  Log.i("AuthHeaders", SharedPreferenceUtils.getInstance(MyApplication.getAppContext()).getStringValue("uid", null));
    }








}
