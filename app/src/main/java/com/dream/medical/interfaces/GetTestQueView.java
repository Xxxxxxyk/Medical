package com.dream.medical.interfaces;

import com.dream.medical.base.BaseView;
import com.dream.medical.m.QuestionsListBean;

public interface GetTestQueView extends BaseView{
    void getTestQueSuccess(QuestionsListBean list);
    void getTestQueError(Throwable t);
}
