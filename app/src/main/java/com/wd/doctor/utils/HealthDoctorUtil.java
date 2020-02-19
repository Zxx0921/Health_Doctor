package com.wd.doctor.utils;

import com.wd.doctor.api.Api;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @ProjectName: Health_Doctor
 * @Package: com.wd.doctor.utils
 * @ClassName: HealthDoctorUtil
 * @Author: YuYanHe
 * @CreateDate: 2020/2/12 11:11
 */
public class HealthDoctorUtil {
    public static HealthDoctorUtil doctorUtil;
    OkHttpClient okHttpClient;
    Retrofit retrofit;

    private HealthDoctorUtil() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .build();
        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static synchronized HealthDoctorUtil getInstance() {
        if (doctorUtil == null) {
            synchronized (HealthDoctorUtil.class) {
                if (doctorUtil == null) {
                    doctorUtil = new HealthDoctorUtil();
                }
            }
        }

        return doctorUtil;
    }

    public <T> T getCreateServer(Class<T> clz) {
        return retrofit.create(clz);
    }
}
