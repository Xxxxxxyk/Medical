package com.dream.medical.view.adapter;

import android.support.annotation.Nullable;
import android.text.method.ScrollingMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dream.medical.R;
import com.dream.medical.m.DoctorBean;

import java.util.List;

public class DoctorAdapter extends BaseQuickAdapter<DoctorBean.PageBean.ListBean, BaseViewHolder> implements View.OnTouchListener {
    public DoctorAdapter(int layoutResId, @Nullable List<DoctorBean.PageBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DoctorBean.PageBean.ListBean item) {
        helper.addOnClickListener(R.id.btn_apppoint);
        TextView tv_doctor_desc = helper.getView(R.id.tv_doctor_desc);
        ImageView iv_doctor_pic = helper.getView(R.id.iv_doctor_pic);
        Glide.with(iv_doctor_pic.getContext()).load(item.r1).into(iv_doctor_pic);
        tv_doctor_desc.setText(item.introduce);
        tv_doctor_desc.setOnTouchListener(this);
        tv_doctor_desc.setMovementMethod(ScrollingMovementMethod.getInstance());
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        //触摸的是EditText并且当前EditText可以滚动则将事件交给EditText处理；否则将事件交由其父类处理
        if ((view.getId() == R.id.tv_doctor_desc)) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                view.getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        return false;
    }
}
