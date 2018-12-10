package com.dream.medical.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.dream.medical.R;
import com.dream.medical.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Picture1Activity extends BaseActivity {
    @BindView(R.id.iv_pic_1)
    ImageView ivPic1;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_pic_1;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected void initListener() {
        setOnClick(ivPic1);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void processClick(View view) {
        gotoActivity(Picture2Activity.class,true);
    }

    @Override
    public void refreshData() {

    }
}
