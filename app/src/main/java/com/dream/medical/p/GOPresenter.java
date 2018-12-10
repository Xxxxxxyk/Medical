package com.dream.medical.p;

import com.dream.medical.base.BasePresenter;
import com.dream.medical.interfaces.APIDoc;
import com.dream.medical.interfaces.DissmissView;
import com.dream.medical.interfaces.GOView;
import com.dream.medical.services.RetrofitSingleton;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class GOPresenter extends BasePresenter<GOView>{
    private GOView view;

    @Override
    public void initListener(GOView view) {
        this.view = view;
    }

    public void getGo(){
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



}
