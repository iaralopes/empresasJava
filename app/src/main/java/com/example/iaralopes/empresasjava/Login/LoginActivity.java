package com.example.iaralopes.empresasjava.Login;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.iaralopes.empresasjava.R;
import com.example.iaralopes.empresasjava.databinding.ActivityMainBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        viewModel = ViewModelProviders.of(this).get(LoginViewModel.class);

        binding.setViewModel(viewModel);


    }

    public void onLoginClick (View view) {
        binding.getViewModel().onLoginClick();
    }
}
