package com.dream.medical.interfaces;

import com.dream.medical.base.BaseView;
import com.dream.medical.m.LiveBean;

/**
 * Created by 惜梦_ on 2018/10/6.
 */

public interface NoticeView extends BaseView {
    void showNoticeSuccess();
    void showNoticeError(Throwable throwable);

    void getLiveUrlSuccess(LiveBean liveBean);

    void getLiveUrlError(Throwable throwable);
}
