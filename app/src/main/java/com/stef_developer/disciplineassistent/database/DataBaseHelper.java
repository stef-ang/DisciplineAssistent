package com.stef_developer.disciplineassistent.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Stefanus Anggara on 07/06/2015.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "discipline_assist";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_PLAN = "plan";
    public static final String TABLE_DAY = "day";
    public static final String TABLE_PLAN_DAY = "plan_day";

    // plan attributes
    public static final String PLAN_ID = "id_plan";
    public static final String PLAN_TITLE = "title";
    public static final String PLAN_DETAIL = "detail";
    public static final String PLAN_PRIORITY = "priority";
    public static final String PLAN_FOR = "for_periode";
    public static final String PLAN_START = "start";
    public static final String PLAN_FINISH = "finish";
    public static final String PLAN_MOTIVATION = "motivation";
    public static final String PLAN_ICON = "icon";
    public static final String PLAN_REWARD = "reward";
    public static final String PLAN_DATE_CREATE = "date_create";
    public static final String PLAN_ACT_LEFT = "act_left";
    public static final String PLAN_SUCCESS = "success";
    public static final String PLAN_FAIL = "fail";

    // day attributes
    public static final String DAY_NAME = "name";   // ini PKnya
    public static final String DAY_FULLNAME = "fullname";

    // plan_day attribute
    public static final String PLAN_DAY_ID = "id_p_d";

    // create table plan
    public static final String CREATE_TABLE_PLAN = "CREATE TABLE "
            + TABLE_PLAN + " ( " + PLAN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + PLAN_TITLE + " VARCHAR (255), "
            + PLAN_DETAIL + " VARCHAR (1023), "
            + PLAN_PRIORITY + " VARCHAR (1), "
            + PLAN_FOR + " INTEGER, "
            + PLAN_START + " TIME, "
            + PLAN_FINISH + " TIME, "
            + PLAN_MOTIVATION + " VARCHAR (1023), "
            + PLAN_ICON + " VARCHAR(255), "
            + PLAN_REWARD + " VARCHAR(1023), "
            + PLAN_DATE_CREATE + " DATETIME, "
            + PLAN_ACT_LEFT + " INTEGER, "
            + PLAN_SUCCESS + " INTEGER, "
            + PLAN_FAIL + " INTEGER " + ")";

    // create table day
    public static final String CREATE_TABLE_DAY = "CREATE TABLE "
            + TABLE_DAY + " ( " + DAY_NAME + " VARCHAR(10) PRIMARY KEY, "
            + DAY_FULLNAME + " VARCHAR(255) " + ")";

    // create table plan_day
    public static final String CREATE_TABLE_PLAN_DAY = "CREATE TABLE "
            + TABLE_PLAN_DAY + " ( " + PLAN_DAY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + PLAN_ID + " INTEGER, "
            + DAY_NAME + " VARCHAR(10), "
            + "FOREIGN KEY ( " + PLAN_ID + " ) REFERENCES " + TABLE_PLAN + " ( " + PLAN_ID + " ), "
            + "FOREIGN KEY ( " + DAY_NAME + " ) REFERENCES " + TABLE_DAY + " ( " + DAY_NAME + " ))";

    private static DataBaseHelper instance;

    public static final synchronized DataBaseHelper getHelper(Context context) {
        if(instance == null)
            instance = new DataBaseHelper(context);
        return instance;
    }

    private DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if(!db.isReadOnly()){
            // enable foreign key constraints
            db.execSQL("PRAGMA foreign_keys=ON;");
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_PLAN);
        db.execSQL(CREATE_TABLE_DAY);
        db.execSQL(CREATE_TABLE_PLAN_DAY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
