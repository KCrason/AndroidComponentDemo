package com.kcrason.common;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @author KCrason
 * @date 2018/5/25
 */
public class BaseApplication extends Application {
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
