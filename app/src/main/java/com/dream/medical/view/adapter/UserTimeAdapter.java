package com.dream.medical.view.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatRadioButton;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dream.medical.R;
import com.dream.medical.m.DoctorTime;

import java.util.List;

public class UserTimeAdapter extends BaseQuickAdapter<DoctorTime.UserTime, BaseViewHolder> {

    private onSelect onSelect;

    public UserTimeAdapter(int layoutResId, @Nullable List<DoctorTime.UserTime> data,onSelect onSelect) {
        super(layoutResId, data);
        this.onSelect = onSelect;
    }

    @Override
    protected void convert(BaseViewHolder helper, DoctorTime.UserTime item) {
        TextView tv_doc_time = helper.getView(R.id.tv_doc_time);
        TextView tv_doc_state = helper.getView(R.id.tv_doc_state);
        AppCompatCheckBox acrb_select = helper.getView(R.id.acrb_select);
        acrb_select.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onSelect.onSelectListener(buttonView,isChecked,helper.getAdapterPosition());
            }
        });
        if(TextUtils.equals("可预约",item.status)){
            acrb_select.setChecked(false);
            acrb_select.setSelected(false);
        }else{
            acrb_select.setChecked(true);
            acrb_select.setSelected(true);
        }
        tv_doc_time.setText(item.dateScope);
        tv_doc_state.setText(item.status);
    }

    public interface onSelect{
        void onSelectListener(CompoundButton buttonView, boolean isChecked, int adapterPosition);
    }
}
