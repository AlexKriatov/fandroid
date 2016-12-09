package com.example.a5androidintern1.p0081_viewbyid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView)findViewById(R.id.myText);
        textView.setText("Android it's easy!");
        Button button = (Button)findViewById(R.id.button_1);
        button.setText("My First Button");
        button.setEnabled(false);
        CheckBox checkBox = (CheckBox)findViewById(R.id.checkBox);
        checkBox.setChecked(true);
    }
}
