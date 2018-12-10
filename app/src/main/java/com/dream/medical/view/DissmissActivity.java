package com.dream.medical.view;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.dream.medical.R;
import com.dream.medical.base.MVPActivity;
import com.dream.medical.interfaces.DissmissView;
import com.dream.medical.m.AppointDoctorBean;
import com.dream.medical.m.OKBean;
import com.dream.medical.p.AppointDissmissPresenter;
import com.dream.medical.view.adapter.DissmissDoctorAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DissmissActivity extends MVPActivity<DissmissView, AppointDissmissPresenter> implements DissmissView {
    @BindView(R.id.rl_dismiss)
    RecyclerView rlDismiss;
    ArrayList<AppointDoctorBean.ResultBean> mResultBeans = new ArrayList<>();
    private DissmissDoctorAdapter mDissmissDoctorAdapter;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_dissmiss;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected void initListener() {
        mDissmissDoctorAdapter = new DissmissDoctorAdapter(R.layout.item_dissmiss_doctor, mResultBeans);
        rlDismiss.setAdapter(mDissmissDoctorAdapter);
        mDissmissDoctorAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                presenter.dissmissAppoint(mResultBeans.get(position).id,mResultBeans.get(position).appointmentTime,mResultBeans.get(position).doctorid);
                mResultBeans.remove(position);
                mDissmissDoctorAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void initData() {
        presenter.initListener(this);
        presenter.getAppointDoctor();
    }

    @Override
    public void processClick(View view) {

    }

    @Override
    public void refreshData() {

    }

    @Override
    protected AppointDissmissPresenter initPresenter() {
        return new AppointDissmissPresenter();
    }

    @Override
    public void showDissmissSuccess(AppointDoctorBean appointDoctorBean) {

        LogUtils.e(appointDoctorBean.result);
        mResultBeans.clear();
        mResultBeans.addAll(appointDoctorBean.result);
        if(mResultBeans.size() == 0){
            ToastUtils.showShort("您还没有预约医生");
        }
        mDissmissDoctorAdapter.notifyDataSetChanged();
    }

    @Override
    public void showDissmissError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void showDissmissoK(OKBean okBean) {
        ToastUtils.showShort("取消预约成功");
    }

    @Override
    public void showDissmissNo(Throwable throwable) {
        ToastUtils.showShort("取消预约失败");
    }

}
