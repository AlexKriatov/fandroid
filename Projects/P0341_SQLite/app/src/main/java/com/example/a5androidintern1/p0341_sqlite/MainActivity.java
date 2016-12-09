package com.example.a5androidintern1.p0341_sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnAdd, btnClear, btnRead, btnUpdate, btnDelete;
    EditText edName, edMail, etId;
    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnRead = (Button) findViewById(R.id.btnRead);
        btnAdd.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnRead.setOnClickListener(this);
        edName = (EditText) findViewById(R.id.editName);
        edMail = (EditText) findViewById(R.id.editMail);
        etId = (EditText) findViewById(R.id.id);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(this);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        dbHelper = new DbHelper(this);
    }

    @Override
    public void onClick(View view) {
        String name = edName.getText().toString();
        String eMail = edMail.getText().toString();
        String id = etId.getText().toString();

        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        switch (view.getId()) {
            case R.id.btnAdd:
                contentValues.put(DbHelper.KEY_NAME, name);
                contentValues.put(DbHelper.KEY_MAIL, eMail);

                database.insert(DbHelper.TABLE_CONTACTS, null, contentValues);
                break;
            case R.id.btnRead:
                Cursor cursor = database.query(DbHelper.TABLE_CONTACTS, null, null, null, null, null, null);

                if (cursor.moveToFirst()) {
                    int idIndex = cursor.getColumnIndex(DbHelper.KEY_ID);
                    int nameIndex = cursor.getColumnIndex(DbHelper.KEY_NAME);
                    int emailIndex = cursor.getColumnIndex(DbHelper.KEY_MAIL);

                    do {
                        Log.d("mLog", "ID = " + cursor.getInt(idIndex) +
                                ", name = " + cursor.getString(nameIndex) +
                                ", email = " + cursor.getString(emailIndex));
                    } while (cursor.moveToNext());
                } else Log.d("mLog", "0 rows");

                cursor.close();
                break;
            case R.id.btnClear:

                database.delete(DbHelper.TABLE_CONTACTS, null, null);
                break;
            case R.id.btnDelete:
                if (name.equalsIgnoreCase("")) {
                    break;
                }
                int delCount = database.delete(DbHelper.TABLE_CONTACTS, DbHelper.KEY_NAME + "= ?",new String[]{name});
                Log.d("mLog", "Deletes rows count = " + delCount);

                break;
            case R.id.btnUpdate:
                if (name.equalsIgnoreCase("")) {
                    break;
                }
                contentValues.put(DbHelper.KEY_MAIL, eMail);
                contentValues.put(DbHelper.KEY_NAME, name);
                int updContacts = database.update(DbHelper.TABLE_CONTACTS, contentValues, DbHelper.KEY_NAME + "= ?",
                        new String[]{name});
                Log.d("mLog", "Updates rows count = " + updContacts);


                break;
        }
        dbHelper.close();
    }

}
