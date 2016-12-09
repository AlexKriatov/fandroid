package com.example.a5androidintern1.p0972_servicebindserver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Intent intent = new Intent("com.example.a5androidintern1.p0972_servicebindserver.MyService");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startService(intent);
    }
}
