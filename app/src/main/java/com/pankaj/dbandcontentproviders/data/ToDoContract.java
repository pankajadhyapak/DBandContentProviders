package com.pankaj.dbandcontentproviders.data;

import android.provider.BaseColumns;

public final class ToDoContract {
    private ToDoContract() {}

    public static class ToDoEntry implements BaseColumns{
        public static final String TABLE_NAME = "todos";

        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_STATUS = "status";
    }
}
