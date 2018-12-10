package com.dream.medical.view.adapter;

import android.support.annotation.Nullable;
import android.text.method.ScrollingMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dream.medical.R;
import com.dream.medical.m.AppointDoctorBean;
import com.dream.medical.m.DoctorBean;

import java.util.List;

public class DissmissDoctorAdapter extends BaseQuickAdapter<AppointDoctorBean.ResultBean, BaseViewHolder> {
    public DissmissDoctorAdapter(int layoutResId, @Nullable List<AppointDoctorBean.ResultBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AppointDoctorBean.ResultBean item) {
        TextView tv_doc_msg = helper.getView(R.id.tv_doc_msg);
        String[] split = item.appointmentTime.split("#");
        tv_doc_msg.setText(item.doctorname + '\n' + split[0] + "  " + split[1]);
        helper.addOnClickListener(R.id.tv_doc_msg);
    }
}
