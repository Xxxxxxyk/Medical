package com.dream.medical.view;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;

import com.blankj.utilcode.util.LogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.dream.medical.R;
import com.dream.medical.base.BaseFragment;
import com.dream.medical.m.DoctorTime;
import com.dream.medical.utils.Contacts;
import com.dream.medical.view.adapter.UserTimeAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class DoctorTimeFragment extends BaseFragment implements UserTimeAdapter.onSelect {

    @BindView(R.id.rl_user_time)
    RecyclerView rlUserTime;
    @BindView(R.id.btn_yuyue)
    Button btn_yuyue;

    ArrayList<DoctorTime.UserTime> mUserTimes = new ArrayList<>();
    private UserTimeAdapter mUserTimeAdapter;
    private ArrayList<DoctorTime.UserTime> selectUserTime = new ArrayList<>();
    private String mDoctor_name;
    private String mDoctor_pic;
    private String mDoctor_day;
    private String mTitle;
    private int mUid;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_usertime;
    }

    @Override
    protected void initListener() {
        mUserTimeAdapter = new UserTimeAdapter(R.layout.item_usertime, mUserTimes,this);
        rlUserTime.setAdapter(mUserTimeAdapter);
        setOnClick(btn_yuyue);
    }

    @Override
    protected void initData() {
        mUserTimes.clear();
        Bundle arguments = getArguments();
        ArrayList<DoctorTime.UserTime> userTimes = (ArrayList<DoctorTime.UserTime>) arguments.getSerializable(Contacts.USER_TIME);
        mDoctor_name = arguments.getString(Contacts.DOCTOR_NAME);
        mDoctor_pic = arguments.getString(Contacts.DOCTOR_PIC);
        mDoctor_day = arguments.getString(Contacts.DATE_DAY);
        mTitle = arguments.getString(Contacts.TITLE);
        mUid = arguments.getInt(Contacts.UID);
        mUserTimes.addAll(userTimes);
        mUserTimeAdapter.notifyDataSetChanged();

    }

    @Override
    public void processClick(View view) {
        LogUtils.e(selectUserTime.toString());
        Bundle bundle = new Bundle();
        bundle.putSerializable(Contacts.DATE_SCOPE, selectUserTime);
        bundle.putString(Contacts.DATE_DAY, mDoctor_day);
        bundle.putString(Contacts.DOCTOR_NAME, mDoctor_name);
        bundle.putString(Contacts.DOCTOR_PIC, mDoctor_pic);
        if (!TextUtils.isEmpty(mTitle)) {
            bundle.putString(Contacts.TITLE, mTitle);
        }
        bundle.putString(Contacts.DOCTOR_PIC, mDoctor_pic);
        bundle.putInt(Contacts.UID, mUid);
        gotoActivity(PayActivity.class, true, bundle);
    }

    @Override
    public void refreshData() {

    }

    @Override
    public void onSelectListener(CompoundButton buttonView, boolean isChecked, int adapterPosition) {
        if(isChecked){
            selectUserTime.add(mUserTimes.get(adapterPosition));
        }else{
            selectUserTime.remove(mUserTimes.get(adapterPosition));
        }
    }
}
