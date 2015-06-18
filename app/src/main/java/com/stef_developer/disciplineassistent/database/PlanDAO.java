package com.stef_developer.disciplineassistent.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.stef_developer.disciplineassistent.table_objects.Plan;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Stefanus Anggara on 07/06/2015.
 */
public class PlanDAO extends DiscAssistDBDAO {

    private static final String WHERE_ID_EQUALS = DataBaseHelper.PLAN_ID + " = ?";
    private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.US);

    public PlanDAO(Context context) {
        super(context);
    }

    public long insert(Plan plan) {
        ContentValues values = new ContentValues();

        values.put(DataBaseHelper.PLAN_TITLE, plan.getTitle());
        values.put(DataBaseHelper.PLAN_DETAIL, plan.getDetail());
        values.put(DataBaseHelper.PLAN_PRIORITY, plan.getPriority());
        values.put(DataBaseHelper.PLAN_FOR, plan.getFor_periode());
        values.put(DataBaseHelper.PLAN_START, plan.getStart());
        values.put(DataBaseHelper.PLAN_FINISH, plan.getFinish());
        values.put(DataBaseHelper.PLAN_MOTIVATION, plan.getMotivation());
        values.put(DataBaseHelper.PLAN_ICON, plan.getIcon());
        values.put(DataBaseHelper.PLAN_REWARD, plan.getReward());
        values.put(DataBaseHelper.PLAN_DATE_CREATE, dateFormatter.format(plan.getDate_create()));
        values.put(DataBaseHelper.PLAN_ACT_LEFT, plan.getAct_left());
        values.put(DataBaseHelper.PLAN_SUCCESS, plan.getSuccess());
        values.put(DataBaseHelper.PLAN_FAIL, plan.getFail());

        return sqLiteDatabase.insert(DataBaseHelper.TABLE_PLAN, null, values);
    }

    public long update(Plan plan) {
        ContentValues values = new ContentValues();

        values.put(DataBaseHelper.PLAN_TITLE, plan.getTitle());
        values.put(DataBaseHelper.PLAN_DETAIL, plan.getDetail());
        values.put(DataBaseHelper.PLAN_PRIORITY, plan.getPriority());
        values.put(DataBaseHelper.PLAN_FOR, plan.getFor_periode());
        values.put(DataBaseHelper.PLAN_START, plan.getStart());
        values.put(DataBaseHelper.PLAN_FINISH, plan.getFinish());
        values.put(DataBaseHelper.PLAN_MOTIVATION, plan.getMotivation());
        values.put(DataBaseHelper.PLAN_ICON, plan.getIcon());
        values.put(DataBaseHelper.PLAN_REWARD, plan.getReward());
        values.put(DataBaseHelper.PLAN_DATE_CREATE, dateFormatter.format(plan.getDate_create()));
        values.put(DataBaseHelper.PLAN_ACT_LEFT, plan.getAct_left());
        values.put(DataBaseHelper.PLAN_SUCCESS, plan.getSuccess());
        values.put(DataBaseHelper.PLAN_FAIL, plan.getFail());

        long result = sqLiteDatabase.update(DataBaseHelper.TABLE_PLAN, values, WHERE_ID_EQUALS, new String[] {plan.getId() + ""});
        Log.d("Update Result: ", "=" + result);
        return result;
    }

    public int delete(int id_plan) {
        return sqLiteDatabase.delete(DataBaseHelper.TABLE_PLAN, WHERE_ID_EQUALS, new String[] {String.valueOf(id_plan)});
    }

    public ArrayList<Plan> getAllPlans() {
        ArrayList<Plan> plans = new ArrayList<Plan>();

        Cursor cursor = sqLiteDatabase.query(DataBaseHelper.TABLE_PLAN,
                new String[] {DataBaseHelper.PLAN_ID,
                        DataBaseHelper.PLAN_TITLE,
                        DataBaseHelper.PLAN_PRIORITY,
                        DataBaseHelper.PLAN_FOR,
                        DataBaseHelper.PLAN_START,
                        DataBaseHelper.PLAN_ICON,
                        DataBaseHelper.PLAN_ACT_LEFT},
                null,
                null,
                null,
                null,
                DataBaseHelper.PLAN_ACT_LEFT);

        while (cursor.moveToNext()) {
            Plan plan = new Plan();
            plan.setId(cursor.getInt(0));
            plan.setTitle(cursor.getString(1));
            plan.setPriority(cursor.getInt(2));
            plan.setFor_periode(cursor.getInt(3));
            plan.setStart(cursor.getString(4));
            plan.setIcon(cursor.getInt(5));
            plan.setAct_left(cursor.getInt(6));
            plans.add(plan);
        }
        return plans;
}
}
