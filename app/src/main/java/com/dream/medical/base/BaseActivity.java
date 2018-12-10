package com.dream.medical.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alipay.sdk.app.EnvUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener, BaseView {

    private long lastClick = 0;
    private Unbinder unbinder;
    private View mDataNullView;
    private View mNetWordErrorView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        EnvUtils.setEnv(EnvUtils.EnvEnum.SANDBOX);
        super.onCreate(savedInstanceState);
        View inflate = LayoutInflater.from(this).inflate(getLayoutID(), null);
        setContentView(inflate);
        //可以在这里加上 ButterKnife
        unbinder = ButterKnife.bind(this);
        initView(savedInstanceState);
        initListener();
        initData();
    }

    protected abstract int getLayoutID();

    protected abstract void initView(Bundle savedInstanceState);

    protected abstract void initListener();

    protected abstract void initData();

    /**
     * 打开一个Activity 默认 不关闭当前activity
     */
    public void gotoActivity(Class<?> clz) {
        gotoActivity(clz, false, null);
    }

    /**
     * 打开,关闭
     *
     * @param clz 对应Activity
     */
    public void gotoActivity(Class<?> clz, Bundle ex) {
        gotoActivity(clz, false, ex);
    }

    /**
     * 打开,关闭
     *
     * @param clz                    对应Activity
     * @param isCloseCurrentActivity 是否关闭标识
     */
    public void gotoActivity(Class<?> clz, boolean isCloseCurrentActivity) {
        gotoActivity(clz, isCloseCurrentActivity, null);
    }

    public void gotoActivity(Class<?> clz, boolean isCloseCurrentActivity, Bundle ex) {
        Intent intent = new Intent(this, clz);
        if (ex != null) intent.putExtras(ex);
        startActivity(intent);
        if (isCloseCurrentActivity) {
            finish();
        }
    }

    public void gotoActivity(Class<?> clz, boolean isCloseCurrentActivity, Bundle ex, boolean anim) {
        Intent intent = new Intent(this, clz);
        if (ex != null) intent.putExtras(ex);
        startActivity(intent);
        if (isCloseCurrentActivity) {
            finish();
        }
        if (anim) {
            overridePendingTransition(0, 0);
        }
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(ViewGroup viewGroup) {

    }

    @Override
    public void hideError(ViewGroup viewGroup) {

    }

    @Override
    public void showDataNull(ViewGroup viewGroup) {

    }

    @Override
    public void hideDataNull(ViewGroup viewGroup) {

    }

    /**
     * View设置OnClick事件
     */
    public <E extends View> void setOnClick(E view) {
        view.setOnClickListener(this);
    }

    /**
     * 防止用户点击过快出现页面多次创建，或者数据多次请求等个方面的问题
     *
     * @return 当前是否可以点击 true可以点击 false不可以点击
     */
    private boolean fastClick() {
        if (System.currentTimeMillis() - lastClick <= 300) {
            return false;
        }
        lastClick = System.currentTimeMillis();
        return true;
    }

    @Override
    public void onClick(View v) {
        if (fastClick()) {
            switch (v.getId()) {
                default:
                    processClick(v);
                    break;
            }
        }
    }

    /**
     * 其他控件的点击事件
     *
     * @param view 点击的控件
     */
    public abstract void processClick(View view);

    /**
     * 失败按钮的点击事件
     */
    public abstract void refreshData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解除对应绑定
        unbinder.unbind();
    }

}
