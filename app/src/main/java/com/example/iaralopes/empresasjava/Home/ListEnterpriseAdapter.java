package com.example.iaralopes.empresasjava.Home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.iaralopes.empresasjava.R;
import com.genius.groupie.GroupAdapter;

import java.util.List;

public class ListEnterpriseAdapter extends GroupAdapter {

    List<Enterprise> listEnterprise;

    public void addItems (List<Enterprise> listEnterprise) {
        this.listEnterprise = listEnterprise;
        for(Enterprise e : listEnterprise) {
            add(new ListEnterpriseItem(e));
        }
    }

//    @Override
//    public ListEnterpriseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(context).inflate(R.layout.row_enterprises, parent,false);
//        ListEnterpriseHolder listEnterpriseHolder = new ListEnterpriseHolder(v);
//        return listEnterpriseHolder;
//    }

//    @Override
//    public void onBindViewHolder(ListEnterpriseHolder holder, int position) {
//
//    }

    @Override
    public int getItemCount() {
        if (listEnterprise != null) {
            return listEnterprise.size();
        }
        return 0;
    }



}
