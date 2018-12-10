package com.dream.medical.interfaces;

import com.dream.medical.base.BaseView;
import com.dream.medical.m.Bus120;
import com.dream.medical.m.Call120;

/**
 * Created by 惜梦_ on 2018/10/3.
 */

public interface BaiduView extends BaseView {
    void get120Success(Bus120 bus120);
    void get120Error(Throwable throwable);

    void call120Success(Call120 call120);
    void call120Error(Throwable throwable);
}
