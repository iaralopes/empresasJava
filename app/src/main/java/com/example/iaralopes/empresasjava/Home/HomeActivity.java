package com.example.iaralopes.empresasjava.Home;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.iaralopes.empresasjava.Login.LoginViewModel;
import com.example.iaralopes.empresasjava.R;
import com.example.iaralopes.empresasjava.databinding.ActivityHomeBinding;
import com.example.iaralopes.empresasjava.databinding.ActivityMainBinding;

public class HomeActivity extends AppCompatActivity implements HomeViewInterface {

    RecyclerView rvEnterprises;

    RecyclerView.Adapter adapter;

    private ActivityHomeBinding binding;
    HomeViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);

        viewModel = ViewModelProviders.of(this).get(HomeViewModel.class);

        binding.setViewModel(viewModel);

        setupMVVM();
    }

    private void setupMVVM() {
        viewModel.setupMVVM(this);
    }

    private void getEnterpriseList() {
        viewModel.getEnterpriseList();
    }

    @Override
    public void displayEnterprises(EnterpriseList enterprise) {
            adapter = new ListEnterpriseAdapter(enterprise.getEnterprises(), HomeActivity.this);
            rvEnterprises.setAdapter(adapter);
    }
}
