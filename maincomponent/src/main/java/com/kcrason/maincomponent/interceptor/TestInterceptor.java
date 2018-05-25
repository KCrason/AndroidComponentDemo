package com.kcrason.maincomponent.interceptor;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.kcrason.maincomponent.MainActivity;

/**
 * @author KCrason
 * @date 2018/5/25
 */
@Interceptor(priority = 7)
public class TestInterceptor implements IInterceptor {
    private Context mContext;

    @Override
    public void process(final Postcard postcard, final InterceptorCallback callback) {
        if ("/OneActivity/test".equals(postcard.getPath())) {
            //拦截跳转到OneActivity的页面
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    new AlertDialog.Builder(MainActivity.getActivity())
                            .setTitle("提醒")
                            .setNegativeButton("添加参数", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    postcard.withString("extra", "拦截器添加的内容");
                                    callback.onContinue(postcard);
                                }
                            }).setPositiveButton("继续", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            callback.onContinue(postcard);
                        }
                    }).setNeutralButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            callback.onInterrupt(null);
                        }
                    }).setMessage("跳转到" + postcard.getGroup() + "的请求被拦截了,选择操作。").create().show();
                }
            });
        } else {
            callback.onContinue(postcard);
        }
    }

    @Override
    public void init(Context context) {
        Log.i("KCrason", "init: " + context.getPackageName());
        this.mContext = context;
    }
}
