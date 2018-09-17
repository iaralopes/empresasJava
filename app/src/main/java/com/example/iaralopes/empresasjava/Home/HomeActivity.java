package com.example.iaralopes.empresasjava.Home;

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
import android.widget.Toolbar;

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

//        SearchManager searchManager =
//                (SearchManager)getSystemService(Context.SEARCH_SERVICE);
//        SearchableInfo info =
//                searchManager.getSearchableInfo(getComponentName());
//        searchView.setSearchableInfo(info);

        return true;
     }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id == R.id.action_search){
       //     Intent i = new Intent(HomeActivity.this, SearchActivity.class);
       //     startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }


}
