package com.wd.doctor.app;

import android.app.Application;
import android.os.Environment;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

/**
 * @ProjectName: Health_Doctor
 * @Package: com.wd.doctor.app
 * @ClassName: App
 * @Author: YuYanHe
 * @CreateDate: 2020/1/9 10:29
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DiskCacheConfig image = DiskCacheConfig.newBuilder(this)
                .setBaseDirectoryName("image")
                .setBaseDirectoryPath(Environment.getExternalStorageDirectory())
                .build();
        ImagePipelineConfig build = ImagePipelineConfig.newBuilder(this)
                .setMainDiskCacheConfig(image).build();
        Fresco.initialize(this, build);
    }
}
