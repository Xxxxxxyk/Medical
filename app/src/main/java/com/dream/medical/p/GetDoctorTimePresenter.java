package com.dream.medical.p;

import com.dream.medical.base.BasePresenter;
import com.dream.medical.interfaces.APIDoc;
import com.dream.medical.interfaces.GetDoctorTimeView;
import com.dream.medical.interfaces.GetDoctorView;
import com.dream.medical.services.RetrofitSingleton;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class GetDoctorTimePresenter extends BasePresenter<GetDoctorTimeView>{
    private GetDoctorTimeView view;

    @Override
    public void initListener(GetDoctorTimeView view) {
        this.view = view;
    }

    public void getDoctorTime(int uId){
        RetrofitSingleton
                .getInstance()
                .create()
                .create(APIDoc.class)
                .getDoctorTime(uId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(doclist -> view.getDoctorTimeSuccess(doclist),
                            throwable -> view.getDoctorTimeError(throwable));
    }
}
