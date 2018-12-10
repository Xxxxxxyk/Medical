package com.dream.medical.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

public abstract class MVPActivity<V extends BaseView, P extends BasePresenter<V>> extends BaseActivity {

    protected P presenter = initPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPresenter();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.initListener((V) this);
    }

    protected abstract P initPresenter();

}
