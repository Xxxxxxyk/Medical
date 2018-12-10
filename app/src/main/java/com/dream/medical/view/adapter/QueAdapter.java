package com.dream.medical.view.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dream.medical.R;
import com.dream.medical.m.QuestionsListBean;

import java.util.List;

public class QueAdapter extends BaseQuickAdapter<QuestionsListBean.GetTestQuestionsResultBean, BaseViewHolder> {

    public QueAdapter(int layoutResId, @Nullable List<QuestionsListBean.GetTestQuestionsResultBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, QuestionsListBean.GetTestQuestionsResultBean item) {
        TextView tv_1 = helper.getView(R.id.tv_doc_msg);
        tv_1.setText(item.title);
    }
}
