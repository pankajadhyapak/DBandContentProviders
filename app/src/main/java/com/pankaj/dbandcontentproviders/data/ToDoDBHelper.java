package com.pankaj.dbandcontentproviders.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.pankaj.dbandcontentproviders.data.ToDoContract.ToDoEntry;

public class ToDoDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Todo.db";
    private static final int DATABASE_VERSION = 1;

    private static final String SQL_CREATE_TABLE =
            "CREATE TABLE " + ToDoEntry.TABLE_NAME + " (" +
                    ToDoEntry._ID + " INTEGER PRIMARY KEY," +
                    ToDoEntry.COLUMN_NAME + " TEXT," +
                    ToDoEntry.COLUMN_STATUS + " TEXT)";

    private static final String SQL_DELETE_TABLE =
            "DROP TABLE IF EXISTS " + ToDoEntry.TABLE_NAME;

    public ToDoDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(SQL_DELETE_TABLE);
        onCreate(db);
    }
}
