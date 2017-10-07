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
    public  void onClick(View view){
        //Toast.makeText(MainActivity.this,"我被点击了！",Toast.LENGTH_SHORT).show();
        int id = view.getId();//获取点击控件的id
        switch (id){
            case R.id.btn:
                Toast.makeText(MainActivity.this,"第一个按钮被点击了！",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn1:
                Toast.makeText(MainActivity.this,"第二个按钮被点击了！",Toast.LENGTH_SHORT).show();
                break;
        }
    }