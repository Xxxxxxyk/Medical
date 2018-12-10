package com.dream.medical.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.dream.medical.R;
import com.dream.medical.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Picture3Activity extends BaseActivity {
    @BindView(R.id.iv_pic_3)
    ImageView ivPic3;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_pic_3;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        setOnClick(ivPic3);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void processClick(View view) {
        gotoActivity(Picture4Activity.class,true);
    }

    @Override
    public void refreshData() {

    }

}
