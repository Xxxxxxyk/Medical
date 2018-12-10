package com.dream.medical.view.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dream.medical.R;
import com.dream.medical.m.AppointDoctorBean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AppointDoctorAdapter extends BaseQuickAdapter<AppointDoctorBean.ResultBean, BaseViewHolder> {

    private String mTimeDifference;

    public AppointDoctorAdapter(int layoutResId, @Nullable List<AppointDoctorBean.ResultBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AppointDoctorBean.ResultBean item) {
        ImageView iv_doctor_pic = helper.getView(R.id.iv_doctor_pic);
        TextView tv_doc_msg = helper.getView(R.id.tv_doctor_desc);
        TextView tv_tip = helper.getView(R.id.tv_tip);
        helper.addOnClickListener(R.id.btn_apppoint);
        Glide.with(iv_doctor_pic.getContext()).load(item.r2).into(iv_doctor_pic);
        String[] split = item.appointmentTime.split("#");
        tv_doc_msg.setText(item.doctorname + '\n' + split[0] + "\n" + split[1]);
        String[] split1 = split[1].split("—");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date parse = simpleDateFormat.parse(split[0] + " "+ split1[0] + ":00");
            Date date = new Date();
            mTimeDifference = getTimeDifference(date, parse);
            //温馨提示:距离预约时间还剩18:36.提前20分钟可以进入.
            tv_tip.setText(mTimeDifference);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getText(){
        return mTimeDifference;
    }

    public String getTimeDifference(Date date1, Date date2) {
        //一天的毫秒数
        long d = 1000 * 24 * 60 * 60;
//一小时的毫秒数
        long h = 1000 * 60 * 60;
//一分钟的毫秒数
        long m = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long timeDiff = date2.getTime() - date1.getTime();
        // 计算差多少天
        long day = timeDiff / d;
        // 计算差多少小时
        long hour = timeDiff % d / h;
        // 计算差多少分钟
        long min = timeDiff % d % h / m;
        //输出结果
        if (day == 0 && hour == 0) {
            if (min <= 20) {
                return "当前时间可以进入问诊.";
            }
        }
        return "温馨提示:距离预约时间还剩" + day + "天" + hour + "小时" + min + "分钟" + ".提前20分钟可以进入.";
    }
}
