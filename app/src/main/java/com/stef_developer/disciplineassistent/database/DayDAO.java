package com.stef_developer.disciplineassistent.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;

import com.stef_developer.disciplineassistent.table_objects.Day;

import java.util.ArrayList;

import javax.sql.DataSource;

/**
 * Created by Administrator on 6/7/2015.
 */
public class DayDAO extends DiscAssistDBDAO {

    private static final String WHERE_ID_EQUALS = DataBaseHelper.DAY_ID + " = ?";

    public DayDAO(Context context) {
        super(context);
    }

    private long insert (Day day) {
        ContentValues values = new ContentValues();

        values.put(DataBaseHelper.DAY_ID, day.getId_day());
        values.put(DataBaseHelper.DAY_NAME_IND, day.getName_ind());
        values.put(DataBaseHelper.DAY_NAME_ENG, day.getName_eng());

        return sqLiteDatabase.insert(DataBaseHelper.TABLE_DAY, null, values);
    }

    public ArrayList<Day> getAllDays() {
        ArrayList<Day> days = new ArrayList<Day>();

        Cursor cursor = sqLiteDatabase.query(DataBaseHelper.TABLE_DAY,
                new String[] {DataBaseHelper.DAY_ID,
                            DataBaseHelper.DAY_NAME_IND,
                            DataBaseHelper.DAY_NAME_ENG},
                null,
                null,
                null,
                null,
                null);

        while (cursor.moveToNext()) {
            Day day = new Day(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
            days.add(day);
        }
        return days;
    }

    public void loadDays() {
        Day day0 = new Day(0, "Minggu", "Sunday");
        Day day1 = new Day(1, "Senin", "Monday");
        Day day2 = new Day(2, "Selasa", "Tuesday");
        Day day3 = new Day(3, "Rabu", "Wednesday");
        Day day4 = new Day(4, "Kamis", "Thursday");
        Day day5 = new Day(5, "Jumat", "Friday");
        Day day6 = new Day(6, "Sabtu", "Saturday");

        insert(day0);
        insert(day1);
        insert(day2);
        insert(day3);
        insert(day4);
        insert(day5);
        insert(day6);
    }
}
