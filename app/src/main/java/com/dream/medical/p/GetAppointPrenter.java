package com.dream.medical.p;

import com.dream.medical.base.BasePresenter;
import com.dream.medical.interfaces.APIDoc;
import com.dream.medical.interfaces.DissmissView;
import com.dream.medical.interfaces.GetAppointView;
import com.dream.medical.services.RetrofitSingleton;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class GetAppointPrenter extends BasePresenter<GetAppointView>{
    private GetAppointView view;

    @Override
    public void initListener(GetAppointView view) {
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
                .subscribe(appointDoctorBean -> view.showGetAppointSuccess(appointDoctorBean),
                        throwable -> view.showGetAppointError(throwable));
    }
}
