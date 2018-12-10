package com.dream.medical.p;

import com.dream.medical.base.BasePresenter;
import com.dream.medical.interfaces.APIDoc;
import com.dream.medical.interfaces.AppointSuccessView;
import com.dream.medical.services.RetrofitSingleton;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AppointSuccessPresenter extends BasePresenter<AppointSuccessView>{
    private AppointSuccessView view;

    @Override
    public void initListener(AppointSuccessView view) {
        this.view = view;
    }

    public void createOrder(String uName,String scopeTime,String oneprice,int dotorId,String doctorName){
        RetrofitSingleton
                .getInstance()
                .create()
                .create(APIDoc.class)
                .createOrder(scopeTime, oneprice, dotorId, doctorName)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(doclist -> view.showAppointSuccess(doclist),
                        throwable -> view.showAppointError(throwable));
    }
}
