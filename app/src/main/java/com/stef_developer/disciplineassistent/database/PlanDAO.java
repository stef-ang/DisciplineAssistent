package com.stef_developer.disciplineassistent.database;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.stef_developer.disciplineassistent.table_objects.Plan;

import java.text.SimpleDateFormat;
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

    public int delete(Plan plan) {
        return sqLiteDatabase.delete(DataBaseHelper.TABLE_PLAN, WHERE_ID_EQUALS, new String[] {String.valueOf(plan.getId())});
    }
}
