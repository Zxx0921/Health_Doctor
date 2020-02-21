package com.wd.doctor.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.doctor.R;
import com.wd.doctor.adapter.PatientAdapter;
import com.wd.doctor.base.BaseActivity;
import com.wd.doctor.base.BasePresenter;
import com.wd.doctor.bean.PatientBean;
import com.wd.doctor.contract.IContract;
import com.wd.doctor.presenter.IPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AnswerActivity extends BaseActivity implements IContract.IViewPatient {


    @BindView(R.id.anwser_back)
    ImageView anwserBack;
    @BindView(R.id.anser_clock)
    ImageView anserClock;
    @BindView(R.id.answertoprec)
    RecyclerView answertoprec;
    @BindView(R.id.answer_search)
    ImageView answerSearch;
    @BindView(R.id.answerbottomrec)
    RecyclerView answerbottomrec;

    @Override
    protected void initData() {
        anwserBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        IPresenter presenter = (IPresenter) p;
        presenter.getPatient(2, 1, 10);
    }

    @Override
    protected void initView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        answerbottomrec.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected BasePresenter providePresenter() {
        return new IPresenter();
    }

    @Override
    protected int provideLayoutIds() {
        return R.layout.activity_answer;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void patientSuccess(PatientBean patientBean) {
        List<PatientBean.ResultBean> list = patientBean.getResult();
        PatientAdapter patientAdapter = new PatientAdapter(list, AnswerActivity.this);
        answerbottomrec.setAdapter(patientAdapter);
    }
}
