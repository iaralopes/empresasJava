package com.example.iaralopes.empresasjava.Home;

import android.app.ActionBar;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.iaralopes.empresasjava.Detail.DetailActivity;
import com.example.iaralopes.empresasjava.R;
import com.example.iaralopes.empresasjava.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity implements HomeViewInterface {


    private ActivityHomeBinding binding;
    HomeViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        viewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        binding.setViewModel(viewModel);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar);
        getSupportActionBar().setDisplayShowCustomEnabled(true);

        setupMVVM();
        getEnterpriseList();
    }

    private void setupMVVM() {

        binding.getViewModel().setupMVVM(this);
    }

    private void getEnterpriseList() {

        binding.getViewModel().getEnterpriseList();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem item = menu.findItem(R.id.action_search);

        final SearchView searchView =
                (SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                viewModel.getEnterpriseListWithFilter(searchView);
                return false;
            }

        });

        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                viewModel.listAll();
                return false;
            }
        });


        return true;
     }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    public void getDetails (int enterpriseID) {
        Intent intent = new Intent(HomeActivity.this, DetailActivity.class);
        intent.putExtra("ID", enterpriseID);
        startActivity(intent);
    }


}
