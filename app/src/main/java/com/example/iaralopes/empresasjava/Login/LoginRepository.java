package com.example.iaralopes.empresasjava.Login;

import android.util.Log;

import com.example.iaralopes.empresasjava.Service.APIServices;
import com.example.iaralopes.empresasjava.Service.RetrofitClient;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginRepository {

    private APIServices mAPIServices = RetrofitClient.getAPIService();
    private static String UID, CLIENT, ACCESS_TOKEN;
    private static final String MY_PREFS_NAME = "AuthHeaders";



    public void onLoginClick (String email, String senha) {

        Credentials credentials = new Credentials(email, senha);

        mAPIServices.authorizeUser(credentials).enqueue(new Callback<UserPayload>() {
            @Override
            public void onResponse(Call<UserPayload> call, Response<UserPayload> response) {

                if (response.code() == 200) {

                    Log.i("response", "OK");

                    Log.i("AuthHeaders", response.headers().get("uid"));
                    Log.i("AuthHeaders", response.headers().get("client"));
                    Log.i("AuthHeaders", response.headers().get("access-token"));




//                    editor.putString("uid", response.headers().get("uid"));
//                    editor.putString("client", response.headers().get("client"));
//                    editor.putString("access-token", response.headers().get("access-token"));
//                    editor.apply();
                }

            }

            @Override
            public void onFailure(Call<UserPayload> call, Throwable t) {
//                Toast.makeText(LoginActivity.this, "Usuário ou senha inválidos", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
