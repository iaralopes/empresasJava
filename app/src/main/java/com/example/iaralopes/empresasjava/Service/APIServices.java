package com.example.iaralopes.empresasjava.Service;

import com.example.iaralopes.empresasjava.Home.EnterpriseList;
import com.example.iaralopes.empresasjava.Login.Credentials;
import com.example.iaralopes.empresasjava.Login.UserPayload;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIServices {

    @GET("enterprises")
    Observable<EnterpriseList> getEnterprises();

    @GET("enterprises")
    Observable<EnterpriseList> getEnterprisesBasedOnQuery(@Query("name") String name);

//    @GET("enterprises/{id}")
//    Call<EnterprisePayload> getEnterprise(@Header("access-token") String accessToken, @Header("client") String client,
//                                          @Header("uid") String uid, @Path("id") int id);
//
    @POST("users/auth/sign_in")
    Observable<UserPayload> authorizeUser(@Body Credentials credential);
}

