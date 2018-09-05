package com.example.iaralopes.empresasjava.Service;

import com.example.iaralopes.empresasjava.Login.Credentials;
import com.example.iaralopes.empresasjava.Login.UserPayload;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIServices {

//    @GET("enterprises")
//    Call<EnterpriseList> getEnterprises(@Header("access-token") String accessToken, @Header("client") String client, @Header("uid") String uid);
//
//    @GET("enterprises/{id}")
//    Call<EnterprisePayload> getEnterprise(@Header("access-token") String accessToken, @Header("client") String client,
//                                          @Header("uid") String uid, @Path("id") int id);
//
    @POST("users/auth/sign_in")
    Call<UserPayload> authorizeUser(@Body Credentials credential);
}

