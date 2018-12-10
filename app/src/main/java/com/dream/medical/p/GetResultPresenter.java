package com.dream.medical.p;

import com.dream.medical.base.BasePresenter;
import com.dream.medical.interfaces.APIDoc;
import com.dream.medical.interfaces.GetResultView;
import com.dream.medical.interfaces.GetTestQueView;
import com.dream.medical.services.RetrofitSingleton;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class GetResultPresenter extends BasePresenter<GetResultView>{
    private GetResultView view;

    @Override
    public void initListener(GetResultView view) {
        this.view = view;
    }

    public void getResult(int id,int score){
        RetrofitSingleton
                .getInstance()
                .create()
                .create(APIDoc.class)
                .getResult(id,score)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(quelist -> view.getResultSuccess(quelist),
                            throwable -> view.getResultError(throwable));
    }
}
