package com.dream.medical.p;

import android.text.TextUtils;

import com.dream.medical.base.BasePresenter;
import com.dream.medical.interfaces.APIDoc;
import com.dream.medical.interfaces.LoginView;
import com.dream.medical.services.RetrofitSingleton;
import com.dream.medical.utils.Contacts;


import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter extends BasePresenter<LoginView> {

    private LoginView loginView;

    public void initListener(LoginView loginView) {
        this.loginView = loginView;
    }

    public void loadLoginData(String mobile, String password) {
        RetrofitSingleton.getInstance().
                create().
                create(APIDoc.class).
                login(mobile, password).
                subscribeOn(Schedulers.newThread()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(
                        loginResponseBean -> {
                            loginView.loginNetWorkShowSuccessData(loginResponseBean);
                        }
                        , throwable -> loginView.loginNetWorkError(throwable));
    }

}
