package com.kcrason.maincomponent.service;

import android.content.Context;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.template.IProvider;
import com.kcrason.common.AppRouterPath;

/**
 * @author KCrason
 * @date 2018/5/25
 */
@Route(path = AppRouterPath.RouterService.SingleHelloService)
public class SingleHelloService implements IProvider {

    private Context mContext;

    public void sayHello(String content) {
        Toast.makeText(mContext, content, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void init(Context context) {
        this.mContext = context;
    }
}
