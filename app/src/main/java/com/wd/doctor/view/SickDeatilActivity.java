package com.wd.doctor.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.R;
import com.wd.doctor.base.BaseActivity;
import com.wd.doctor.base.BasePresenter;
import com.wd.doctor.bean.SickCircleBean;
import com.wd.doctor.contract.IContract;
import com.wd.doctor.presenter.IPresenter;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SickDeatilActivity extends BaseActivity implements IContract.IViewSickCircle {


    @BindView(R.id.parti_back)
    ImageView partiBack;
    @BindView(R.id.parti_title)
    TextView partiTitle;
    @BindView(R.id.parti_name)
    TextView partiName;
    @BindView(R.id.parti_disease)
    TextView partiDisease;
    @BindView(R.id.parti_subject)
    TextView partiSubject;
    @BindView(R.id.parti_bing)
    TextView partiBing;
    @BindView(R.id.hospital_address)
    TextView hospitalAddress;
    @BindView(R.id.zhiliaotime)
    TextView zhiliaotime;
    @BindView(R.id.party_time)
    RelativeLayout partyTime;
    @BindView(R.id.zhiliaojingli)
    TextView zhiliaojingli;
    @BindView(R.id.parti_image)
    SimpleDraweeView partiImage;
    @BindView(R.id.part_xiang)
    TextView partXiang;
    @BindView(R.id.bt_ling)
    Button btLing;
    @BindView(R.id.part_edit)
    EditText partEdit;
    @BindView(R.id.partysend)
    ImageView partysend;
    @BindView(R.id.h_text)
    TextView hText;
    @BindView(R.id.partlinear)
    LinearLayout partlinear;
    private IPresenter presenter;

    @Override
    protected void initData() {
        presenter = (IPresenter) p;
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String title = extras.getString("title");
        int sickCircleId = extras.getInt("sickCircleId");
        partiTitle.setText(title);

        presenter.getSickCirclees(sickCircleId);

    }

    @Override
    protected void initView() {
        partiBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected BasePresenter providePresenter() {
        return new IPresenter();
    }

    @Override
    protected int provideLayoutIds() {
        return R.layout.activity_sick_deatil;
    }

    @Override
    public void sickCircleSuccess(SickCircleBean sickCircleBean) {
        String departmentName = sickCircleBean.getResult().getDepartmentName();
        String authorName = sickCircleBean.getResult().getAuthorName();
        String detail = sickCircleBean.getResult().getDetail();
        String disease = sickCircleBean.getResult().getDisease();
        String picture = sickCircleBean.getResult().getPicture();
        String treatmentHospital = sickCircleBean.getResult().getTreatmentHospital();
        long treatmentEndTime = sickCircleBean.getResult().getTreatmentEndTime();
        String treatmentProcess = sickCircleBean.getResult().getTreatmentProcess();
        Date date = new Date(treatmentEndTime);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        zhiliaotime.setText(format.format(date));
        zhiliaojingli.setText(treatmentProcess);
        hospitalAddress.setText(treatmentHospital);
        partiImage.setImageURI(picture);
        partiDisease.setText(disease);
        partiBing.setText(detail);
        partiName.setText(authorName);

        partiSubject.setText(departmentName);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
