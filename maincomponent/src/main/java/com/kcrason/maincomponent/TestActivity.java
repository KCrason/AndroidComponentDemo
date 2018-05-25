package com.kcrason.maincomponent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import java.util.ArrayList;

/**
 * @author KCrason
 * @date 2018/5/25
 */
@Route(path = "/MainApp/TestActivity")
public class TestActivity extends AppCompatActivity {

    @Autowired
    TestObject obj;

    @Autowired
    ArrayList<String> stringArray;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_test);
        ARouter.getInstance().inject(this);
        TextView textView = findViewById(R.id.txt_content);
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("age:%s\n", String.valueOf(obj.age)));
        builder.append(String.format("name:%s\n", obj.name));
        if (stringArray != null) {
            for (int i = 0; i < stringArray.size(); i++) {
                builder.append(String.format("stringArray:%s\n", stringArray.get(i)));
            }
        }
        textView.setText(builder.toString());
    }
}
