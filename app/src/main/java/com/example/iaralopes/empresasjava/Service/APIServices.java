package com.example.iaralopes.empresasjava.Service;

import com.example.iaralopes.empresasjava.Login.Credentials;
import com.example.iaralopes.empresasjava.Login.UserPayload;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIServices {

//    @GET("enterprises")
//    Call<EnterpriseList> getEnterprises(@Header("access-token") String accessToken, @Header("client") String client, @Header("uid") String uid);
//
//    @GET("enterprises/{id}")
//    Call<EnterprisePayload> getEnterprise(@Header("access-token") String accessToken, @Header("client") String client,
//                                          @Header("uid") String uid, @Path("id") int id);
//
    @POST("users/auth/sign_in")
    Observable<Response<UserPayload>> authorizeUser(@Body Credentials credential);
}

