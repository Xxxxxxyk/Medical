package com.dream.medical.interfaces;


import com.dream.medical.base.BaseView;
import com.dream.medical.m.LoginBean;
import com.dream.medical.m.RegisterBean;

public interface RegisterView extends BaseView {

    void registerShowSuccess(RegisterBean loginBean);

    void registerShowError(Throwable throwable);

}
