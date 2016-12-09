package com.example.a5androidintern1.p00421simplelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] names = {"Иван","Марья", "Пётр", "Антон", "Даша", "Борис", "Костя", "Игорь", "Жора", "Света", "Дима"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lvMain = (ListView) findViewById(R.id.lvMain);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.my_list_item,names);

        lvMain.setAdapter(adapter);
    }
}
