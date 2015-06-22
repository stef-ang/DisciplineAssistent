package com.stef_developer.disciplineassistent.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.stef_developer.disciplineassistent.table_objects.Plan_Day;

import java.util.ArrayList;

/**
 * Created by Administrator on 6/7/2015.
 */
public class Plan_DayDAO extends DiscAssistDBDAO {

    private static final String WHERE_ID_EQUALS = DataBaseHelper.PLAN_DAY_ID + " = ?";
    private static final String WHERE_ID_PLAN_EQUALS = DataBaseHelper.PLAN_ID + " = ?";

    public Plan_DayDAO(Context context) {
        super(context);
    }

    public long insert (Plan_Day plan_day) {
        ContentValues values = new ContentValues();

        values.put(DataBaseHelper.PLAN_ID, plan_day.getId_plan());
        values.put(DataBaseHelper.DAY_ID, plan_day.getId_day());

        return sqLiteDatabase.insert(DataBaseHelper.TABLE_PLAN_DAY, null, values);
    }

    // kyknya ini ntar direvisi deh, parameternya id_plan harusnya..
    public long update (Plan_Day plan_day) {
        ContentValues values = new ContentValues();

        values.put(DataBaseHelper.PLAN_ID, plan_day.getId_plan());
        values.put(DataBaseHelper.DAY_ID, plan_day.getId_day());

        long result = sqLiteDatabase.update(DataBaseHelper.TABLE_PLAN_DAY,
                values,
                WHERE_ID_EQUALS,
                new String[] {String.valueOf(plan_day.getId_p_d())});
        Log.d("Update result:", " = " + result);
        return result;
    }

    public int detele (int plan_id) {
        return sqLiteDatabase.delete(DataBaseHelper.TABLE_PLAN_DAY,
                WHERE_ID_PLAN_EQUALS,
                new String[] { String.valueOf(plan_id)});
    }

//    public ArrayList<Integer> getDaysById(int plan_id) {
//        ArrayList<Integer> days = new ArrayList<>();
//
//        Cursor cursor = sqLiteDatabase.query(DataBaseHelper.TABLE_PLAN_DAY,
//                new String[] {DataBaseHelper.DAY_ID},
//                WHERE_ID_PLAN_EQUALS,
//                new String[] {String.valueOf(plan_id)},
//                null,
//                null,
//                null);
//    }
}
