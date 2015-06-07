package com.stef_developer.disciplineassistent.database;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.stef_developer.disciplineassistent.table_objects.Plan_Day;

/**
 * Created by Administrator on 6/7/2015.
 */
public class Plan_DayDAO extends DiscAssistDBDAO {

    private static final String WHERE_ID_EQUALS = DataBaseHelper.PLAN_DAY_ID + " = ?";

    public Plan_DayDAO(Context context) {
        super(context);
    }

    public long insert (Plan_Day plan_day) {
        ContentValues values = new ContentValues();

        values.put(DataBaseHelper.PLAN_ID, plan_day.getId_plan());
        values.put(DataBaseHelper.DAY_ID, plan_day.getId_day());

        return sqLiteDatabase.insert(DataBaseHelper.TABLE_PLAN_DAY, null, values);
    }

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

    public int detele (Plan_Day plan_day) {
        return sqLiteDatabase.delete(DataBaseHelper.TABLE_PLAN_DAY,
                WHERE_ID_EQUALS,
                new String[] { String.valueOf(plan_day.getId_p_d())});
    }
}
