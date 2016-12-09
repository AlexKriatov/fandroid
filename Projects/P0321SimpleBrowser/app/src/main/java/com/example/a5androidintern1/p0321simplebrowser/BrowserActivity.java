package com.example.a5androidintern1.p0321simplebrowser;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

public class BrowserActivity extends AppCompatActivity {
    final String TAG = "actLog";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"activity created");
        setContentView(R.layout.activity_browser);
        WebView webView = (WebView)findViewById(R.id.webView);
        Uri data = getIntent().getData();
        webView.loadUrl(data.toString());
    }
    @Override
    protected void onResume() {
        super.onResume();
        finish();
        Log.d(TAG,"activity resumed");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"activity started");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"activity stopped");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"activity paused");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"activity destroyed");
    }
}
