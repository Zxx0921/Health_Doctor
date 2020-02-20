package com.wd.doctor.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.wd.doctor.R;
import com.wd.doctor.base.BaseActivity;
import com.wd.doctor.base.BasePresenter;
import com.wd.doctor.presenter.IPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity {


    @BindView(R.id.login_imageemail)
    ImageView loginImageemail;
    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.login_lockemail)
    ImageView loginLockemail;
    @BindView(R.id.et_lock)
    EditText etLock;
    @BindView(R.id.forgetpwd)
    TextView forgetpwd;
    @BindView(R.id.requestgo)
    TextView requestgo;
    @BindView(R.id.bt_login)
    Button btLogin;

    @Override
    protected void initData() {
        requestgo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SettleinActivity.class));
            }
        });
    }

    @Override
    protected void initView() {

    }

    @Override
    protected BasePresenter providePresenter() {
        return new IPresenter();
    }

    @Override
    protected int provideLayoutIds() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
