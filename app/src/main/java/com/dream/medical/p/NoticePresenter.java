package com.dream.medical.p;

import com.dream.medical.base.BasePresenter;
import com.dream.medical.interfaces.APIDoc;
import com.dream.medical.interfaces.NoticeView;
import com.dream.medical.services.RetrofitSingleton;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 惜梦_ on 2018/10/6.
 */

public class NoticePresenter extends BasePresenter<NoticeView> {
    private NoticeView noticeView;

    public void initListener(NoticeView noticeView) {
        this.noticeView = noticeView;
    }

    public void sendNotices(String ticker, String title,String text) {
        RetrofitSingleton.getInstance().
                create().
                create(APIDoc.class).
                sendNotice(ticker, title, text).
                subscribeOn(Schedulers.newThread()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(
                        string -> {
                            noticeView.showNoticeSuccess();
                        }
                        , throwable -> noticeView.showNoticeError(throwable));
    }

    public void getLiveAddress(){
        RetrofitSingleton.getInstance().
                create().
                create(APIDoc.class).
                getLiveUrl("1").
                subscribeOn(Schedulers.newThread()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(
                        livebean -> {
                            noticeView.getLiveUrlSuccess(livebean);
                        }
                        , throwable -> noticeView.getLiveUrlError(throwable));
    }
}
