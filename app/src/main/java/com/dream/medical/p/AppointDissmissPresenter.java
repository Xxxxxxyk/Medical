package com.dream.medical.p;

import com.blankj.utilcode.util.SPUtils;
import com.dream.medical.base.BasePresenter;
import com.dream.medical.interfaces.APIDoc;
import com.dream.medical.interfaces.AppointSuccessView;
import com.dream.medical.interfaces.DissmissView;
import com.dream.medical.services.RetrofitSingleton;
import com.dream.medical.utils.Contacts;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AppointDissmissPresenter extends BasePresenter<DissmissView>{
    private DissmissView view;

    @Override
    public void initListener(DissmissView view) {
        this.view = view;
    }

    public void getAppointDoctor(){
        RetrofitSingleton
                .getInstance()
                .create()
                .create(APIDoc.class)
                .getAppointDoctor()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(appointDoctorBean -> view.showDissmissSuccess(appointDoctorBean),
                        throwable -> view.showDissmissError(throwable));
    }

    public void dissmissAppoint(int indentId,String appointmentTime,int doctorid){
        RetrofitSingleton
                .getInstance()
                .create()
                .create(APIDoc.class)
                .dissmissAppoint(indentId, appointmentTime, doctorid)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(okBean -> view.showDissmissoK(okBean),
                        throwable -> view.showDissmissError(throwable));
    }


}
