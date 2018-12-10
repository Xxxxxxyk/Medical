package com.dream.medical.interfaces;


import com.dream.medical.base.BaseView;
import com.dream.medical.m.LoginBean;

public interface LoginView<T> extends BaseView {

    void loginNetWorkShowSuccessData(LoginBean loginBean);

    void loginNetWorkError(Throwable throwable);

}
