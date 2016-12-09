package com.example.a5androidintern1.p0481simpleadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    final String ATTRIBUTE_NAME_TEXT = "text";
    final String ATTRIBUTE_NAME_CHECKED = "checked";
    final String ATTRIBUTE_NAME_IMAGE = "image";

    ListView lvSimple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //массивы данных
        String[] texts = {"sometext 1","sometext 2","sometext 3","sometext 4","sometext 5",};
        boolean[] checked = {true, false, false, true,false};
        int img = R.mipmap.ic_launcher;

        //упаковка данных для адаптера
        ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>(texts.length);
        Map<String,Object> m;
        for (int i = 0; i<texts.length; i++){
            m = new HashMap<String,Object>();
            m.put(ATTRIBUTE_NAME_TEXT,texts[i]);
            m.put(ATTRIBUTE_NAME_CHECKED,checked[i]);
            m.put(ATTRIBUTE_NAME_IMAGE,img);
            data.add(m);
        }

        //массив имен аттрибутов, из которых будут читатся данные
        String[] from = {ATTRIBUTE_NAME_TEXT,ATTRIBUTE_NAME_CHECKED,ATTRIBUTE_NAME_IMAGE};
        //Массив id элементов
        int[] to = {R.id.tvText,R.id.cbChecked,R.id.lvImg};

        //создаём адаптер
        SimpleAdapter sAdapter = new SimpleAdapter(this, data,R.layout.item, from, to);

        //определаем список и присваиваем ему адаптер

        lvSimple = (ListView)findViewById(R.id.lvSimple);
        lvSimple.setAdapter(sAdapter);






    }
}
