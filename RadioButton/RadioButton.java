//MainActivity.java
package com.dahuozi.radiobutton;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private RadioGroup rg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.btn_ok);
        rg = (RadioGroup) findViewById(R.id.rg);
        //表示RadioGroup中的监听事件,切换的时候触发
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            /*
            当RaidoButton状态切换时，回调的方法
            RadioGroup group属于哪个group
            提示选择的资源ID
             */
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                RadioButton rb = (RadioButton)findViewById(checkedId);
                String str = rb.getText().toString();
                Toast.makeText(MainActivity.this,"你选中的是:"+str,Toast.LENGTH_SHORT).show();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checkedId = rg.getCheckedRadioButtonId();//获取radioGroup中选中的资源ID
                RadioButton rb = (RadioButton) findViewById(checkedId);
                Toast.makeText(MainActivity.this,"你最终选择的是"+rb.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });

    }
}
//activity_main.xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.dahuozi.radiobutton.MainActivity">

    <TextView
        android:id="@+id/tv"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/tv_name"/>
<RadioGroup
    android:id="@+id/rg"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="horizontal"
    android:layout_below="@id/tv">
    <RadioButton
        android:id="@+id/man"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/man"/>
    <RadioButton
        android:id="@+id/woman"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/woman"/>
    <RadioButton
        android:id="@+id/other"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/other"/>
    </RadioGroup>
    <Button
        android:id="@+id/btn_ok"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/rg"
        android:text="提交" />
</RelativeLayout>
