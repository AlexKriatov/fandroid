package com.example.a5androidintern1.p0301activityresult;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ColorActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        Button btnRed = (Button)findViewById(R.id.buttonRed);
        Button btnBlue = (Button)findViewById(R.id.buttonBlue);
        Button btnGreen = (Button)findViewById(R.id.buttonGreen);
        btnRed.setOnClickListener(this);
        btnBlue.setOnClickListener(this);
        btnGreen.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.buttonRed:
                intent.putExtra("color", Color.RED);

                break;
            case R.id.buttonBlue:
                intent.putExtra("color", Color.BLUE);

                break;
            case R.id.buttonGreen:
                intent.putExtra("color", Color.GREEN);

                break;
        }
        setResult(RESULT_OK, intent);
        finish();

    }
}
