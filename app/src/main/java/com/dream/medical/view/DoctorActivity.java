package com.dream.medical.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dream.medical.R;
import com.dream.medical.base.BaseActivity;
import com.dream.medical.utils.Contacts;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DoctorActivity extends BaseActivity {
    @BindView(R.id.btn_appointment_doctor)
    Button btnAppointmentDoctor;
    @BindView(R.id.btn_appointment_ask)
    Button btnAppointmentAsk;
    @BindView(R.id.btn_go_doctor)
    Button btnGoDoctor;
    @BindView(R.id.btn_dismiss_appointment)
    Button btnDismissAppointment;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_doctor;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
    }

    @Override
    protected void initListener() {
        setOnClick(btnAppointmentDoctor);
        setOnClick(btnAppointmentAsk);
        setOnClick(btnGoDoctor);
        setOnClick(btnDismissAppointment);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void processClick(View view) {
        Bundle bundle = new Bundle();
        switch (view.getId()) {
            case R.id.btn_appointment_ask:
                gotoActivity(GoDoctorActivity.class);
                break;
            case R.id.btn_appointment_doctor:
//                gotoActivity(AppointMentActivity.class);
                bundle.putString(Contacts.TITLE,"预约医生");
                gotoActivity(ApppointDoctorActivity.class,bundle);
                break;
            case R.id.btn_go_doctor:
                bundle.putString(Contacts.TITLE,"立即问诊");
                gotoActivity(ApppointDoctorActivity.class,bundle);
//                gotoActivity(GetAppointDoctorActivity.class);
                break;
            case R.id.btn_dismiss_appointment:
                gotoActivity(DissmissActivity.class);
                break;
        }
    }

    @Override
    public void refreshData() {

    }
}
