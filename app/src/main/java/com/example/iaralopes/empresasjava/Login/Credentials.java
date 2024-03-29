package com.example.iaralopes.empresasjava.Login;

import android.text.TextUtils;
import android.util.Patterns;

public class Credentials {
    private String email;
    private String password;

    public Credentials(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int isValidData() {
        if (TextUtils.isEmpty(getEmail()))
            return 0;
        else if (!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches())
            return 1;
        else if (!TextUtils.isEmpty(getEmail()) && !TextUtils.isEmpty(getPassword())) {
            return 2;
        }
        else {
            return -1;
        }
    }

}
