package com.dream.medical.view;

import android.Manifest;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.PermissionChecker;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.dream.medical.R;
import com.dream.medical.base.MVPActivity;
import com.dream.medical.interfaces.NoticeView;
import com.dream.medical.m.LiveBean;
import com.dream.medical.p.NoticePresenter;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

public class CameraActivity extends MVPActivity<NoticeView, NoticePresenter> implements SurfaceHolder.Callback, NoticeView {
    @BindView(R.id.sv_camera)
    SurfaceView svCamera;
    @BindView(R.id.et_sendMsg)
    EditText et_sendMsg;
    @BindView(R.id.btn_send)
    Button btn_send;
    @BindView(R.id.videoplayer)
    JzvdStd videoplayer;

    private SurfaceHolder mHolder;
    private Camera camera;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_camera;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
        //获得句柄
        mHolder = svCamera.getHolder();
        mHolder.addCallback(this);//添加回调
        mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);//surfaceview不维护自己的缓冲区，等待屏幕渲染引擎将内容推送到用户面前
    }

    @Override
    protected void initListener() {
        setOnClick(btn_send);
        presenter.initListener(this);
    }

    @Override
    protected void initData() {
        presenter.getLiveAddress();
    }

    @Override
    public void processClick(View view) {
        switch (view.getId()) {
            case R.id.btn_send:
                if (TextUtils.isEmpty(et_sendMsg.getText().toString().trim())) {
                    ToastUtils.showShort("消息不能为空");
                    return;
                }
                presenter.sendNotices("", "来自患者的消息", et_sendMsg.getText().toString().trim());
                break;
        }
    }

    @Override
    public void refreshData() {

    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
// TODO Auto-generated method stub
        //当surfaceview创建时开启相机
        if (selfPermissionGranted(Manifest.permission.CAMERA)) {
            if (camera == null) {
                camera = Camera.open(1);
                camera.setDisplayOrientation(90);
                try {
                    camera.setPreviewDisplay(mHolder);//通过surfaceview显示取景画面
                    camera.startPreview();//开始预览
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } else {
            ToastUtils.showShort("您没有允许摄像头权限,无法开启问诊,请到设置页面授权");
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
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        camera.stopPreview();
        camera.release();
        camera = null;
        mHolder = null;
        svCamera = null;
    }

    @Override
    protected NoticePresenter initPresenter() {
        return new NoticePresenter();
    }

    @Override
    public void showNoticeSuccess() {
        ToastUtils.showShort("发送消息成功");
        et_sendMsg.setText("");
    }

    @Override
    public void showNoticeError(Throwable throwable) {
        ToastUtils.showShort("发送消息失败");
    }

    @Override
    public void getLiveUrlSuccess(LiveBean liveBean) {
        String url = liveBean.list.get(0).url;
        LogUtils.e(liveBean.list.get(0).url);
        if(TextUtils.isEmpty(url)){
            //http://devimages.apple.com/iphone/samples/bipbop/bipbopall.m3u8
            videoplayer.setUp("http://devimages.apple.com/iphone/samples/bipbop/bipbopall.m3u8",
                    "与医生对话中", Jzvd.SCREEN_WINDOW_NORMAL);
        }else{
            videoplayer.setUp(url,
                    "与医生对话中", Jzvd.SCREEN_WINDOW_NORMAL);
        }
        videoplayer.bottomProgressBar.setVisibility(View.GONE);
        videoplayer.startButton.performClick();
    }

    @Override
    public void getLiveUrlError(Throwable throwable) {
        videoplayer.setUp("http://devimages.apple.com/iphone/samples/bipbop/bipbopall.m3u8",
                "与医生对话中", Jzvd.SCREEN_WINDOW_NORMAL);
        videoplayer.bottomProgressBar.setVisibility(View.GONE);
        videoplayer.startButton.performClick();
    }

    @Override
    public void onBackPressed() {
        if (Jzvd.backPress()) {
            return;
        }
        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        Jzvd.releaseAllVideos();
    }
}
