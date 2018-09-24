package com.example.iaralopes.empresasjava.Detail;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.iaralopes.empresasjava.Home.HomeViewModel;
import com.example.iaralopes.empresasjava.R;
import com.example.iaralopes.empresasjava.databinding.ActivityDetailBinding;

import javax.inject.Inject;

public class DetailActivity extends AppCompatActivity implements DetailViewInterface {

    private ActivityDetailBinding binding;
    private DetailViewModel viewModel;

    private int enterpriseID;

    @Inject
    DetailRepository detailRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        enterpriseID = getIntent().getIntExtra("ID", 0);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        viewModel = ViewModelProviders.of(this).get(DetailViewModel.class);
        binding.setViewModel(viewModel);

        //informando ao dagger sobre o uso de um component e a necessidade de injetar dependencia
        DetailApplication.getComponent().inject(this);


        setupMVVM();
        showDetails(enterpriseID);
    }

    private void setupMVVM() {

        binding.getViewModel().setupMVVM(this, detailRepository);

    }

    private void showDetails (int enterpriseID) {
        binding.getViewModel().showDetails(enterpriseID);
    }

    public void setTitle (String nameEnterprise) {

        getSupportActionBar().setTitle(nameEnterprise);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
