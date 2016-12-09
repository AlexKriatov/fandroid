package com.example.a5androidintern1.p0321simplebrowser;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnGo;
    EditText addAddress;
    String addres;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        btnGo = (Button)findViewById(R.id.btnGo);
        addAddress = (EditText)findViewById(R.id.addAddress);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addres = addAddress.getText().toString();
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+addres)));
            }
        });
    }


}
