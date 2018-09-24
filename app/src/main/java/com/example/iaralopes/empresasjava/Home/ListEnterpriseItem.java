package com.example.iaralopes.empresasjava.Home;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import com.example.iaralopes.empresasjava.Enterprise.Enterprise;
import com.example.iaralopes.empresasjava.R;
import com.example.iaralopes.empresasjava.databinding.RowEnterprisesBinding;
import com.genius.groupie.Item;

public class ListEnterpriseItem extends Item<RowEnterprisesBinding> {

    private Enterprise enterprise;
    private HomeViewModelInterface homeViewModelInterface;

    public ListEnterpriseItem (HomeViewModelInterface homeViewModelInterface,
                               Enterprise enterprise) {
        this.enterprise = enterprise;
        this.homeViewModelInterface = homeViewModelInterface;

    }

    @Override
    public int getLayout() {
        return R.layout.row_enterprises;
    }

    @Override
    public void bind(final RowEnterprisesBinding binding, int position) {
        binding.textName.setText(enterprise.getEnterpriseName());
        binding.textCategory.setText(enterprise.getEnterpriseType().getEnterpriseTypeName());
        binding.textCountry.setText(enterprise.getCountry());

        binding.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeViewModelInterface.getDetails(enterprise.getId());
            }
        });

    }


}
