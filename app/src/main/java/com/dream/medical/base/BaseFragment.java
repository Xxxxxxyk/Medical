package com.dream.medical.base;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment implements BaseView, View.OnClickListener {

    private long lastClick = 0;

    private Unbinder bind;
    private View mNetWorkErrorView;
    private View mDataNullView;
    protected View convertView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        convertView = inflater.inflate(getLayoutId(), container, false);
        bind = ButterKnife.bind(this, convertView);
        initListener();
        initData();
        return convertView;
    }

    /**
     * 是否注册事件分发
     *
     * @return true绑定EventBus事件分发，默认不绑定，子类需要绑定的话复写此方法返回true.
     */
    protected boolean isRegisterEventBus() {
        return false;
    }

    /**
     * 加载页面布局文件
     *
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 设置监听器
     */
    protected abstract void initListener();

    /**
     * 加载要显示的数据
     */
    protected abstract void initData();

    /**
     * 打开一个Activity 默认 不关闭当前activity
     *
     * @param clz
     */
    public void gotoActivity(Class<?> clz) {
        gotoActivity(clz, false, null);
    }

    public void gotoActivity(Class<?> clz, boolean isCloseCurrentActivity) {
        gotoActivity(clz, isCloseCurrentActivity, null);
    }

    public void gotoActivity(Class<?> clz, Bundle bundle) {
        gotoActivity(clz, false, bundle);
    }

    public void gotoActivity(Class<?> clz, boolean isCloseCurrentActivity, Bundle ex) {
        Intent intent = new Intent(getActivity(), clz);
        if (ex != null)
            intent.putExtras(ex);
        startActivity(intent);
        if (isCloseCurrentActivity) {
            getActivity().finish();
        }
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @SuppressLint("InflateParams")
    @Override
    public void showError(ViewGroup viewGroup) {

    }

    @Override
    public void hideError(ViewGroup viewGroup) {

    }


    @SuppressLint("InflateParams")
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
     * @return
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
    public void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }

}
