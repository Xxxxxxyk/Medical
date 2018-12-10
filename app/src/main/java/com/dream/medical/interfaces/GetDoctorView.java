package com.dream.medical.interfaces;

import com.dream.medical.base.BaseView;
import com.dream.medical.m.DoctorBean;
import com.dream.medical.m.QuestionsListBean;

public interface GetDoctorView extends BaseView{
    void getDoctorSuccess(DoctorBean list);
    void getDoctorError(Throwable t);
}
