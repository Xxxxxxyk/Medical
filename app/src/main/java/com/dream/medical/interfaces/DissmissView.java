package com.dream.medical.interfaces;

import com.dream.medical.base.BaseView;
import com.dream.medical.m.AppointDoctorBean;
import com.dream.medical.m.OKBean;

public interface DissmissView extends BaseView{
    void showDissmissSuccess(AppointDoctorBean appointDoctorBean);
    void showDissmissError(Throwable throwable);

    void showDissmissoK(OKBean okBean);
    void showDissmissNo(Throwable throwable);
}
