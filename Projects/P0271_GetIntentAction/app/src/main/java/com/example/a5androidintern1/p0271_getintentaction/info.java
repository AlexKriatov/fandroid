package com.example.a5androidintern1.p0271_getintentaction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TextView;

import java.util.Date;

public class info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Intent intent = getIntent();
        String action = intent.getAction();
        String fotmat="", textInfo = "";

        if(action.equals("info.funAndroid.intent.action.time")){
            fotmat = "hh:mm:ss";
            textInfo = "Time: ";
        }else  if(action.equals("info.funAndroid.intent.action.date")){
            fotmat = "dd:MM:yyyy";
            textInfo = "Date: ";
        }

        DateFormat dateFormat = new DateFormat();

        String dateTime = dateFormat.format(fotmat, new Date(System.currentTimeMillis())).toString();
        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(textInfo+dateTime);


    }
}
