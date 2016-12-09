package com.example.a5androidintern1.p0231_activitylificycle;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends Activity {
    final String TAG = "lifecycle";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(TAG, "Second activity was created");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"Second Activity OnRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "Second  was started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Second  was resumed");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Second  was stopped");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Second  was paused");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Second  was destroyed");
    }
}
