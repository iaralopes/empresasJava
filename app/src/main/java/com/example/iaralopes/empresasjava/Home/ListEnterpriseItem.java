package com.example.iaralopes.empresasjava.Home;

import com.example.iaralopes.empresasjava.R;
import com.example.iaralopes.empresasjava.databinding.RowEnterprisesBinding;
import com.genius.groupie.Item;

import java.util.List;

public class ListEnterpriseItem extends Item<RowEnterprisesBinding> {

    private Enterprise enterprise;

    public ListEnterpriseItem (Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    @Override
    public int getLayout() {
        return R.layout.row_enterprises;
    }

    @Override
    public void bind(RowEnterprisesBinding binding, int position) {
        binding.textName.setText(enterprise.getEnterpriseName());
        binding.textCategory.setText(enterprise.getEnterpriseType().getEnterpriseTypeName());
        binding.textCountry.setText(enterprise.getCountry());
    }

}
