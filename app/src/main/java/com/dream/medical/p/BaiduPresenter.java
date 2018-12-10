package com.dream.medical.p;

import com.dream.medical.base.BasePresenter;
import com.dream.medical.interfaces.APIDoc;
import com.dream.medical.interfaces.BaiduView;
import com.dream.medical.interfaces.GetTestView;
import com.dream.medical.services.RetrofitSingleton;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class BaiduPresenter extends BasePresenter<BaiduView>{
    private BaiduView view;

    @Override
    public void initListener(BaiduView view) {
        this.view = view;
    }

    public void get120Info(String gps){
        RetrofitSingleton
                .getInstance()
                .create()
                .create(APIDoc.class)
                .get120Info(gps)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(bus120 -> view.get120Success(bus120),
                            throwable -> view.get120Error(throwable));
    }

    public void call120(){
        RetrofitSingleton
                .getInstance()
                .create()
                .create(APIDoc.class)
                .call120("1")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(call120 -> view.call120Success(call120),
                        throwable -> view.call120Error(throwable));
    }
}
