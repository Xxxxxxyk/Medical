package com.dream.medical.view;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.dream.medical.R;
import com.dream.medical.base.MVPActivity;
import com.dream.medical.interfaces.LoginView;
import com.dream.medical.m.LoginBean;
import com.dream.medical.p.LoginPresenter;
import com.dream.medical.utils.Contacts;


import butterknife.BindView;

public class LoginActivity extends MVPActivity<LoginView, LoginPresenter> implements TextWatcher, LoginView, View.OnFocusChangeListener {

    @BindView(R.id.rl_layout)
    RelativeLayout rlLayout;
    @BindView(R.id.ll_layout)
    LinearLayout llLayout;
    @BindView(R.id.et_name)
    ClearEditText etName;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.iv_look_password)
    ImageView ivLookPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_register)
    Button btnRegister;

    private Drawable invisibilityDrawable;
    private Drawable visibilityDrawable;
    private String userName;
    private String userPassword;
    boolean hasFocus;
    private SPUtils spUtils;

    @Override
    protected LoginPresenter initPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected void initListener() {
        KeyboardUtils.showSoftInput(this);
        etPassword.setOnFocusChangeListener(this);
        etPassword.addTextChangedListener(this);
        setOnClick(ivLookPassword);
        setOnClick(btnLogin);
        setOnClick(btnRegister);
        //触摸外部，键盘消失
        rlLayout.setOnTouchListener((v, event) -> {
//            Utils.closeKeyboard(LoginActivity.this);
            KeyboardUtils.hideSoftInput(etPassword);
            return false;
        });
    }

    @Override
    protected void initData() {
        spUtils = SPUtils.getInstance(Contacts.SP_NAME);

        if (spUtils.contains(Contacts.TOKEN)) {
            gotoActivity(MainActivity.class, true);
        }

        invisibilityDrawable = getResources().getDrawable(R.mipmap.login_input_ciphertext);
        visibilityDrawable = getResources().getDrawable(R.mipmap.login_input_clear);
        ivLookPassword.setImageDrawable(invisibilityDrawable);
        ivLookPassword.setVisibility(View.GONE);

        etPassword.setInputType(129);
        setEditTextInhibitInputSpace(etName);
        setEditTextInhibitInputSpace(etPassword);
    }

    private void setEditTextInhibitInputSpace(EditText etInput) {
        //调起软键盘
        KeyboardUtils.showSoftInput(this);
        InputFilter filter = (source, start, end, dest, dstart, dend) -> {
            if (source.equals(" ")) {
                return "";
            } else {
                return null;
            }
        };
        etInput.setFilters(new InputFilter[]{filter});
    }

    @Override
    public void processClick(View view) {
        switch (view.getId()) {
            case R.id.iv_look_password://密码是否可见 setVisibility
                if (etPassword.getInputType() == 129) {//密码可见
                    etPassword.setInputType(145);
                    ivLookPassword.setImageDrawable(visibilityDrawable);
                } else {//密码不见
                    etPassword.setInputType(129);
                    ivLookPassword.setImageDrawable(invisibilityDrawable);
                }
                etPassword.setSelection(etPassword.length());//将光标移至文字末尾
                break;
            case R.id.btn_login://登录按钮
                userName = etName.getText().toString().trim();
                if (TextUtils.isEmpty(userName)) {
                    ToastUtils.showShort("请输入账号");
                    return;
                }
                userPassword = etPassword.getText().toString().trim();
                if (TextUtils.isEmpty(userPassword)) {
                    ToastUtils.showShort("请输入密码");
                    return;
                }
                presenter.loadLoginData(userName, userPassword);
                showProgress();
                break;
            case R.id.btn_register:
                gotoActivity(RegisterActivity.class,true);
                break;
        }
    }

    @Override
    public void refreshData() {
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        this.hasFocus = hasFocus;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (hasFocus)
            setIsIconVisible(s.length() > 0);
    }

    private void setIsIconVisible(boolean b) {
        if (b) {//登录按钮可以点击，密码是否可见的控件可以展示
        ivLookPassword.setVisibility(View.VISIBLE);
        } else {//登录按钮不可以点击，密码是否可见的控件不可以展示
        ivLookPassword.setVisibility(View.GONE);
        }
        }

@Override
public void afterTextChanged(Editable s) {

        }

@Override
public void loginNetWorkShowSuccessData(LoginBean loginResponseBean) {
        if (TextUtils.isEmpty(loginResponseBean.msg)) {
        ToastUtils.showShort("登录成功");
        spUtils.put(Contacts.TOKEN, loginResponseBean.token);
        gotoActivity(MainActivity.class, true);
        } else {
        ToastUtils.showShort(loginResponseBean.msg);
        }
        }

@Override
public void loginNetWorkError(Throwable throwable) {
        ToastUtils.showShort("登录失败,请检查网络连接");
        }
        }
