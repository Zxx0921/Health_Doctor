package com.wd.doctor.contract;

import com.wd.doctor.bean.AvatarBean;
import com.wd.doctor.bean.SettleinBean;

/**
 * @ProjectName: Health_Doctor
 * @Package: com.wd.doctor.contract
 * @ClassName: IContract
 * @Author: YuYanHe
 * @CreateDate: 2020/1/8 18:48
 */
public interface IContract {
    //查询系统形象照
    interface IViewAvatar {
        void avatarSuccess(AvatarBean avatarBean);
    }

    //查询系统形象照
    interface IModelAvatar {
        void avatarsSuccess(AvatarBean avatarBean);
    }

    //申请入驻
    interface IViewSettlein {
        void settleinSuccess(SettleinBean settleinBean);
    }

    //申请入驻
    interface IModelSettlein {
        void settleinsSuccess(SettleinBean settleinBean);
    }
}
