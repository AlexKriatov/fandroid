package com.example.a5androidintern1.simpleactivityresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NameActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnOk;
    EditText edName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        btnOk = (Button)findViewById(R.id.button_ok);
        edName = (EditText)findViewById(R.id.edName);
        btnOk.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("name",edName.getText().toString());
        setResult(RESULT_OK,intent);
        finish();
    }
}
