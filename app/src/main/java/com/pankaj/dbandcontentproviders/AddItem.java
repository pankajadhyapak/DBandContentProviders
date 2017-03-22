package com.pankaj.dbandcontentproviders;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pankaj.dbandcontentproviders.data.ToDoContract.ToDoEntry;
import com.pankaj.dbandcontentproviders.data.ToDoDBHelper;

public class AddItem extends AppCompatActivity {

    EditText mName;
    Button mAddBtn;
    ToDoDBHelper mDbHelper ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additem);
        mDbHelper = new ToDoDBHelper(this);

        mName = (EditText)findViewById(R.id.newTodo);
        mAddBtn = (Button) findViewById(R.id.addTodo);

        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String todoname = mName.getText().toString().trim();
                if(todoname.isEmpty()){
                    Toast.makeText(AddItem.this, "Enter todo name", Toast.LENGTH_SHORT).show();
                }else{
                    SQLiteDatabase db = mDbHelper.getWritableDatabase();
                    ContentValues cv = new ContentValues();
                    cv.put("name", todoname);
                    cv.put("status", "pending");
                    mName.setText("");
                    long newRowId = db.insert(ToDoEntry.TABLE_NAME, null, cv);
                    Toast.makeText(AddItem.this, "Added Todo with id "+ newRowId, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
