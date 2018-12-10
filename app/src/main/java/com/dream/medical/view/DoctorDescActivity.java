package com.dream.medical.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.bumptech.glide.Glide;
import com.dream.medical.R;
import com.dream.medical.base.MVPActivity;
import com.dream.medical.interfaces.GetDoctorTimeView;
import com.dream.medical.m.DoctorTime;
import com.dream.medical.m.TabEntity;
import com.dream.medical.p.GetDoctorTimePresenter;
import com.dream.medical.utils.Contacts;
import com.dream.medical.view.adapter.DoctorPagerAdapter;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;

import java.util.ArrayList;
import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DoctorDescActivity extends MVPActivity<GetDoctorTimeView, GetDoctorTimePresenter> implements GetDoctorTimeView {
    @BindView(R.id.personal_avatar_view)
    ImageView personalAvatarView;
    @BindView(R.id.personal_name)
    TextView personalName;
    @BindView(R.id.tl_7)
    SlidingTabLayout tl7;
    @BindView(R.id.vp_time)
    ViewPager vp_time;
    private  ArrayList<Fragment> fragments = new ArrayList<>();
    private String mDoctor_name;
    private String mDoctor_pic;
    private int mUId;
    private String mTitle;


    @Override
    protected GetDoctorTimePresenter initPresenter() {
        return new GetDoctorTimePresenter();
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_doctor_desc;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        Bundle extras = getIntent().getExtras();
        mUId = extras.getInt(Contacts.UID);
        mDoctor_name = extras.getString(Contacts.DOCTOR_NAME);
        mDoctor_pic = extras.getString(Contacts.DOCTOR_PIC);
        mTitle = extras.getString(Contacts.TITLE);
        Glide.with(this).load(mDoctor_pic).into(personalAvatarView);
        personalName.setText(mDoctor_name);
        presenter.getDoctorTime(mUId);
    }

    @Override
    public void processClick(View view) {

    }

    @Override
    public void refreshData() {

    }

    @Override
    public void getDoctorTimeSuccess(DoctorTime bean) {
        LogUtils.e(bean.result);
        String[] titles = new String[bean.result.size()];

        for (int i = 0; i < bean.result.size(); i++) {
            titles[i] = bean.result.get(i).date;
            DoctorTimeFragment doctorTimeFragment = new DoctorTimeFragment();
            Bundle bundle = new Bundle();
            ArrayList<DoctorTime.UserTime> userTimes = new ArrayList<>();
            userTimes.addAll( bean.result.get(i).subsDate);
            bundle.putString(Contacts.DOCTOR_NAME,mDoctor_name);
            bundle.putString(Contacts.DOCTOR_PIC,mDoctor_pic);
            bundle.putString(Contacts.DATE_DAY,bean.result.get(i).date);
            bundle.putInt(Contacts.UID,mUId);
            if(!TextUtils.isEmpty(mTitle)){
                bundle.putString(Contacts.TITLE,mTitle);
            }
            bundle.putSerializable(Contacts.USER_TIME,userTimes);
            doctorTimeFragment.setArguments(bundle);
            fragments.add(doctorTimeFragment);
        }

        vp_time.setAdapter(new DoctorPagerAdapter(getSupportFragmentManager(),fragments));
        tl7.setViewPager(vp_time,titles);
    }

    @Override
    public void getDoctorTimeError(Throwable t) {
        t.printStackTrace();
    }

}
