package com.wd.doctor.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.doctor.R;
import com.wd.doctor.adapter.DepartmentAdapter;
import com.wd.doctor.adapter.PatientAdapter;
import com.wd.doctor.base.BaseActivity;
import com.wd.doctor.base.BasePresenter;
import com.wd.doctor.bean.DepartmentBean;
import com.wd.doctor.bean.PatientBean;
import com.wd.doctor.contract.IContract;
import com.wd.doctor.presenter.IPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AnswerActivity extends BaseActivity implements IContract.IViewPatient, IContract.IViewDepartment {


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
    private PatientAdapter patientAdapter;
    private DepartmentAdapter departmentAdapter;
    private int id;
    private IPresenter presenter;

    @Override
    protected void initData() {
        anwserBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        presenter = (IPresenter) p;
        presenter.getDepartment();
        presenter.getPatient(3, 1, 10);

        answerSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnswerActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        answerbottomrec.setLayoutManager(linearLayoutManager);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this);
        linearLayoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        answertoprec.setLayoutManager(linearLayoutManager1);
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
        patientAdapter = new PatientAdapter(list, AnswerActivity.this);
        answerbottomrec.setAdapter(patientAdapter);
        patientAdapter.setPatientAdapter(new PatientAdapter.patientAdapter() {
            @Override
            public void callBack(int position) {
                int sickCircleId = list.get(position).getSickCircleId();
                String title = list.get(position).getTitle();
                Intent intent = new Intent(AnswerActivity.this, SickDeatilActivity.class);
                intent.putExtra("sickCircleId", sickCircleId);
                intent.putExtra("title", title);
                startActivity(intent);
            }
        });
    }

    @Override
    public void departmentSuccess(DepartmentBean departmentBean) {
        List<DepartmentBean.ResultBean> result = departmentBean.getResult();
        departmentAdapter = new DepartmentAdapter(result, AnswerActivity.this);
        answertoprec.setAdapter(departmentAdapter);
        departmentAdapter.setDepartmentAdapter(new DepartmentAdapter.departmentAdapter() {
            @Override
            public void callBack(int i) {
                id = result.get(i).getId();
                presenter.getPatient(id, 1, 10);
            }
        });
    }
}
