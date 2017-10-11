//MainACtivity.java
package com.dahuozi.checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

/*
*需求：选中CheckBox提示选中的文本信息
* 实现全选
* 点击确定按钮时打印全部选择
* 1.绑定CheckBox的状态监听状态， 选中某项时给出提示信息
* 2.当结束之后获取最终选择的信息，绑定按钮的单击事件，判断最终选择的CheckBox
*3.实现全选功能（两方面）
*   如果所有的CheckBox全部被选中，则全选选中
*   如果全选选取，则上面全选
 */
public class MainActivity extends AppCompatActivity {
    private CheckBox cb1,cb2,cb3,cb_all;
    private MyOncheckdeChangedLister lister = new MyOncheckdeChangedLister();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cb1 = (CheckBox)findViewById(R.id.cb1);
        cb2 = (CheckBox)findViewById(R.id.cb2);
        cb3 = (CheckBox)findViewById(R.id.cb3);
        cb_all =(CheckBox)findViewById(R.id.cb_all);

        cb1.setOnCheckedChangeListener(lister);
        cb2.setOnCheckedChangeListener(lister);
        cb3.setOnCheckedChangeListener(lister);
    }
    //点击事件调用的函数
    public void click(View view){
        switch (view.getId()){
            case R.id.btn_ok:
                String str = checkedString();
                Toast.makeText(MainActivity.this,"您的爱好是："+str,Toast.LENGTH_SHORT).show();
                break;
            case R.id.cb_all:
                boolean bl =cb_all.isChecked();
                cb1.setChecked(bl);
                cb2.setChecked(bl);
                cb3.setChecked(bl);
                break;

        }
    }
    //获取最终选择的结果
    public String checkedString(){
        StringBuilder sb = new StringBuilder();
        if(cb1.isChecked()){
            sb.append(cb1.getText().toString());
        }
        if(cb2.isChecked()){
            sb.append(cb2.getText().toString());
        }
        if(cb3.isChecked()){
            sb.append(cb3.getText().toString());
        }
        return sb.toString();
    }
    class MyOncheckdeChangedLister implements CompoundButton.OnCheckedChangeListener {

        public void onCheckedChanged(CompoundButton buttonView,boolean isChecked){
            /*CheckBox cb = (CheckBox)buttonView;
            String str = cb.getText().toString();
            if(isChecked)
            {
                Toast.makeText(MainActivity.this,"当前选中的爱好是"+str,Toast.LENGTH_SHORT).show();
            }
            */
            //判断是否全部被选中
            if(cb1.isChecked()&&cb2.isChecked()&&cb3.isChecked())
            {
                cb_all.setChecked(true);
            }
            else {
                cb_all.setChecked(false);
            }


        }
    }


}
//activity_main.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical" android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TextView
        android:id="@+id/tv_hobby"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="请选择你的爱好:" />
    <CheckBox
        android:id="@+id/cb1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/hobby1"/>
    <CheckBox
        android:id="@+id/cb2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/hobby2"/>
    <CheckBox
        android:id="@+id/cb3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/hobby3"/>

    <CheckBox
        android:id="@+id/cb_all"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="全选"
        android:onClick="click"/>
    <Button
        android:id="@+id/btn_ok"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="确定"
        android:onClick="click"/>

</LinearLayout>
