package com.example.iaralopes.empresasjava.Detail;

import com.example.iaralopes.empresasjava.MyApplication;

/*
 * Classe criada para que DetailComponent seja acessivel
 */

public class DetailApplication extends MyApplication {

    private static DetailComponent detailComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        detailComponent = DaggerDetailComponent.builder()
                          .detailModule(new DetailModule())
                          .build();
    }

    public static DetailComponent getComponent() {
        return detailComponent;
    }

}
