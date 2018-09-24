package com.example.iaralopes.empresasjava.Login;


public interface LoginViewInterface {

    void userAuthorized();
    void userUnauthorized();
    void loadingData();
    void loginError(String message);
    void progressDialogDismiss();

}
