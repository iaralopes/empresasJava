package com.example.iaralopes.empresasjava.SharedPreference;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.iaralopes.empresasjava.MyApplication;

public class SharedPreferenceUtils {
    private static SharedPreferenceUtils mSharedPreferenceUtils;
    protected Context mContext;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mSharedPreferencesEditor;

    private SharedPreferenceUtils(Context context) {
        mContext = context;
        mSharedPreferences = context.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        mSharedPreferencesEditor = mSharedPreferences.edit();
    }


    public static SharedPreferenceUtils getInstance(Context context) {
        if (mSharedPreferenceUtils == null) {
            mSharedPreferenceUtils = new SharedPreferenceUtils(MyApplication.getAppContext());
        }
        return mSharedPreferenceUtils;
    }


    public void setStringValue(String key, String value) {
        mSharedPreferencesEditor.putString(key, value);
        mSharedPreferencesEditor.commit();
    }

    public void setBooleanValue(String key, Boolean value) {
        mSharedPreferencesEditor.putBoolean(key, value);
        mSharedPreferencesEditor.commit();
    }

    public String getStringValue(String key, String defaultValue) {
        return mSharedPreferences.getString(key, defaultValue);
    }

    public Boolean getBooleanValue(String key, Boolean defaultValue) {
        return mSharedPreferences.getBoolean(key, defaultValue);
    }


}
