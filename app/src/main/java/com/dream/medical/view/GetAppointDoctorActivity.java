package com.dream.medical.view;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.dream.medical.R;
import com.dream.medical.base.BasePresenter;
import com.dream.medical.base.MVPActivity;
import com.dream.medical.interfaces.GetDoctorView;
import com.dream.medical.m.DoctorBean;
import com.dream.medical.p.GetDoctorPresenter;
import com.dream.medical.utils.Contacts;
import com.dream.medical.view.adapter.DoctorAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GetAppointDoctorActivity extends MVPActivity<GetDoctorView, GetDoctorPresenter> implements GetDoctorView {
    @BindView(R.id.tv_doc_list)
    RecyclerView tvDocList;
    @BindView(R.id.tv_tab_title)
    TextView tv_tab_title;

    List<DoctorBean.PageBean.ListBean> mPageBeans = new ArrayList<>();
    private DoctorAdapter mDoctorAdapter;
    private String mTitle;

    @Override
    protected GetDoctorPresenter initPresenter() {
        return new GetDoctorPresenter();
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_apppoint_doc;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        Bundle extras = getIntent().getExtras();
        mTitle = extras.getString(Contacts.TITLE);
        tv_tab_title.setText(mTitle);
    }

    @Override
    protected void initListener() {
        presenter.initListener(this);
        if (TextUtils.equals("预约医生",mTitle)) {
            mDoctorAdapter = new DoctorAdapter(R.layout.item_doctor, mPageBeans);
        }else{
            mDoctorAdapter = new DoctorAdapter(R.layout.item_doctor_1, mPageBeans);
        }
        tvDocList.setAdapter(mDoctorAdapter);
        mDoctorAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putInt(Contacts.UID, mPageBeans.get(position).uid);
                bundle.putString(Contacts.DOCTOR_NAME, mPageBeans.get(position).uname);
                bundle.putString(Contacts.DOCTOR_PIC, mPageBeans.get(position).r1);
                gotoActivity(DoctorDescActivity.class, bundle);
            }
        });
    }

    @Override
    protected void initData() {
        presenter.getTestQue();
    }

    @Override
    public void processClick(View view) {

    }

    @Override
    public void refreshData() {

    }

    @Override
    public void getDoctorSuccess(DoctorBean list) {
        mPageBeans.addAll(list.page.list);
        mDoctorAdapter.notifyDataSetChanged();
    }

    @Override
    public void getDoctorError(Throwable t) {

    }
}
