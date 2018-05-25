package com.kcrason.onecomponent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.kcrason.common.AppRouterPath;


@Route(path = AppRouterPath.OneComponent.OneActivity)
public class OneActivity extends AppCompatActivity {

    @Autowired
    String extra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_module_activity_main);
        ARouter.getInstance().inject(this);

        Toast.makeText(this, extra, Toast.LENGTH_SHORT).show();

        findViewById(R.id.txt_click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/TwoActivity/test")
                        .withString("Name", "I am kcrason !")
                        .navigation();
            }
        });
    }
}
