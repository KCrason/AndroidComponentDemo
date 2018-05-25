package com.kcrason.maincomponent;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.kcrason.maincomponent.service.HelloServiceImpl;
import com.kcrason.maincomponent.service.SingleHelloService;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static Activity sActivity;

    public static Activity getActivity() {
        return sActivity;
    }

    private void testNavigation() {
        final ArrayList<String> strings = new ArrayList<>();
        strings.add("哈哈哈");
        strings.add("呵呵呵");
        strings.add("滴滴滴");
        ARouter.getInstance()
                .build("/TestActivity/test")
                .withObject("stringArray", strings)
                .withObject("obj", new TestObject(25, "KCrason"))
                .navigation(MainActivity.this, new NavCallback() {
                    @Override
                    public void onArrival(Postcard postcard) {
                        Log.d("ARouter", "跳转完了");
                    }

                    @Override
                    public void onFound(Postcard postcard) {
                        super.onFound(postcard);
                        Log.d("ARouter", "找到了");
                    }

                    @Override
                    public void onInterrupt(Postcard postcard) {
                        super.onInterrupt(postcard);
                        Log.d("ARouter", "被拦截了");
                    }

                    @Override
                    public void onLost(Postcard postcard) {
                        super.onLost(postcard);
                        Log.d("ARouter", "丢失了");
                    }
                });
    }

    private void testServiceSingle() {
        ARouter.getInstance().navigation(SingleHelloService.class)
                .sayHello("Hello , Service Single !");
    }

    private void testService() {
        ((HelloServiceImpl) ARouter.getInstance().build("/service/sayHello").
                navigation()).sayHello("Hello , Service !");
    }


    private void testInterceptor() {
        ARouter.getInstance().build("/OneActivity/test").navigation();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_main);
        sActivity =this;
        findViewById(R.id.txt_navigation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testNavigation();
            }
        });

        findViewById(R.id.txt_service_single).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testServiceSingle();
            }
        });

        findViewById(R.id.txt_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testService();
            }
        });

        findViewById(R.id.txt_interceptor).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testInterceptor();
            }
        });

    }
}
