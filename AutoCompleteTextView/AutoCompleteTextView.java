//MainACtivity.java
package com.dahuozi.autocompletetextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

/**
 * 演示
 *
 * */
public class MainActivity extends AppCompatActivity {
    private AutoCompleteTextView autoCompleteTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.auto);
        String[] countrys = getResources().getStringArray(R.array.country);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,countrys);
        autoCompleteTextView.setAdapter(adapter);
        //表示当AutoCompleteTextView控件中某一项被点击的监听事件
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = parent.getItemAtPosition(position).toString();//获取根据下标点击的信息
                Toast.makeText(MainActivity.this,"当前选择了"+str,Toast.LENGTH_SHORT).show();

            }
        });
    }
}
//strings.xml
<resources>
    <string name="app_name">AutoCompleteTextView</string>
    <string-array name="country">
        <item>ALChina</item>
        <item>Afgdsigdsg</item>
        <item>Afdsfs</item>
        <item>ALgds</item>
        <item>ALwg</item>
        <item>Amcjoc</item>
        <item>Amxeer</item>

    </string-array>
</resources>
//activity_main.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.dahuozi.autocompletetextview.MainActivity">
<AutoCompleteTextView
    android:id="@+id/auto"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:completionThreshold="1"
    android:completionHint="请选择一个国家："/>
</LinearLayout>
