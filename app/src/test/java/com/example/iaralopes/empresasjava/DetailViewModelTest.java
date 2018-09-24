package com.example.iaralopes.empresasjava;

import com.example.iaralopes.empresasjava.Detail.DetailActivity;
import com.example.iaralopes.empresasjava.Detail.DetailRepository;
import com.example.iaralopes.empresasjava.Detail.DetailViewInterface;
import com.example.iaralopes.empresasjava.Detail.DetailViewModel;
import com.example.iaralopes.empresasjava.Enterprise.Enterprise;
import com.example.iaralopes.empresasjava.Enterprise.EnterprisePayload;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyInt;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.powermock.api.mockito.PowerMockito.mock;

public class DetailViewModelTest {

    @Mock
    DetailViewInterface detailViewInterface;

    @Mock
    DetailRepository detailRepository;


    DetailViewModel detailViewModel;

    @Test
    public void details_ShowDetails_ReturnTitle () {
        EnterprisePayload enterprisePayLoad = getEnterprise();
        when(detailRepository.getEnterpriseObservable(anyInt())).thenReturn(Observable.<EnterprisePayload>just(enterprisePayLoad));

        detailViewModel.showDetails(10);

        verify(detailViewInterface, times(1)).setTitle(enterprisePayLoad.getEnterprise().getEnterpriseName());
    }

    @Test
    public void details_ShowDetails_ReturnDescription () {
        EnterprisePayload enterprisePayLoad = getEnterprise();
        when(detailRepository.getEnterpriseObservable(anyInt())).thenReturn(Observable.<EnterprisePayload>just(enterprisePayLoad));

        detailViewModel.showDetails(10);

        assertEquals("My enterprise", detailViewModel.detailEnterprise.get());
    }



    EnterprisePayload getEnterprise() {
        Enterprise enterpriseForTest = new Enterprise();

        enterpriseForTest.setEnterpriseName("Ioasys");
        enterpriseForTest.setId(10);
        enterpriseForTest.setDescription("My enterprise");

        EnterprisePayload enterprisePayLoadForTest = new EnterprisePayload(enterpriseForTest, true);

        return enterprisePayLoadForTest;

    }


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        detailViewModel = new DetailViewModel();
        detailViewModel.setupMVVM(detailViewInterface, detailRepository);

    }
}
