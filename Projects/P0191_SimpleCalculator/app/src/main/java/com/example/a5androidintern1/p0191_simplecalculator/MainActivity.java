package com.example.a5androidintern1.p0191_simplecalculator;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{
    EditText number1;
    EditText number2;
    Button btnPlus;
    Button btnMinus;
    Button btnDivide;
    Button btnComposition;
    TextView tvResult;
    String oper;
    float result;

    final int MENU_RESET = 1;
    final int MENU_EXIT = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number1 = (EditText)findViewById(R.id.number_1);
        number2 = (EditText)findViewById(R.id.number_2);
        btnPlus = (Button)findViewById(R.id.btnPlus);
        btnMinus = (Button)findViewById(R.id.btnMinus);
        btnDivide = (Button)findViewById(R.id.btnDivide);
        btnComposition = (Button)findViewById(R.id.btnComposition);
        tvResult = (TextView)findViewById(R.id.result);
        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btnComposition.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        float number_1;
        float number_2;


        number_1 = Float.parseFloat(number1.getText().toString());
        number_2 = Float.parseFloat(number2.getText().toString());

        if (TextUtils.isEmpty(number1.getText().toString())||TextUtils.isEmpty(number2.getText().toString())){
            return;
        }

        switch(view.getId()){
            case R.id.btnPlus:
                result=number_1+number_2;
                oper = "+";
                break;
            case R.id.btnMinus:
                oper = "-";
                result = number_1-number_2;
                break;

            case R.id.btnDivide:
                oper = "/";
                if(number_2!=0){

                    result = number_1 / number_2;
                    break;
                }else
                Toast.makeText(this,"На ноль делить нельзя",Toast.LENGTH_SHORT).show();


                break;

            case R.id.btnComposition:
                oper = "*";
                result = number_1 * number_2;

                break;
            default:
                break;


        }
        if(number_2==0 && oper.equals("/")){
            tvResult.setText("error");
        }else
        tvResult.setText(number_1+oper+number_2+"="+result+"");

    }



}

