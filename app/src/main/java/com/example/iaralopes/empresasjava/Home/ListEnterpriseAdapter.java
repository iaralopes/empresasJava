package com.example.iaralopes.empresasjava.Home;

import com.example.iaralopes.empresasjava.Enterprise.Enterprise;
import com.genius.groupie.GroupAdapter;

import java.util.List;

public class ListEnterpriseAdapter extends GroupAdapter {

    List<Enterprise> listEnterprise;

    public void addItems (HomeViewModelInterface homeViewModelInterface,
                          List <Enterprise> listEnterprise) {
        this.listEnterprise = listEnterprise;

        clear();

        for(Enterprise e : listEnterprise) {
            add(new ListEnterpriseItem(homeViewModelInterface, e));
        }

        notifyDataSetChanged();
    }

    @Override
    public void clear() {

        super.clear();
    }

    @Override
    public int getItemCount() {
        if (listEnterprise != null) {
            return listEnterprise.size();
        }
        return 0;
    }



}
