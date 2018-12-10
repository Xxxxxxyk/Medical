package com.dream.medical.interfaces;

import com.dream.medical.base.BaseView;
import com.dream.medical.m.AppointDoctorBean;

public interface GetAppointView extends BaseView{
    void showGetAppointSuccess(AppointDoctorBean appointDoctorBean);
    void showGetAppointError(Throwable throwable);
}
