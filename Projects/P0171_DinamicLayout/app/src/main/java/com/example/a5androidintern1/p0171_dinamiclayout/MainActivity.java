package com.example.a5androidintern1.p0171_dinamiclayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    RadioGroup rgGravity;
    LinearLayout llMain;
    EditText eText;
    Button btnClear;
    Button btnCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rgGravity = (RadioGroup)findViewById(R.id.rgGravity);
        llMain = (LinearLayout)findViewById(R.id.llMain);
        eText = (EditText)findViewById(R.id.eText);

        btnClear = (Button)findViewById(R.id.btnClear);
        btnCreate = (Button) findViewById(R.id.btnCreate);

        btnCreate.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnCreate:
                LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                int btnGraviry = Gravity.LEFT;

                switch (rgGravity.getCheckedRadioButtonId()){
                    case R.id.rbLeft:
                        btnGraviry = Gravity.LEFT;
                        break;
                    case R.id.rbCenter:
                        btnGraviry = Gravity.CENTER;
                        break;
                    case R.id.rbRight:
                        btnGraviry = Gravity.RIGHT;
                        break;
                }

                lParams.gravity = btnGraviry;

                Button btnNew = new Button(this);
                btnNew.setText(eText.getText().toString());
                llMain.addView(btnNew,lParams);
                break;
            case R.id.btnClear:
                llMain.removeAllViews();
                Toast.makeText(MainActivity.this,"DELETED",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
