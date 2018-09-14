package com.example.iaralopes.empresasjava.Home;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;

import com.example.iaralopes.empresasjava.Login.LoginViewModel;
import com.example.iaralopes.empresasjava.MyApplication;
import com.example.iaralopes.empresasjava.R;
import com.example.iaralopes.empresasjava.databinding.ActivityHomeBinding;
import com.example.iaralopes.empresasjava.databinding.ActivityMainBinding;
import com.genius.groupie.GroupAdapter;
import com.genius.groupie.Section;

public class HomeActivity extends AppCompatActivity implements HomeViewInterface {


    private ActivityHomeBinding binding;
    HomeViewModel viewModel;

    RecyclerView rvEnterprises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);

        viewModel = ViewModelProviders.of(this).get(HomeViewModel.class);

        binding.setViewModel(viewModel);

        setupMVVM();
        getEnterpriseList();
    }

    private void setupMVVM() {
        viewModel.setupMVVM();
    }

    private void getEnterpriseList() {
        viewModel.getEnterpriseList();
    }

    @Override
    public void displayEnterprises(GroupAdapter adapter) {
//        rvEnterprises.setAdapter(adapter);
    }
}
