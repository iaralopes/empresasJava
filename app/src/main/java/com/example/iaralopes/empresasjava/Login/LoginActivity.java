package com.example.iaralopes.empresasjava.Login;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.iaralopes.empresasjava.Home.HomeActivity;
import com.example.iaralopes.empresasjava.MyApplication;
import com.example.iaralopes.empresasjava.R;
import com.example.iaralopes.empresasjava.SharedPreference.SharedPreferenceUtils;
import com.example.iaralopes.empresasjava.databinding.ActivityMainBinding;

import retrofit2.Response;


public class LoginActivity extends AppCompatActivity implements LoginViewInterface {

    private ActivityMainBinding binding;
    private LoginViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        viewModel = ViewModelProviders.of(this).get(LoginViewModel.class);

        binding.setViewModel(viewModel);

        setupMVVM();

    }

    public void setupMVVM() {
        binding.getViewModel().setupMVVM(this);
    }

    public void onLoginClick(View view) {
        binding.getViewModel().getAuthHeaders();
    }

    public void userAuthorized() {
        Log.d("uid", SharedPreferenceUtils.getInstance(MyApplication.getAppContext()).getStringValue("uid", null));
        Intent enterprisesList = new Intent(LoginActivity.this, HomeActivity.class);
        LoginActivity.this.startActivity(enterprisesList);

    }





}
