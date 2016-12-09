package com.example.a5androidintern1.p0231_activitylificycle;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    final String TAG = "lifecycle";
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "activity was created");
        button = (Button)findViewById(R.id.btn1);
        button.setOnClickListener(this);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"Main Activity OnRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "Main activity was started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Main activity was resumed");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Main activity was stopped");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Main activity was paused");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Main activity was destroyed");
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
    }
}
