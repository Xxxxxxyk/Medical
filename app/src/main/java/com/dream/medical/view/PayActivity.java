package com.dream.medical.view;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.dream.medical.R;
import com.dream.medical.base.MVPActivity;
import com.dream.medical.interfaces.AppointSuccessView;
import com.dream.medical.m.DoctorTime;
import com.dream.medical.m.OrderBean;
import com.dream.medical.m.PayResult;
import com.dream.medical.p.AppointSuccessPresenter;
import com.dream.medical.utils.Contacts;
import com.dream.medical.utils.OrderInfoUtil2_0;

import java.util.ArrayList;
import java.util.Map;

import butterknife.BindView;

public class PayActivity extends MVPActivity<AppointSuccessView, AppointSuccessPresenter> implements SelectPopupWindow.OnPopWindowClickListener, AppointSuccessView {
    @BindView(R.id.iv_doctor_pic)
    ImageView ivDoctorPic;
    @BindView(R.id.tv_doctor_name)
    TextView tvDoctorName;
    @BindView(R.id.tv_doctor_time)
    TextView tvDoctorTime;
    @BindView(R.id.ll_alipay)
    LinearLayout llAlipay;
    @BindView(R.id.ll_wechat_pay)
    LinearLayout llWechatPay;
    private SelectPopupWindow menuWindow;
    private ArrayList<DoctorTime.UserTime> mUser_time;
    private String mDay;
    private String mDoctor_name;
    private int mUid;
    private String mDoctorPic;
    private String mTitle;

    public static final String PARTNER = "2016080300159525 ";

    // 商户收款账号
    public static final String SELLER = "iaftvy8728@sandbox.com";

    // 商户私钥，pkcs8格式
    public static final String RSA_PRIVATE = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDOxg+TxYcHLmfjna6qRM217FvZ3x1/qMnCHkuqKJoL49es3FwAb1w8FXSFPayeXjb9Q0MoqfNkqomeTa2vCa8Dfle3x0yJIPlpWp/zVN9+b57uctz8nvEsfXVyug3PrXOOoSxUmdO5tt7++2E2LRXh/3MglsA/Sq5C9S1Xc/imPA2jUEJ7NIOwEX3Rl1i52CFxs5tPxIT+fIsIvL7yezTJxs/5g9UneR81s5suYBi5Jw7Teepasr09SBolCiX9svfghm2Y1u1tDZI5GlesOatg+6Kmqn3HfHvfG71kimfpbMO1bELiwPGNjnijFGfhcmkc3UnAEJOX9uk5bqAG4QyVAgMBAAECggEAY1wBODz+uZCvE00+FUuinfzJ1lPEVQfCi6kLKuT/wR7nEIWDICJi6+xTZYNRY3habDDaILwp3QGlx5AEGcxJcSBQ/lqiiHJz5xBJNCBglN0GPgar8iheM8bFnS+SW205zhvctXqFpwQc++HHwMTBcyvRIqPOFZvJSRuPgiqUHSx5MJn1yXe3STT0ERza4+Ijp1BlxswcVcIAgIy+w3E7EEIsIjKLzYXvHOIYMuwhX/WECcCtULYe1kG0lRDhKsD+Zu2ein0QPu+OQ8uuP9tN2rQSbzPFrc8fEtMG9U7f4Ug1CxZQsJqpOyr6QCEX7tPftyszK+7KyW98Fb2DuXDqAQKBgQDoiOWqDCf62bhMLIEt5w29z0nsVFtz+XBtKZ78ctezLVOUWh09S2JiwzNrosgDA6YZadBsNGPhdXVbaTM/qN7l92Ht5bnJVH5HpvkZBvmGRgGJ9+i21f1gA8dtM/GsCC3XHcX9K+v3x5uzIDNQynwQ50W8Ulqy3cjtz5EjUG7bIQKBgQDjo6yVer4ZbeeKGsmoGjASM7ovTCpROVjN1BVHU2JbIeL0kl9bvJlZN6tLHFp/KIXFZGvRL0l/PIT5ywuOzP2dw3TE9VHs0YNyFVEf2z9RcO8hE+WaUXpSXt9vgA0h2XDynRW9WZ0AGVnFdBb4EeQuCyrMnVSqMh0HXpoBD+SW9QKBgF5NdmZZ+7S9qwIpYlINTANYF3CiXVxRIokCwhk7McLWdPjK+uSqt8G5zBaws1CVoDzaLs5TCNacXfWuWjxM7ehxROPHsGq3u2avjoHZ1EPiDCm5wkSzz8eqgKwGztGnl3+P8YVU1KNt7fTc8DKpi1sHj75p36J+U0guT3v02KBBAoGBAJ2kdlsaIlWn58WbIXWZlRq12cTxYQjYxufbbFT1qNJlmC84wnLcG/JN/ADLBNy0alc1YPj/X02O0qPN+hYNXcEIX3AaV37B5N53ZrPB+IpkxCVLCyEgNa6fZupnajC7zV0mbaywR2qPI7z61QE8GqHMN/p1JfGrPLEi0VHU+L+VAoGAW9VRD3zN+SgjCsV8ScGW6BCK2yg/K6pFK71AR89BOg1jfugTt8C7OfXc6U+LryMk2MNUuOSpHzDBrTX0mwOyB+inzzHodB9dbYhJ3SCqhcF/FxSNPdDy8jxoBEfOoyBFuW9FdSXS40lLwG6hNZ/QH7Pp6heV3du2vzpVz8szutc=";

