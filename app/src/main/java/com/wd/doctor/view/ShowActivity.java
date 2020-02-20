package com.wd.doctor.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.doctor.R;
import com.wd.doctor.base.BaseActivity;
import com.wd.doctor.base.BasePresenter;
import com.wd.doctor.bean.AvatarBean;
import com.wd.doctor.contract.IContract;
import com.wd.doctor.presenter.IPresenter;

import java.net.URI;
import java.util.Timer;
import java.util.TimerTask;

public class ShowActivity extends BaseActivity implements IContract.IViewAvatar {
    SimpleDraweeView show_doctorimage;
    private String imagePic;

    @Override
    protected void initData() {
        IPresenter presenter = (IPresenter) p;
        presenter.getAvatars();
    }

    @Override
    protected void initView() {
        show_doctorimage = findViewById(R.id.show_doctorimage);
    }

    @Override
    protected BasePresenter providePresenter() {
        return new IPresenter();
    }

    @Override
    protected int provideLayoutIds() {
        return R.layout.activity_show;
    }


    boolean isState = true;

    public void onBackPressed() {
        if (isState) {
            isState = false;
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    isState = true;
                }
            }, 2000);
        } else {
            finish();
        }
    }

    @Override
    public void avatarSuccess(AvatarBean avatarBean) {
        Log.i("aaa", "avatarSuccess: " + avatarBean);
        for (int i = 0; i < 1; i++) {
            imagePic = avatarBean.getResult().get(i).getImagePic();
        }
        show_doctorimage.setImageURI(imagePic);
    }
}
