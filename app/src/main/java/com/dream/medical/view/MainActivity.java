package com.dream.medical.view;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.dream.medical.R;
import com.dream.medical.base.BaseActivity;
import com.dream.medical.base.MVPActivity;
import com.dream.medical.interfaces.NoticeView;
import com.dream.medical.m.LiveBean;
import com.dream.medical.p.NoticePresenter;
import com.joker.api.Permissions4M;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends MVPActivity<NoticeView, NoticePresenter> implements NoticeView {

    @BindView(R.id.btn_doctor)
    Button btnDoctor;
    @BindView(R.id.btn_help)
    Button btnHelp;
    @BindView(R.id.btn_ask)
    Button btnAsk;
    @BindView(R.id.btn_call_help)
    Button btn_call_help;
    int AUDIO_CODE = 1000;
    public LocationClient mLocationClient = null;
    private MyLocationListener myListener = new MyLocationListener();

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected void initListener() {
        setOnClick(btnDoctor);
        setOnClick(btnHelp);
        setOnClick(btnAsk);
        setOnClick(btn_call_help);
        presenter.initListener(this);
        mLocationClient = new LocationClient(getApplicationContext());
        //声明LocationClient类
        mLocationClient.registerLocationListener(myListener);
        LocationClientOption option = new LocationClientOption();

        option.setIsNeedAddress(true);
        //可选，是否需要地址信息，默认为不需要，即参数为false
        //如果开发者需要获得当前点的地址信息，此处必须为true

        mLocationClient.setLocOption(option);
    }

    @Override
    protected void initData() {
        if (!selfPermissionGranted(Manifest.permission.CAMERA)) {
            Permissions4M.get(MainActivity.this)
                    // 是否强制弹出权限申请对话框，建议设置为 true，默认为 true
                    // .requestForce(true)
                    // 是否支持 5.0 权限申请，默认为 false
                    // .requestUnderM(false)
                    // 权限，单权限申请仅只能填入一个
                    .requestPermissions(Manifest.permission.CAMERA)
                    // 权限码
                    .requestCodes(AUDIO_CODE)
                    // 如果需要使用 @PermissionNonRationale 注解的话，建议添加如下一行
                    // 返回的 intent 是跳转至**系统设置页面**
                    // .requestPageType(Permissions4M.PageType.MANAGER_PAGE)
                    // 返回的 intent 是跳转至**手机管家页面**
                    // .requestPageType(Permissions4M.PageType.ANDROID_SETTING_PAGE)
                    .request();
        }
        if (!selfPermissionGranted(Manifest.permission.ACCESS_FINE_LOCATION)) {
            Permissions4M.get(MainActivity.this)
                    // 是否强制弹出权限申请对话框，建议设置为 true，默认为 true
                    // .requestForce(true)
                    // 是否支持 5.0 权限申请，默认为 false
                    // .requestUnderM(false)
                    // 权限，单权限申请仅只能填入一个
                    .requestPermissions(Manifest.permission.ACCESS_FINE_LOCATION)
                    // 权限码
                    .requestCodes(AUDIO_CODE)
                    // 如果需要使用 @PermissionNonRationale 注解的话，建议添加如下一行
                    // 返回的 intent 是跳转至**系统设置页面**
                    // .requestPageType(Permissions4M.PageType.MANAGER_PAGE)
                    // 返回的 intent 是跳转至**手机管家页面**
                    // .requestPageType(Permissions4M.PageType.ANDROID_SETTING_PAGE)
                    .request();
        }
        if (!selfPermissionGranted(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Permissions4M.get(MainActivity.this)
                    // 是否强制弹出权限申请对话框，建议设置为 true，默认为 true
                    // .requestForce(true)
                    // 是否支持 5.0 权限申请，默认为 false
                    // .requestUnderM(false)
                    // 权限，单权限申请仅只能填入一个
                    .requestPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    // 权限码
                    .requestCodes(AUDIO_CODE)
                    // 如果需要使用 @PermissionNonRationale 注解的话，建议添加如下一行
                    // 返回的 intent 是跳转至**系统设置页面**
                    // .requestPageType(Permissions4M.PageType.MANAGER_PAGE)
                    // 返回的 intent 是跳转至**手机管家页面**
                    // .requestPageType(Permissions4M.PageType.ANDROID_SETTING_PAGE)
                    .request();
        }
    }

    public boolean selfPermissionGranted(String permission) {
        boolean result = true;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (getApplicationInfo().targetSdkVersion >= Build.VERSION_CODES.M) {
                result = this.checkSelfPermission(permission)
                        == PackageManager.PERMISSION_GRANTED;
            } else {
                result = PermissionChecker.checkSelfPermission(this, permission)
                        == PermissionChecker.PERMISSION_GRANTED;
            }
        }
        return result;
    }

    @Override
    public void processClick(View view) {
        switch (view.getId()) {
            case R.id.btn_doctor:
                gotoActivity(DoctorActivity.class);
                break;
            case R.id.btn_help:
                gotoActivity(BaiduMapActivity.class);
                break;
            case R.id.btn_ask:
                ToastUtils.showShort("该模块正在开发");
                break;
            case R.id.btn_call_help:
                if (selfPermissionGranted(Manifest.permission.ACCESS_FINE_LOCATION)) {
                    mLocationClient.start();
                }else{
                    presenter.sendNotices("", "快来人，我需要帮助",  "附近有人发送了呼救信息，快去看看吧！");
                }
                break;

        }
    }

    @Override
    public void refreshData() {

    }

    @Override
    protected NoticePresenter initPresenter() {
        return new NoticePresenter();
    }

    @Override
    public void showNoticeSuccess() {
        ToastUtils.showShort("发送急救消息成功");
    }

    @Override
    public void showNoticeError(Throwable throwable) {
        ToastUtils.showShort("发送急救消息失败");
    }

    @Override
    public void getLiveUrlSuccess(LiveBean liveBean) {

    }

    @Override
    public void getLiveUrlError(Throwable throwable) {

    }

    public class MyLocationListener extends BDAbstractLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
            LogUtils.e("2222222222222222222222222");
            String addr = location.getAddrStr();    //获取详细地址信息
            String country = location.getCountry();    //获取国家
            String province = location.getProvince();    //获取省份
            String city = location.getCity();    //获取城市
            String district = location.getDistrict();    //获取区县
            String street = location.getStreet();    //获取街道信息
            LogUtils.e(addr + country + province + city + district + street);
            if (!TextUtils.isEmpty(street)) {
                presenter.sendNotices("", "快来人，我需要帮助", street + "附近有人发送了呼救信息，快去看看吧！");
            } else if (!TextUtils.isEmpty(district)) {
                presenter.sendNotices("", "快来人，我需要帮助", district + "附近有人发送了呼救信息，快去看看吧！");
            } else {
                presenter.sendNotices("", "快来人，我需要帮助", addr + "附近有人发送了呼救信息，快去看看吧！");
            }
            mLocationClient.stop();
        }
    }
}