    private static final int SDK_PAY_FLAG = 1;

    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    /**
                     * 同步返回的结果必须放置到服务端进行验证（验证的规则请看https://doc.open.alipay.com/doc2/
                     * detail.htm?spm=0.0.0.0.xdvAU6&treeId=59&articleId=103665&
                     * docType=1) 建议商户依赖异步通知
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息

                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为“9000”则代表支付成功，具体状态码代表含义可参考接口文档
                    if (TextUtils.equals(resultStatus, "9000")) {
                        Toast.makeText(PayActivity.this, "支付成功", Toast.LENGTH_SHORT).show();
                        gotoActivity(CameraActivity.class);
                    } else {
                        // 判断resultStatus 为非"9000"则代表可能支付失败
                        // "8000"代表支付结果因为支付渠道原因或者系统原因还在等待支付结果确认，最终交易是否成功以服务端异步通知为准（小概率状态）
                        if (TextUtils.equals(resultStatus, "8000")) {
                            Toast.makeText(PayActivity.this, "支付结果确认中", Toast.LENGTH_SHORT).show();

                        } else {
                            // 其他值就可以判断为支付失败，包括用户主动取消支付，或者系统返回的错误
                            Toast.makeText(PayActivity.this, "支付失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                    break;
                }
                default:
                    break;
            }
        }

    };


    @Override
    protected int getLayoutID() {
        return R.layout.activity_pay;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected void initListener() {
        setOnClick(llAlipay);
        setOnClick(llWechatPay);
        presenter.initListener(this);
    }

    @Override
    protected void initData() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            mDoctor_name = extras.getString(Contacts.DOCTOR_NAME);
            mDoctorPic = extras.getString(Contacts.DOCTOR_PIC);
            mUser_time = (ArrayList<DoctorTime.UserTime>) extras.getSerializable(Contacts.DATE_SCOPE);
            mDay = extras.getString(Contacts.DATE_DAY);
            mTitle = extras.getString(Contacts.TITLE);
            mUid = extras.getInt(Contacts.UID);
            Glide.with(this).load(mDoctorPic).into(ivDoctorPic);
            tvDoctorName.setText(mDoctor_name);
            String s = mDay;
            for (int i = 0; i < mUser_time.size(); i++) {
                s  += "\n" + mUser_time.get(i);
            }
            tvDoctorTime.setText(s );
        } else {
            tvDoctorName.setVisibility(View.GONE);
            tvDoctorTime.setVisibility(View.GONE);
            ivDoctorPic.setVisibility(View.GONE);
        }
    }

    @Override
    public void processClick(View view) {
        switch (view.getId()) {
            case R.id.ll_alipay:
//                String orderInfo = getOrderInfo("医生服务", "医生服务医生服务", "0.01");
//                String sign = sign(orderInfo);
//                String payInfo = orderInfo + "&sign=\"" + sign + "\"&" + getSignType();

                boolean rsa2 = (RSA_PRIVATE.length() > 0);
                Map<String, String> params = OrderInfoUtil2_0.buildOrderParamMap(PARTNER, rsa2);
                String orderParam = OrderInfoUtil2_0.buildOrderParam(params);

                String sign = OrderInfoUtil2_0.getSign(params, RSA_PRIVATE, rsa2);
                final String orderInfo = orderParam + "&" + sign;


                Runnable payRunnable = new Runnable() {

                    @Override
                    public void run() {
                        PayTask alipay = new PayTask(PayActivity.this);
                        Map<String, String> result = alipay.payV2(orderInfo, true);
                        LogUtils.e("msp", result.toString());

                        Message msg = new Message();
                        msg.what = SDK_PAY_FLAG;
                        msg.obj = result;
                        mHandler.sendMessage(msg);
                    }
                };
                // 必须异步调用
                Thread payThread = new Thread(payRunnable);
                payThread.start();
                break;
            case R.id.ll_wechat_pay:
                inoutPsw();
                break;
        }
    }

    @Override
    public void refreshData() {

    }

    //打开输入密码的对话框
    public void inoutPsw() {
        menuWindow = new SelectPopupWindow(this, this);
        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int winHeight = getWindow().getDecorView().getHeight();
        menuWindow.showAtLocation(getWindow().getDecorView(), Gravity.BOTTOM, 0, winHeight - rect.bottom);
    }

    @Override
    public void onPopWindowClickListener(String psw, boolean complete) {
        if (complete) {
            ToastUtils.showShort("支付并预约成功");
            String s = "";
            for (int i = 0; i < mUser_time.size(); i++) {
                if (i == mUser_time.size() - 1) {
                    s += mUser_time.get(i);
                } else {
                    s += mUser_time.get(i) + "#";
                }
            }
            presenter.createOrder("name", mDay + "#" + s, "100", mUid, mDoctor_name);
            finish();
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    protected AppointSuccessPresenter initPresenter() {
        return new AppointSuccessPresenter();
    }

    @Override
    public void showAppointSuccess(OrderBean doclist) {
        LogUtils.e(doclist.toString());
        if (TextUtils.isEmpty(mTitle)) {
            finish();
        } else {
            gotoActivity(CameraActivity.class);
        }
    }

    @Override
    public void showAppointError(Throwable throwable) {
        ToastUtils.showShort("预约失败");
        throwable.printStackTrace();
    }
}
