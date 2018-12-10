package com.dream.medical.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class MVPFragment<V extends BaseView, P extends BasePresenter<V>> extends BaseFragment {

    protected P presenter = initPresenter();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        initPresenter();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.initListener((V) this);
    }

    protected abstract P initPresenter();

}
