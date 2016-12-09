package com.example.a5androidintern1.p0451expandablelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    final String ATTR_GROUP_NAME = "groupName";
    final String ATTR_PHONE_NAME = "phoneName";
    //название компаний(групп)
    String[] groups = new String[] {"HTC","Samsung","LG" };

    //название телефонов(эл-тов)
    String[] phonesHTC = new String[] {"Sensation", "Desire", "WildFire", "Hero"};
    String[] phonesSams = new String[] {"Galaxy S II", "Galaxy Nexus", "Wave"};
    String[] phonesLg = new String[] {"Optimus", "Optimus Link", "Optimus Blank", "Optimus One"};

    //Коллекция для групп
    ArrayList<Map<String,String>> groupData;

    //Коллекции для эл-тов одной группы
    ArrayList<Map<String,String>> childDataItem;

    //Общая коллекция для коллекций эл-тов
    ArrayList<ArrayList<Map<String,String>>> childData;

    //Cписок аттрибутов группы или элементов
    Map<String, String> m;

    ExpandableListView elvMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Заполняем коллекцию групп из массива с названиями групп
        groupData = new ArrayList<Map<String, String>>();
        for (String group:groups){
            m=new HashMap<String, String>();
            m.put("groupName", group);
            groupData.add(m);
        }
        //Список аттрибутов групп для чтения
        String groupFrom[] = new String[] {"groupName"};

        //список id view элементов, в которые будут помещены аттрибут групп
        int groupTo[] = new int[] {android.R.id.text1};


        //создаём коллекцию для коллекций эл-тов
        childData = new ArrayList<ArrayList<Map<String,String>>>();

        //Создаём коллекцию эл-тов для первой группы
        childDataItem = new ArrayList<Map<String, String>>();
                //заполнием список аттрибутов для каждого эл-та
        for(String phone: phonesHTC){
            m = new HashMap<String, String>();
            m.put("phoneName",phone);
            childDataItem.add(m);

        }childData.add(childDataItem);

        //Создаём коллекцию эл-тов для второй группы
        childDataItem = new ArrayList<Map<String, String>>();
        //заполнием список аттрибутов для каждого эл-та
        for(String phone: phonesSams){
            m = new HashMap<String, String>();
            m.put("phoneName",phone);
            childDataItem.add(m);

        }childData.add(childDataItem);

        //Создаём коллекцию эл-тов для третьей группы
        childDataItem = new ArrayList<Map<String, String>>();
        //заполнием список аттрибутов для каждого эл-та
        for(String phone: phonesLg){
            m = new HashMap<String, String>();
            m.put("phoneName",phone);
            childDataItem.add(m);

        }childData.add(childDataItem);

//список аттрибутов эл-тов для чтения
        String childForm[] = new String[]{"phoneName"};

        int childTo[] = new int[] {android.R.id.text1};


        SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(this, groupData,
                android.R.layout.simple_expandable_list_item_1, groupFrom, groupTo, childData,android.R.layout.simple_list_item_1, childForm, childTo);
        elvMain = (ExpandableListView)findViewById(R.id.elvMain);
        elvMain.setAdapter(adapter);


    }
}
