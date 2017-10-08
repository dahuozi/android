//activity_switch.xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent">
    <ImageView
        android:id="@+id/iv"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerInParent="true"
        android:src="@drawable/x1"/>
    <Button
        android:id="@+id/btn_last"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/last_name"
        android:layout_alignParentLeft="true"
        android:layout_alignParentBottom="true"
        android:layout_marginLeft="15dp"
        android:onClick="click"/>
    <Button
        android:id="@+id/next_last"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/next_name"
        android:layout_alignParentRight="true"
        android:layout_alignParentBottom="true"
        android:layout_marginRight="15dp"
        android:onClick="click"/>

</RelativeLayout>
//MainActivity.java
package com.dahuozi.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private int[] images = {R.drawable.x1,R.drawable.x2,R.drawable.x3,R.drawable.x4};
    private ImageView iv;
    private int index;//数组下标
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);
        iv = (ImageView) findViewById(R.id.iv);
    }
    public  void click(View view){
        switch (view.getId()){
            case R.id.btn_last:
                index--;
                break;
            case R.id.next_last:
                index++;
                break;
        }
        if(index<0)
        {
            index = 0;
        }
        if(index>images.length-1)
        {
            index=images.length-1;
        }
        //确定档期那展示的图片的资源id setImageResource(int imageId)
        iv.setImageResource(images[index]);
    }
}
