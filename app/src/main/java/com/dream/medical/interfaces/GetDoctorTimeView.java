package com.dream.medical.interfaces;

import com.dream.medical.base.BaseView;
import com.dream.medical.m.DoctorTime;
import com.dream.medical.m.TestBean;

public interface GetDoctorTimeView extends BaseView{
    void getDoctorTimeSuccess(DoctorTime bean);
    void getDoctorTimeError(Throwable t);
}
