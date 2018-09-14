package com.example.iaralopes.empresasjava.Home;

import com.genius.groupie.Section;
import com.genius.groupie.UpdatingGroup;

import java.util.List;

public class UpdatingSection extends Section {
    private final UpdatingGroup updatingGroup;

    public UpdatingSection() {
        updatingGroup = new UpdatingGroup();
    }

    public void update(List<ListEnterpriseItem> list) {
        updatingGroup.update(list);
    }
}
