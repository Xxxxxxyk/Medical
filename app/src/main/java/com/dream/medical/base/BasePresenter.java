package com.dream.medical.base;

public class BasePresenter<T extends BaseView> {

    private T view;

    public void initListener(T view) {
        this.view = view;
    }

}
