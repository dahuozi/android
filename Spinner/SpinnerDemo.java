//MainActivity.java
package com.dahuozi.spinnerdemo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private String[] plantes;
    private ArrayAdapter<String > adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner)findViewById(R.id.sp);
        /**
         * 准备需要加载的数据源
         * 将数据源加载到适配器中
         * context :上下文对象；
         * resource：表示的是列表item的布局资源ID
         * object: 表示加载的数据源
         * 将适配器中的数据加载到控件中
         */
        plantes = getResources().getStringArray(R.array.plantes_array);

        adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,plantes);

        spinner.setAdapter(adapter);
        //表示当spinner控件中item被选中时回掉的方法
        /***
         * AdapterView<?> parent 表示当前触发事件 适配器控件对象 Spinner
         * View view 表示当前被选中item的对象
         * int  position 表示当前被选中的item 的下标
         * long id 表示当前被选中的item的id
         *
         */
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent,View view,int position,long id)
            {
                String s1 = plantes[position];//在数据源中获取
                String s2 = adapter.getItem(position);//根据下标在适配器中获取
                String s3 = spinner.getItemAtPosition(position).toString();//根据下标在spinner控件中获取
                Toast.makeText(MainActivity.this,"传入s1="+s1+",s2="+s2+"s3="+s3,Toast.LENGTH_SHORT).show();

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });
    }
}
//strings.xml
<resources>
    <string name="app_name">SpinnerDemo</string>
    <!--定义字符串数组-->
    <string-array name="plantes_array">
        <item>Mercury</item>
        <item>Venus</item>
        <item>Earth</item>
        <item>Mars</item>
        <item>JuPiter</item>
        <item>Saturn</item>
        <item>Uranus</item>
        <item>Nepture</item>
    </string-array>
</resources>
//activity_main.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">
<Spinner
    android:id="@+id/sp"
    android:layout_width="match_parent"
    android:layout_height="wrap_content">

</Spinner>

</LinearLayout>
