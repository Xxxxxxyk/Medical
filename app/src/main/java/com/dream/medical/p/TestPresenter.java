package com.dream.medical.p;

import com.dream.medical.base.BasePresenter;
import com.dream.medical.interfaces.APIDoc;
import com.dream.medical.interfaces.GetTestQueView;
import com.dream.medical.interfaces.GetTestView;
import com.dream.medical.services.RetrofitSingleton;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class TestPresenter extends BasePresenter<GetTestView>{
    private GetTestView view;

    @Override
    public void initListener(GetTestView view) {
        this.view = view;
    }

    public void getTestQue(int id){
        RetrofitSingleton
                .getInstance()
                .create()
                .create(APIDoc.class)
                .getTest(id)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(quelist -> view.getTestSuccess(quelist),
                            throwable -> view.getTestError(throwable));
    }
}
