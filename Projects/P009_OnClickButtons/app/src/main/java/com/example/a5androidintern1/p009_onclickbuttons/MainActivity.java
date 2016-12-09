package com.example.a5androidintern1.p009_onclickbuttons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView textView;
    Button button_1;
    Button button_2;
    Button button_3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView2);
        button_1 = (Button) findViewById(R.id.button_1);
        button_2 = (Button) findViewById(R.id.button_2);
        button_3 = (Button) findViewById(R.id.button_3);

        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("clicked button 1");
                Toast toast = Toast.makeText(MainActivity.this, "clicked button 1",LENGTH_LONG);
                toast.setGravity(Gravity.CENTER,0,0);
                LinearLayout toastImage = (LinearLayout) toast.getView();
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(R.drawable.ic_report_black_24dp);
                toastImage.addView(imageView,0);
                toast.show();
            }
        });

        button_2.setOnClickListener(this);

    }
        public void clickButton3(View view){
        textView.setText("clicked button 3");
        Toast toast = Toast.makeText(MainActivity.this, "clicked button 3",LENGTH_LONG);
            toast.show();
    }


    @Override
    public void onClick(View view) {
        textView.setText("clicked button 2");
        Toast toast = Toast.makeText(MainActivity.this, "clicked button 2",LENGTH_LONG);
        toast.show();
    }
}
