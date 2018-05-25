package com.kcrason.twocomponent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;


@Route(path = "/TwoComponent/TwoActivity")
public class TwoActivity extends AppCompatActivity {

    @Autowired
    public String Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two_module_activity_main);
        ARouter.getInstance().inject(this);
        Toast.makeText(this, Name, Toast.LENGTH_SHORT).show();
    }
}
