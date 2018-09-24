package com.example.iaralopes.empresasjava.Detail;

import dagger.Component;

@Component(modules = {DetailModule.class}) //modulos acessiveis por esse componente

public interface DetailComponent {

    void inject(DetailActivity detailActivity); //quem pode utilizar esses modulos

}
