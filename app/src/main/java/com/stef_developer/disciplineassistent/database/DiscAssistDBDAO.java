package com.stef_developer.disciplineassistent.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Stefanus Anggara on 07/06/2015.
 */
public class DiscAssistDBDAO {

    protected SQLiteDatabase sqLiteDatabase;
    protected DataBaseHelper dataBaseHelper;
    private Context mContext;

    public DiscAssistDBDAO(Context context) {
        this.mContext = context;
        dataBaseHelper = DataBaseHelper.getHelper(mContext);
        open();
    }

    public void open() {
        if (dataBaseHelper == null)
            dataBaseHelper = DataBaseHelper.getHelper(mContext);
        sqLiteDatabase = dataBaseHelper.getWritableDatabase();
    }
}
