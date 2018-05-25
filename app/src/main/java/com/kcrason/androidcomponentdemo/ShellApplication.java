package com.kcrason.androidcomponentdemo;

import com.alibaba.android.arouter.launcher.ARouter;
import com.kcrason.common.BaseApplication;
import com.kcrason.common.BuildConfig;

/**
 * @author KCrason
 * @date 2018/5/25
 */
public class ShellApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            //一定要在ARouter.init之前调用openDebug
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(this);
    }
}
