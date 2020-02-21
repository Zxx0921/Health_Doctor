package com.wd.doctor.presenter;

import com.wd.doctor.base.BasePresenter;
import com.wd.doctor.bean.AvatarBean;
import com.wd.doctor.bean.PatientBean;
import com.wd.doctor.contract.IContract;
import com.wd.doctor.model.IModel;
import com.wd.doctor.view.AnswerActivity;
import com.wd.doctor.view.ShowActivity;

/**
 * @ProjectName: Health_Doctor
 * @Package: com.wd.doctor.presenter
 * @ClassName: IPresenter
 * @Author: YuYanHe
 * @CreateDate: 2020/1/8 18:48
 */
public class IPresenter extends BasePresenter {
    IModel model;

    public IPresenter() {
        model = new IModel();
    }

    //查询系统形象照
    public void getAvatars() {
        model.getAvatar(new IContract.IModelAvatar() {
            @Override
            public void avatarsSuccess(AvatarBean avatarBean) {
                ShowActivity showActivity = (ShowActivity) v;
                showActivity.avatarSuccess(avatarBean);
            }
        });
    }
    //病友圈列表展示
    public void getPatient(int departmentId, int page, int count) {
        model.getPatient(departmentId, page, count, new IContract.IModelPatient() {
            @Override
            public void patientsSuccess(PatientBean patientBean) {
                AnswerActivity answerActivity = (AnswerActivity) v;
                answerActivity.patientSuccess(patientBean);
            }
        });
    }
}
