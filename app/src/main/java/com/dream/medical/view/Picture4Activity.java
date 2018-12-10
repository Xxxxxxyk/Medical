package com.dream.medical.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.dream.medical.R;
import com.dream.medical.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Picture4Activity extends BaseActivity {
    @BindView(R.id.iv_pic_4)
    ImageView ivPic4;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_pic_4;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        setOnClick(ivPic4);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void processClick(View view) {
        gotoActivity(PayActivity.class,true);
    }

    @Override
    public void refreshData() {

    }

}
