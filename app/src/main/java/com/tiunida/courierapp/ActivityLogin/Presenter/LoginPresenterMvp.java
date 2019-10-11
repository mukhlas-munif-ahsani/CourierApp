package com.tiunida.courierapp.ActivityLogin.Presenter;

import com.tiunida.courierapp.ActivityLogin.events.LoginEvents;

public interface LoginPresenterMvp {
    boolean isValifForm(String email, String password);
    void validateLogin(String email, String password);
    void onEventMainThread(LoginEvents event);
    void onSignInSuccess();
    void onSignInError();
    void onCreate();
    void onDestroy();
}
