package com.dream.medical.interfaces;

import com.dream.medical.base.BaseView;
import com.dream.medical.m.ResultBean;
import com.dream.medical.m.TestBean;

public interface GetResultView extends BaseView{
    void getResultSuccess(ResultBean bean);
    void getResultError(Throwable t);
}
