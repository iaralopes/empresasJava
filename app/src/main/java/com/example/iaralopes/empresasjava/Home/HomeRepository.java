package com.example.iaralopes.empresasjava.Home;

import android.support.annotation.NonNull;
import android.support.v7.widget.SearchView;

import com.example.iaralopes.empresasjava.Enterprise.EnterpriseList;
import com.example.iaralopes.empresasjava.Service.RetrofitClient;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

public class HomeRepository {

    public Observable<EnterpriseList> getEnterpriseListObservable(){
        return RetrofitClient.getAPIService()
                .getEnterprises()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }

    public Observable<EnterpriseList> getResultsBasedOnQuery(SearchView searchView) {

        return getObservableQuery(searchView)
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(@NonNull String s) throws Exception {
                        if(s.equals("")){
                            return false;
                        }else{
                            return true;
                        }
                    }
                })
                .debounce(0, TimeUnit.SECONDS)
                .distinctUntilChanged()
                .switchMap(new Function<String, ObservableSource<EnterpriseList>>() {
                    @Override
                    public Observable<EnterpriseList> apply(@NonNull String s) throws Exception {
                        return RetrofitClient.getAPIService()
                                .getEnterprisesBasedOnQuery(s);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }

    private Observable<String> getObservableQuery(SearchView searchView){

        final PublishSubject<String> publishSubject = PublishSubject.create();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                publishSubject.onNext(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                publishSubject.onNext(newText);
                return true;
            }
        });

        return publishSubject;
    }

}
