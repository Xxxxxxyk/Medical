package com.dream.medical.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.dream.medical.R;
import com.dream.medical.base.BaseActivity;
import com.dream.medical.base.MVPActivity;
import com.dream.medical.interfaces.BaiduView;
import com.dream.medical.m.Bus120;
import com.dream.medical.m.Call120;
import com.dream.medical.p.BaiduPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 惜梦_ on 2018/10/3.
 */

public class BaiduMapActivity extends MVPActivity<BaiduView, BaiduPresenter> implements BaiduView {
    @BindView(R.id.bmapView)
    MapView mBmapView;
    @BindView(R.id.btn_call120)
    Button mBtnCall120;

    private BaiduMap mBaiduMap;
    public LocationClient mLocationClient = null;
    private MyLocationListener myListener = new MyLocationListener();


    @Override
    protected int getLayoutID() {
        return R.layout.activity_baidumap;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mBaiduMap = mBmapView.getMap();
        mBaiduMap.getUiSettings().setOverlookingGesturesEnabled(false);
        mBaiduMap.getUiSettings().setRotateGesturesEnabled(false);
        mBaiduMap.setMyLocationEnabled(true);
    }

    @Override
    protected void initListener() {
        mLocationClient = new LocationClient(getApplicationContext());
        //声明LocationClient类
        mLocationClient.registerLocationListener(myListener);
        mLocationClient.start();
        presenter.initListener(this);
        setOnClick(mBtnCall120);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void processClick(View view) {
        switch (view.getId()) {
            case R.id.btn_call120:
                presenter.call120();
                break;
        }
    }

    @Override
    public void refreshData() {

    }

    @Override
    protected BaiduPresenter initPresenter() {
        return new BaiduPresenter();
    }

    @Override
    public void get120Success(Bus120 bus120) {
        LogUtils.e(bus120.bus);
        for (int i = 0; i < bus120.bus.size(); i++) {
            String s = bus120.bus.get(i);
            String[] split = s.split(",");
            mBaiduMap.addOverlay(new MarkerOptions().position(new LatLng(Double.parseDouble(split[0]),Double.parseDouble(split[1]))).icon(BitmapDescriptorFactory.fromResource(R.mipmap.bus120)));
        }
    }

    @Override
    public void get120Error(Throwable throwable) {
        ToastUtils.showShort("获取附近救护车失败");
        throwable.printStackTrace();
    }

    @Override
    public void call120Success(Call120 call120) {
        LogUtils.e(call120.ambulance);
        ToastUtils.showShort("呼叫救护车成功");
        gotoActivity(Picture1Activity.class);
    }

    @Override
    public void call120Error(Throwable throwable) {
        ToastUtils.showShort("呼叫救护车失败");
    }

    class MyLocationListener implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            LocationClientOption option = new LocationClientOption();
            option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
            option.setOpenGps(true);
            mLocationClient.stop();
            // 开启定位图层
            mBaiduMap.setMyLocationEnabled(true);

            // 构造定位数据
            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(bdLocation.getRadius())
                    .latitude(bdLocation.getLatitude())
                    .longitude(bdLocation.getLongitude()).build();

            // 设置定位数据
            mBaiduMap.setMyLocationData(locData);
            MapStatus.Builder builder = new MapStatus.Builder();
            builder.target(new LatLng(bdLocation.getLatitude(), bdLocation.getLongitude()));
            mBaiduMap.setMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
            LogUtils.e(bdLocation.getLatitude() + "," + bdLocation.getLongitude());
            presenter.get120Info(bdLocation.getLatitude() + "," + bdLocation.getLongitude());
        }
    }
}
