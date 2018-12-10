package com.dream.medical.p;

import com.dream.medical.base.BasePresenter;
import com.dream.medical.interfaces.APIDoc;
import com.dream.medical.interfaces.GetTestQueView;
import com.dream.medical.services.RetrofitSingleton;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class GetTestQuePresenter extends BasePresenter<GetTestQueView>{
    private GetTestQueView view;

    @Override
    public void initListener(GetTestQueView view) {
        this.view = view;
    }

    public void getTestQue(){
        RetrofitSingleton
                .getInstance()
                .create()
                .create(APIDoc.class)
                .getTestQue()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(quelist -> view.getTestQueSuccess(quelist),
                            throwable -> view.getTestQueError(throwable));
    }
}
