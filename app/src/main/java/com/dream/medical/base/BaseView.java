package com.dream.medical.base;

import android.view.ViewGroup;

public interface BaseView {

    /**
     * 显示进度
     */
    void showProgress();

    /**
     * 隐藏进度
     */
    void hideProgress();

    /**
     * 显示异常界面
     */
    void showError(ViewGroup viewGroup);

    /**
     * 隐藏异常界面
     */
    void hideError(ViewGroup viewGroup);

    /**
     * 显示数据为空页面
     */
    void showDataNull(ViewGroup viewGroup);

    /**
     * 隐藏数据为空页面
     */
    void hideDataNull(ViewGroup viewGroup);

}
