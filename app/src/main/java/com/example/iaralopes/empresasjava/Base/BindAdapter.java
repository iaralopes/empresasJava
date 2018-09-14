package com.example.iaralopes.empresasjava.Base;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.genius.groupie.GroupAdapter;

public class BindAdapter {

    @BindingAdapter("app:setAdapter")
    public static void setAdapter (RecyclerView recyclerView, GroupAdapter adapter) {
        recyclerView.setAdapter(adapter);
    }
}
