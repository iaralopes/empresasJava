package com.example.iaralopes.empresasjava.Login;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.iaralopes.empresasjava.MyApplication;
import com.example.iaralopes.empresasjava.SharedPreference.SharedPreferenceUtils;

public class SessionManager {


    private static final String IS_LOGIN = "IsLoggedIn";
    public static final String KEY_EMAIL = "email";

    public void createLoginSession(String email){
        SharedPreferenceUtils.getInstance(MyApplication.getAppContext()).setBooleanValue(IS_LOGIN, true);
        SharedPreferenceUtils.getInstance(MyApplication.getAppContext()).setStringValue(KEY_EMAIL, email);
    }


    public boolean isLoggedIn(){
        return SharedPreferenceUtils.getInstance(MyApplication.getAppContext()).getBooleanValue(IS_LOGIN, false);
    }


}
