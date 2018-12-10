package com.dream.medical.p;

import com.dream.medical.base.BasePresenter;
import com.dream.medical.interfaces.APIDoc;
import com.dream.medical.interfaces.DissmissView;
import com.dream.medical.interfaces.RegisterView;
import com.dream.medical.services.RetrofitSingleton;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RegisterPresenter extends BasePresenter<RegisterView>{
    private RegisterView view;

    @Override
    public void initListener(RegisterView view) {
        this.view = view;
    }

    public void register(String username,String password){
        RetrofitSingleton
                .getInstance()
                .create()
                .create(APIDoc.class)
                .registerUser(username,password)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(appointDoctorBean -> view.registerShowSuccess(appointDoctorBean),
                        throwable -> view.registerShowError(throwable));
    }
}
