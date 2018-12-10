package com.dream.medical.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.dream.medical.R;
import com.dream.medical.base.MVPActivity;
import com.dream.medical.interfaces.GetResultView;
import com.dream.medical.m.ResultBean;
import com.dream.medical.p.GetResultPresenter;
import com.dream.medical.utils.Contacts;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResultActivity extends MVPActivity<GetResultView, GetResultPresenter> implements GetResultView {

    @BindView(R.id.tv_score)
    TextView tvScore;
    @BindView(R.id.tv_result)
    TextView tvResult;
    @BindView(R.id.btn_replay)
    Button btnReplay;
    private int mScore;

    @Override
    protected GetResultPresenter initPresenter() {
        return new GetResultPresenter();
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_result;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected void initListener() {
        setOnClick(btnReplay);
    }

    @Override
    protected void initData() {
        Bundle extras = getIntent().getExtras();
        mScore = extras.getInt(Contacts.SCORE);
        int id = extras.getInt(Contacts.TEST_ID);
        presenter.getResult(id, mScore);
    }

    @Override
    public void processClick(View view) {
        switch (view.getId()) {
            case R.id.btn_replay:
                gotoActivity(AppointMentActivity.class, true);
                break;
        }
    }

    @Override
    public void refreshData() {

    }


    @Override
    public void getResultSuccess(ResultBean bean) {
        LogUtils.e(bean.getOptionsById);
        tvScore.setText(mScore + "");
        if (TextUtils.isEmpty(bean.getOptionsById.content)) {
            tvResult.setText("网络异常,未能获取结果");
        } else {
            if (TextUtils.isEmpty(bean.getOptionsById.suggest)) {
                tvResult.setText(bean.getOptionsById.content);
            } else {
                tvResult.setText(bean.getOptionsById.content + "\n" +  "建议:" + bean.getOptionsById.suggest);
            }
        }
    }

    @Override
    public void getResultError(Throwable t) {
        t.printStackTrace();
    }

}
