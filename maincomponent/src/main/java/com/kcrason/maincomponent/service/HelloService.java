package com.kcrason.maincomponent.service;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * @author KCrason
 * @date 2018/5/25
 */
public interface HelloService extends IProvider {
    void sayHello(String content);
}
