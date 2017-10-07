//利用绑定监听器的方式去实现button响应
//Activity_main.xml
<Button
    android:id="@+id/btn"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="@string/button_name"
    android:onClick="onClick"/>
<Button
        android:id="@+id/btn1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@id/btn"
        android:text="@string/button1_name"
        android:onClick="onClick"/>
//MainActivity.java
//方式一：匿名内部类
public class MainActivity extends AppCompatActivity {
    private Button btn,btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.btn);
        btn1 = (Button)findViewById(R.id.btn1);
        //给Button按钮这是单击事件监听
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"第一个按钮被点击了！",Toast.LENGTH_SHORT).show();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"第二个按钮被点击了！",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
//第二种方式：以内部类的形式
public class MainActivity extends AppCompatActivity {
    private Button btn,btn1;
    private MyOnClickListener listener = new MyOnClickListener();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.btn);
        btn1 = (Button)findViewById(R.id.btn1);

        btn.setOnClickListener(listener);
        btn1.setOnClickListener(listener);

    }
    //以内部类的形式去实现单击监听
    class MyOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v){
            switch (v.getId()){
                case R.id.btn:
                    Toast.makeText(MainActivity.this,"第一个按钮被点击了！",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn1:
                    Toast.makeText(MainActivity.this,"第二个按钮被点击了！",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
//-------------------------------
