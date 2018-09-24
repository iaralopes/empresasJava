package com.example.iaralopes.empresasjava.Login;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iaralopes.empresasjava.Home.HomeActivity;
import com.example.iaralopes.empresasjava.MyApplication;
import com.example.iaralopes.empresasjava.R;
import com.example.iaralopes.empresasjava.SharedPreference.SharedPreferenceUtils;
import com.example.iaralopes.empresasjava.databinding.ActivityMainBinding;

import retrofit2.Response;


public class LoginActivity extends AppCompatActivity implements LoginViewInterface {

    private ActivityMainBinding binding;
    private LoginViewModel viewModel;

    private ProgressDialog progressDialog;
    private AlertDialog alertDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.rgb(181, 180,166));
        }

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
        progressDialog.dismiss();

        Intent enterprisesList = new Intent(LoginActivity.this, HomeActivity.class);
        LoginActivity.this.startActivity(enterprisesList);

    }

    public void userUnauthorized() {

        LayoutInflater layoutInflater = getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.dialog_alert, null);

        view.findViewById(R.id.alertButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view);
        alertDialog = builder.create();
        alertDialog.show();
    }

    public void loadingData() {
        progressDialog = ProgressDialog.show(LoginActivity.this, "Por favor, aguarde...", "");
    }

    public void loginError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


    public void progressDialogDismiss() {
        progressDialog.dismiss();
    }





}
