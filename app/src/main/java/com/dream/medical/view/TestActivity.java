package com.dream.medical.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.dream.medical.R;
import com.dream.medical.base.MVPActivity;
import com.dream.medical.interfaces.GetTestView;
import com.dream.medical.m.TestBean;
import com.dream.medical.m.TestLitleBean;
import com.dream.medical.p.TestPresenter;
import com.dream.medical.utils.Contacts;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestActivity extends MVPActivity<GetTestView, TestPresenter> implements GetTestView {
    @BindView(R.id.que_title)
    TextView queTitle;
    @BindView(R.id.btn_select_4)
    Button btnSelect4;
    @BindView(R.id.btn_select_3)
    Button btnSelect3;
    @BindView(R.id.btn_select_2)
    Button btnSelect2;
    @BindView(R.id.btn_select_1)
    Button btnSelect1;
    private List<String> scoreList = new ArrayList<>();
    private int sumScore = 0;
    private TestLitleBean testLitleBean;
    private int once = 2;
    private Bundle mBundle;

    @Override
    protected TestPresenter initPresenter() {
        return new TestPresenter();
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_test;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected void initListener() {
        setOnClick(btnSelect1);
        setOnClick(btnSelect2);
        setOnClick(btnSelect3);
        setOnClick(btnSelect4);
    }

    @Override
    protected void initData() {
        int id = getIntent().getExtras().getInt(Contacts.TEST_ID);
        presenter.getTestQue(id);
        mBundle = new Bundle();
        mBundle.putInt(Contacts.TEST_ID, id);
    }

    @Override
    public void processClick(View view) {
        switch (view.getId()) {
            case R.id.btn_select_1:
                sumScore += (Integer.parseInt(scoreList.get(0)));
                break;
            case R.id.btn_select_2:
                sumScore += (Integer.parseInt(scoreList.get(1)));
                break;
            case R.id.btn_select_3:
                sumScore += (Integer.parseInt(scoreList.get(2)));
                break;
            case R.id.btn_select_4:
                sumScore += (Integer.parseInt(scoreList.get(3)));
                break;
        }
        try {
            switch (once) {
                case 3:
                    if (testLitleBean.field_3 != null && testLitleBean.field_3.size() != 0) {
                        setQueTitleAndSelect(testLitleBean.field_3);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 4:
                    if (testLitleBean.field_4 != null && testLitleBean.field_4.size() != 0) {
                        setQueTitleAndSelect(testLitleBean.field_4);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 5:
                    if (testLitleBean.field_5 != null && testLitleBean.field_5.size() != 0) {
                        setQueTitleAndSelect(testLitleBean.field_5);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 6:
                    if (testLitleBean.field_6 != null && testLitleBean.field_6.size() != 0) {
                        setQueTitleAndSelect(testLitleBean.field_6);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 7:
                    if (testLitleBean.field_7 != null && testLitleBean.field_7.size() != 0) {
                        setQueTitleAndSelect(testLitleBean.field_7);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 8:
                    if (testLitleBean.field_8 != null && testLitleBean.field_8.size() != 0) {
                        setQueTitleAndSelect(testLitleBean.field_8);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 9:
                    if (testLitleBean.field_9 != null && testLitleBean.field_9.size() != 0) {
                        setQueTitleAndSelect(testLitleBean.field_9);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 10:
                    if (testLitleBean.field_10 != null && testLitleBean.field_10.size() != 0) {
                        setQueTitleAndSelect(testLitleBean.field_10);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 11:
                    if (testLitleBean.field_11 != null && testLitleBean.field_11.size() != 0) {
                        setQueTitleAndSelect(testLitleBean.field_11);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 12:
                    if (testLitleBean.field_12 != null && testLitleBean.field_12.size() != 0) {
                        setQueTitleAndSelect(testLitleBean.field_12);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 13:
                    if (testLitleBean.field_13 != null && testLitleBean.field_13.size() != 0) {
                        setQueTitleAndSelect(testLitleBean.field_13);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 14:
                    if (testLitleBean.field_14 != null && testLitleBean.field_14.size() != 0) {
                        setQueTitleAndSelect(testLitleBean.field_14);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 15:
                    if (testLitleBean.field_15 != null && testLitleBean.field_15.size() != 0) {
                        setQueTitleAndSelect(testLitleBean.field_15);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 16:
                    if (testLitleBean.field_16.size() != 0 && testLitleBean.field_16 != null) {
                        setQueTitleAndSelect(testLitleBean.field_16);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 17:
                    if (testLitleBean.field_17.size() != 0 && testLitleBean.field_17 != null) {
                        setQueTitleAndSelect(testLitleBean.field_17);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 18:
                    if (testLitleBean.field_18.size() != 0 && testLitleBean.field_18 != null) {
                        setQueTitleAndSelect(testLitleBean.field_18);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 19:
                    if (testLitleBean.field_19.size() != 0 && testLitleBean.field_19 != null) {
                        setQueTitleAndSelect(testLitleBean.field_19);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 20:
                    if (testLitleBean.field_20.size() != 0 && testLitleBean.field_20 != null) {
                        setQueTitleAndSelect(testLitleBean.field_20);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 21:
                    if (testLitleBean.field_21.size() != 0 && testLitleBean.field_21 != null) {
                        setQueTitleAndSelect(testLitleBean.field_21);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 22:
                    if (testLitleBean.field_22 != null && testLitleBean.field_22.size() != 0) {
                        setQueTitleAndSelect(testLitleBean.field_22);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 23:
                    if (testLitleBean.field_23.size() != 0 && testLitleBean.field_23 != null) {
                        setQueTitleAndSelect(testLitleBean.field_23);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 24:
                    if (testLitleBean.field_24.size() != 0 && testLitleBean.field_24 != null) {
                        setQueTitleAndSelect(testLitleBean.field_24);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 25:
                    if (testLitleBean.field_25.size() != 0 && testLitleBean.field_25 != null) {
                        setQueTitleAndSelect(testLitleBean.field_25);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 26:
                    if (testLitleBean.field_26.size() != 0 && testLitleBean.field_26 != null) {
                        setQueTitleAndSelect(testLitleBean.field_26);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 27:
                    if (testLitleBean.field_27.size() != 0 && testLitleBean.field_27 != null) {
                        setQueTitleAndSelect(testLitleBean.field_27);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 28:
                    if (testLitleBean.field_28.size() != 0 && testLitleBean.field_28 != null) {
                        setQueTitleAndSelect(testLitleBean.field_28);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 29:
                    if (testLitleBean.field_29.size() != 0 && testLitleBean.field_29 != null) {
                        setQueTitleAndSelect(testLitleBean.field_29);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 30:
                    if (testLitleBean.field_30.size() != 0 && testLitleBean.field_30 != null) {
                        setQueTitleAndSelect(testLitleBean.field_30);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 31:
                    if (testLitleBean.field_31.size() != 0 && testLitleBean.field_31 != null) {
                        setQueTitleAndSelect(testLitleBean.field_31);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 32:
                    if (testLitleBean.field_32.size() != 0 && testLitleBean.field_32 != null) {
                        setQueTitleAndSelect(testLitleBean.field_32);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 33:
                    if (testLitleBean.field_33.size() != 0 && testLitleBean.field_33 != null) {
                        setQueTitleAndSelect(testLitleBean.field_33);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 34:
                    if (testLitleBean.field_34.size() != 0 && testLitleBean.field_34 != null) {
                        setQueTitleAndSelect(testLitleBean.field_34);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 35:
                    if (testLitleBean.field_35.size() != 0 && testLitleBean.field_35 != null) {
                        setQueTitleAndSelect(testLitleBean.field_35);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 36:
                    if (testLitleBean.field_36.size() != 0 && testLitleBean.field_36 != null) {
                        setQueTitleAndSelect(testLitleBean.field_36);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 37:
                    if (testLitleBean.field_37.size() != 0 && testLitleBean.field_37 != null) {
                        setQueTitleAndSelect(testLitleBean.field_37);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 38:
                    if (testLitleBean.field_38.size() != 0 && testLitleBean.field_38 != null) {
                        setQueTitleAndSelect(testLitleBean.field_38);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 39:
                    if (testLitleBean.field_39.size() != 0 && testLitleBean.field_39 != null) {
                        setQueTitleAndSelect(testLitleBean.field_39);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 40:
                    if (testLitleBean.field_40.size() != 0 && testLitleBean.field_40 != null) {
                        setQueTitleAndSelect(testLitleBean.field_40);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 41:
                    if (testLitleBean.field_41.size() != 0 && testLitleBean.field_41 != null) {
                        setQueTitleAndSelect(testLitleBean.field_41);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 42:
                    if (testLitleBean.field_42.size() != 0 && testLitleBean.field_42 != null) {
                        setQueTitleAndSelect(testLitleBean.field_42);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 43:
                    if (testLitleBean.field_43.size() != 0 && testLitleBean.field_43 != null) {
                        setQueTitleAndSelect(testLitleBean.field_43);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 44:
                    if (testLitleBean.field_44.size() != 0 && testLitleBean.field_44 != null) {
                        setQueTitleAndSelect(testLitleBean.field_44);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 45:
                    if (testLitleBean.field_45.size() != 0 && testLitleBean.field_45 != null) {
                        setQueTitleAndSelect(testLitleBean.field_45);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 46:
                    if (testLitleBean.field_46.size() != 0 && testLitleBean.field_46 != null) {
                        setQueTitleAndSelect(testLitleBean.field_46);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 47:
                    if (testLitleBean.field_47.size() != 0 && testLitleBean.field_47 != null) {
                        setQueTitleAndSelect(testLitleBean.field_47);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 48:
                    if (testLitleBean.field_48.size() != 0 && testLitleBean.field_48 != null) {
                        setQueTitleAndSelect(testLitleBean.field_48);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 49:
                    if (testLitleBean.field_49.size() != 0 && testLitleBean.field_49 != null) {
                        setQueTitleAndSelect(testLitleBean.field_49);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
                case 50:
                    if (testLitleBean.field_50.size() != 0 && testLitleBean.field_50 != null) {
                        setQueTitleAndSelect(testLitleBean.field_50);
                        once++;
                    } else {
                        mBundle.putInt(Contacts.SCORE, sumScore);
                        gotoActivity(ResultActivity.class, true, mBundle);
                    }
                    break;
            }
        } catch (NullPointerException e){
            mBundle.putInt(Contacts.SCORE, sumScore);
            gotoActivity(ResultActivity.class, true, mBundle);
        }
    }

    @Override
    public void refreshData() {

    }

    @Override
    public void getTestSuccess(TestBean bean) {
        if (bean.getOptionsById != null) {
            Gson gson = new Gson();
            TestLitleBean testLitleBean = gson.fromJson(bean.getOptionsById.answerparam, TestLitleBean.class);
            this.testLitleBean = testLitleBean;
            setQueTitleAndSelect(testLitleBean.field_2);
            once++;
        } else {
            ToastUtils.showShort("啊哦,网络开小差了哟");
        }
    }

    @Override
    public void getTestError(Throwable t) {
        ToastUtils.showShort("啊哦,网络开小差了哟");
        t.printStackTrace();
    }

    public void setQueTitleAndSelect(List<String> list) {
        queTitle.setText(list.get(0));
        LogUtils.e(list);
        switch (testLitleBean.field_2.size()) {
            case 2:
                String[] split = list.get(1).split("-");
                scoreList.add(split[1]);
                btnSelect1.setVisibility(View.VISIBLE);
                btnSelect1.setText(split[0]);
                btnSelect2.setVisibility(View.GONE);
                btnSelect3.setVisibility(View.GONE);
                btnSelect4.setVisibility(View.GONE);
                break;
            case 3:
                String[] split1 = list.get(1).split("-");
                String[] split2 = list.get(2).split("-");
                scoreList.add(split1[1]);
                scoreList.add(split2[1]);
                btnSelect1.setVisibility(View.VISIBLE);
                btnSelect2.setVisibility(View.VISIBLE);
                btnSelect1.setText(split1[0]);
                btnSelect2.setText(split2[0]);
                btnSelect3.setVisibility(View.GONE);
                btnSelect4.setVisibility(View.GONE);
                break;
            case 4:
                String[] split3 = list.get(1).split("-");
                String[] split4 = list.get(2).split("-");
                String[] split5 = list.get(3).split("-");
                scoreList.add(split3[1]);
                scoreList.add(split4[1]);
                scoreList.add(split5[1]);
                btnSelect1.setVisibility(View.VISIBLE);
                btnSelect2.setVisibility(View.VISIBLE);
                btnSelect3.setVisibility(View.VISIBLE);
                btnSelect1.setText(split3[0]);
                btnSelect2.setText(split4[0]);
                btnSelect3.setText(split5[0]);
                btnSelect4.setVisibility(View.GONE);
                break;
            case 5:
                String[] split6 = list.get(1).split("-");
                String[] split7 = list.get(2).split("-");
                String[] split8 = list.get(3).split("-");
                String[] split9 = list.get(4).split("-");
                btnSelect1.setVisibility(View.VISIBLE);
                btnSelect2.setVisibility(View.VISIBLE);
                btnSelect3.setVisibility(View.VISIBLE);
                btnSelect4.setVisibility(View.VISIBLE);
                scoreList.add(split6[1]);
                scoreList.add(split7[1]);
                scoreList.add(split8[1]);
                scoreList.add(split9[1]);
                btnSelect1.setText(split6[0]);
                btnSelect2.setText(split7[0]);
                btnSelect3.setText(split8[0]);
                btnSelect4.setText(split9[0]);
                break;
        }
    }
}
