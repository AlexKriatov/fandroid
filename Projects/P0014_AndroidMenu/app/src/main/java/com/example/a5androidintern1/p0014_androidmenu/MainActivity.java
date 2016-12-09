package com.example.a5androidintern1.p0014_androidmenu;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import static com.example.a5androidintern1.p0014_androidmenu.R.id.group1;

public class MainActivity extends ActionBarActivity implements CompoundButton.OnCheckedChangeListener{
    CheckBox checkBox_1;
    CheckBox checkBox_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        checkBox_1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox_2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox_1.setOnCheckedChangeListener(this);
        checkBox_2.setOnCheckedChangeListener(this);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);




        return true;
    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu){

        MenuItem item_1 = menu.findItem(R.id.action_item1);
                if(checkBox_1.isChecked()){

                    menu.setGroupVisible(group1,true);
                }
                else {
                    menu.setGroupVisible(group1,false);

                }



                if(checkBox_2.isChecked()){
                    item_1.setVisible(true);

                }
                else {item_1.setVisible(false);
                }


        invalidateOptionsMenu();
        return super.onPrepareOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        switch (id){
            case R.id.action_item1:
                Toast.makeText(MainActivity.this, R.string.action_item1, Toast.LENGTH_LONG).show();
                break;
            case R.id.action_item2:
                Toast.makeText(MainActivity.this, R.string.action_item2, Toast.LENGTH_LONG).show();
                break;
            case R.id.action_item3:
                Toast.makeText(MainActivity.this, R.string.action_item3, Toast.LENGTH_LONG).show();
                break;
            case R.id.action_settings:
                Toast.makeText(MainActivity.this, R.string.action_settings, Toast.LENGTH_LONG).show();
                break;
            case 5: if(item.isChecked()){
                item.setChecked(false);
            }
                else item.setChecked(true);
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(checkBox_1.isChecked()||checkBox_2.isChecked()){
            invalidateOptionsMenu();
        }
    }
}
