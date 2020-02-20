package com.wd.doctor.utils;

import com.wd.doctor.bean.AvatarBean;
import com.wd.doctor.bean.SettleinBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * @ProjectName: Health_Doctor
 * @Package: com.wd.doctor.utils
 * @ClassName: HealthDoctor
 * @Author: YuYanHe
 * @CreateDate: 2020/2/19 13:51
 */
public interface HealthDoctor {
    //查询系统形象照
    @GET("doctor/v1/findSystemImagePic")
    Observable<AvatarBean> getAvatar();

    //申请入驻
    @POST("doctor/v1/applyJoin")
    Observable<SettleinBean> getSettlein(@Field("email") String email, @Field("code") String code
            , @Field("pwd1") String pwd1, @Field("pwd2") String pwd2, @Field("name") String name
            , @Field("inauguralHospital") String inauguralHospital, @Field("departmentId") int departmentId
            , @Field("jobTitleId") int jobTitleId, @Field("personalProfile") String personalProfile
            , @Field("goodField") String goodField);
}
