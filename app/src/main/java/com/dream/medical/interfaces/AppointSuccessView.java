package com.dream.medical.interfaces;

import com.dream.medical.base.BaseView;
import com.dream.medical.m.OrderBean;

public interface AppointSuccessView extends BaseView {
    void showAppointSuccess(OrderBean doclist);

    void showAppointError(Throwable throwable);
}
