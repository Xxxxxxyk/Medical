package com.dream.medical.view;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.SizeUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.dream.medical.R;
import com.dream.medical.base.BaseActivity;
import com.dream.medical.base.MVPActivity;
import com.dream.medical.interfaces.GOView;
import com.dream.medical.m.AppointDoctorBean;
import com.dream.medical.p.GOPresenter;
import com.dream.medical.view.adapter.AppointDoctorAdapter;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GoDoctorActivity extends MVPActivity<GOView, GOPresenter> implements GOView {
    @BindView(R.id.rl_godoctor)
    RecyclerView rlGodoctor;
    ArrayList<AppointDoctorBean.ResultBean> mResultBeans = new ArrayList<>();
    private AppointDoctorAdapter mAppointDoctorAdapter;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_godoctor;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected void initListener() {
        mAppointDoctorAdapter = new AppointDoctorAdapter(R.layout.item_go_doctor, mResultBeans);
        rlGodoctor.setAdapter(mAppointDoctorAdapter);
        mAppointDoctorAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (TextUtils.equals(mAppointDoctorAdapter.getText(), "当前时间可以进入问诊.")) {
                    gotoActivity(CameraActivity.class, true);
                } else {
                    ToastUtils.showShort("还未到达问诊时间,先做个测试题吧,提前20分钟可以进入问诊.");
                    gotoActivity(AppointMentActivity.class, true);
                }
            }
        });
    }

    @Override
    protected void initData() {
        presenter.getGo();
    }

    @Override
    public void processClick(View view) {

    }

    @Override
    public void refreshData() {

    }

    @Override
    protected GOPresenter initPresenter() {
        return new GOPresenter();
    }

    @Override
    public void showDissmissSuccess(AppointDoctorBean appointDoctorBean) {
        mResultBeans.clear();
        if (appointDoctorBean.result.size() == 0) {
            View dialogContentView = View.inflate(this, R.layout.dialog_point_layout, null);
            ViewHolder viewContentHolder = new ViewHolder(dialogContentView);
            DialogPlus dialogPlus = DialogPlus.newDialog(this)
                    .setContentHolder(viewContentHolder)
                    .setCancelable(false)
                    .setOnClickListener((dialog, view) -> {
                        dialog.dismiss();
                        finish();
                    })
                    .setContentBackgroundResource(R.drawable.login_limited_background)
                    .setContentHeight((SizeUtils.dp2px(300)))
                    .setMargin(SizeUtils.dp2px(40), SizeUtils.dp2px(170),
                            SizeUtils.dp2px(40), 0)
                    .setGravity(Gravity.TOP)
                    .create();
            dialogPlus.show();
        }
        mResultBeans.addAll(appointDoctorBean.result);
        mAppointDoctorAdapter.notifyDataSetChanged();
    }

    @Override
    public void showDissmissError(Throwable throwable) {

    }
}
