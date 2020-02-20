package com.wd.doctor.bean;

import java.util.List;

/**
 * @ProjectName: Health_Doctor
 * @Package: com.wd.doctor.bean
 * @ClassName: AvatarBean  头像类
 * @Author: YuYanHe
 * @CreateDate: 2020/2/19 13:47
 */
public class AvatarBean {


    private List<ResultBean> result;

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        private String imagePic;

        public String getImagePic() {
            return imagePic;
        }

        public void setImagePic(String imagePic) {
            this.imagePic = imagePic;
        }
    }
}
