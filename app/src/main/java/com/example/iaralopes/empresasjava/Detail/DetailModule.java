package com.example.iaralopes.empresasjava.Detail;

import dagger.Module;
import dagger.Provides;

@Module
public class DetailModule {

    @Provides
    public DetailRepository providesDetailRepository () {
        return new DetailRepository();
    }
}
