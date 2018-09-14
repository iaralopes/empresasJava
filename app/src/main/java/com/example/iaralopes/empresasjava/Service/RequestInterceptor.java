package com.example.iaralopes.empresasjava.Service;

import com.example.iaralopes.empresasjava.MyApplication;
import com.example.iaralopes.empresasjava.SharedPreference.SharedPreferenceUtils;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class RequestInterceptor implements Interceptor {

    String uid, client, accessToken;

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        Request.Builder newRequest = request.newBuilder()
                .header("uid", SharedPreferenceUtils.getInstance(MyApplication.getAppContext()).getStringValue("uid", ""))
                .header("client", SharedPreferenceUtils.getInstance(MyApplication.getAppContext()).getStringValue("client", ""))
                .header("access-token", SharedPreferenceUtils.getInstance(MyApplication.getAppContext()).getStringValue("access-token", ""));

        Response response = chain.proceed(newRequest.build());
        saveHeaders(response.headers());

        return response;
    }

    private void saveHeaders (Headers headers) {
        uid = headers.get("uid");
        client = headers.get("client");
        accessToken = headers.get("access-token");

        SharedPreferenceUtils.getInstance(MyApplication.getAppContext()).setValue("uid", uid);
        SharedPreferenceUtils.getInstance(MyApplication.getAppContext()).setValue("client", client);
        SharedPreferenceUtils.getInstance(MyApplication.getAppContext()).setValue("access-token", accessToken);

    }




}
