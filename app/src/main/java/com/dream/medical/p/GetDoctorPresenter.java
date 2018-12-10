package com.dream.medical.p;

import com.dream.medical.base.BasePresenter;
import com.dream.medical.interfaces.APIDoc;
import com.dream.medical.interfaces.GetDoctorTimeView;
import com.dream.medical.interfaces.GetDoctorView;
import com.dream.medical.interfaces.GetTestQueView;
import com.dream.medical.services.RetrofitSingleton;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class GetDoctorPresenter extends BasePresenter<GetDoctorView>{
    private GetDoctorView view;

    @Override
    public void initListener(GetDoctorView view) {
        this.view = view;
    }

    public void getTestQue(){
        RetrofitSingleton
                .getInstance()
                .create()
                .create(APIDoc.class)
                .getDoctor("1","10","id","desc")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(doclist -> view.getDoctorSuccess(doclist),
                            throwable -> view.getDoctorError(throwable));
    }
}
