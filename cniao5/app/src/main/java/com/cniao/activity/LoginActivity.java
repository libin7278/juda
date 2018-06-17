package com.cniao.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.cniao.CNiaoApplication;
import com.cniao.R;
import com.cniao.bean.User;
import com.cniao.utils.ToastUtils;
import com.cniao.widget.CNiaoToolBar;
import com.cniao.widget.ClearEditText;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 高磊华
 * Time  2017/8/9
 * Describe: 登录界面
 */

public class LoginActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    CNiaoToolBar mToolBar;
    @BindView(R.id.etxt_phone)
    ClearEditText mEtxtPhone;
    @BindView(R.id.etxt_pwd)
    ClearEditText mEtxtPwd;
    @BindView(R.id.txt_toReg)
    TextView mTxtToReg;
    @BindView(R.id.tv_forget)
    TextView tv_forget;

    @Override
    protected void init() {
        initToolBar();
    }

    @Override
    protected int getContentResourseId() {
        return R.layout.activity_login;
    }

    private void initToolBar() {

        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity.this.finish();
            }
        });
    }


    @OnClick({R.id.btn_login, R.id.txt_toReg, R.id.tv_forget})
    public void viewclick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                login();   //登录
                break;
            case R.id.txt_toReg:
                Intent intent = new Intent(this, RegActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_forget:
                Intent intent1 = new Intent(this, RegSecondActivity.class);
                startActivity(intent1);
                break;
        }
    }

    /**
     * 登录
     */
    private void login() {

        String phone = mEtxtPhone.getText().toString().trim();
        if (TextUtils.isEmpty(phone)) {
            ToastUtils.showSafeToast(LoginActivity.this, "请输入手机号码");
            return;
        }

        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
        if (phone.length() != 11) {
            ToastUtils.showSafeToast(LoginActivity.this, "手机号应为11位数");
            return;
        }

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(phone);
        boolean isMatch = m.matches();
        if (!isMatch) {
            ToastUtils.showSafeToast(LoginActivity.this, "您的手机号" + phone + "是错误格式！！！");
            return;
        }

        String pwd = mEtxtPwd.getText().toString().trim();
        if (TextUtils.isEmpty(pwd)) {
            ToastUtils.showSafeToast(LoginActivity.this, "请输入密码");
            return;
        }

        String[] names = {"星空", "先知", "火山", "惧沓", "美丽小姐姐", "帅气小哥哥", "随风洒", "美男子"};
        CNiaoApplication application = CNiaoApplication.getInstance();
        String url = "http://up.qqjia.com/z/18/tu20457_2.jpg";
        String name = names[new Random().nextInt(8)];
        User user = new User(Long.parseLong(mEtxtPhone.getText().toString().trim()),
                "123456@qq.com",
                url,
                name,
                mEtxtPhone.getText().toString().trim());
        application.putUser(user, mEtxtPhone.getText().toString().trim());
        if (application.getIntent() == null) {
            setResult(RESULT_OK);
            finish();
        } else {
            application.jumpToTargetActivity(LoginActivity.this);
            finish();
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}
