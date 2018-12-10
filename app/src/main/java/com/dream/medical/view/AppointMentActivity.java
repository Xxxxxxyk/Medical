package com.dream.medical.view;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.dream.medical.R;
import com.dream.medical.base.MVPActivity;
import com.dream.medical.interfaces.GetTestQueView;
import com.dream.medical.m.QuestionsListBean;
import com.dream.medical.p.GetTestQuePresenter;
import com.dream.medical.utils.Contacts;
import com.dream.medical.view.adapter.QueAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class AppointMentActivity extends MVPActivity<GetTestQueView, GetTestQuePresenter> implements GetTestQueView {
    @BindView(R.id.rv_list)
    RecyclerView rvList;

    private List<QuestionsListBean.GetTestQuestionsResultBean> getTestQuestionsResultBeans = new ArrayList<>();
    private QueAdapter mAdapter;

    @Override
    protected GetTestQuePresenter initPresenter() {
        return new GetTestQuePresenter();
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_appointmentact;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
    }

    @Override
    protected void initListener() {
        presenter.initListener(this);
        mAdapter = new QueAdapter(R.layout.item_dissmiss_doctor,getTestQuestionsResultBeans);
        rvList.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener((adapter, view, position) -> {
            Bundle bundle = new Bundle();
            bundle.putInt(Contacts.TEST_ID,getTestQuestionsResultBeans.get(position).id);
            gotoActivity(TestActivity.class,true,bundle);
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
    public void getTestQueSuccess(QuestionsListBean list) {
        getTestQuestionsResultBeans.addAll(list.getTestQuestionsResult);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void getTestQueError(Throwable t) {
        ToastUtils.showShort("读取医生列表超时,请重试");
    }

}
