package com.dream.medical.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.dream.medical.R;
import com.dream.medical.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Picture2Activity extends BaseActivity {
    @BindView(R.id.iv_pic_2)
    ImageView ivPic2;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_pic_2;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        setOnClick(ivPic2);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void processClick(View view) {
        gotoActivity(Picture3Activity.class,true);
    }

    @Override
    public void refreshData() {

    }
}
