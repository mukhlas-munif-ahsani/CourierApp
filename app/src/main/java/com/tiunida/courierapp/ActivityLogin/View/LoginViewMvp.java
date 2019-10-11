package com.tiunida.courierapp.ActivityLogin.View;

public interface LoginViewMvp {
    void showProgress();
    void hideProgress();
    void enableInputs();
    void disableInputs();
    void setInputs(boolean enabeled);
    void navigateToMainScreen();
    void navigateToLoginScreen();
    void showMessage(String message);
}
