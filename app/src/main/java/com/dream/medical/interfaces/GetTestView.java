package com.dream.medical.interfaces;

import com.dream.medical.base.BaseView;
import com.dream.medical.m.QuestionsListBean;
import com.dream.medical.m.TestBean;

public interface GetTestView extends BaseView{
    void getTestSuccess(TestBean bean);
    void getTestError(Throwable t);
}
