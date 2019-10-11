package com.tiunida.courierapp.ActivityLogin.Interactor;

import com.tiunida.courierapp.ActivityLogin.Model.LoginRepository;
import com.tiunida.courierapp.ActivityLogin.Model.LoginRepositoryMvp;

public class LoginInteractor implements LoginInteractorMvp {

    private LoginRepositoryMvp mLoginRepositoryMvp;

    public LoginInteractor() {
        mLoginRepositoryMvp = new LoginRepository();
    }

    @Override
    public void doSignIn(String email, String password) {
        mLoginRepositoryMvp.signIn(email, password);
    }
}
