package com.stef_developer.disciplineassistent.adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.stef_developer.disciplineassistent.R;
import com.stef_developer.disciplineassistent.RA;
import com.stef_developer.disciplineassistent.database.PlanDAO;
import com.stef_developer.disciplineassistent.table_objects.Plan;

import org.w3c.dom.Text;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Stefanus Anggara on 16/06/2015.
 */
public class PlanAdapter extends BaseAdapter {
    private Context mContext;
    private Plan[] plans;

    public PlanAdapter(Context c, Plan[] inPlans) {
        mContext = c;
        plans = inPlans;
    }

    @Override
    public int getCount() {
        return plans.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView == null) {
            grid = new View(mContext);
            grid = inflater.inflate(R.layout.item_plan, null);

            ImageView warna_samping = (ImageView) grid.findViewById(R.id.warna_samping);
            TextView title = (TextView) grid.findViewById(R.id.tv_plan_title);
            View hori_line = grid.findViewById(R.id.v_hori_line);
            ImageView logo = (ImageView) grid.findViewById(R.id.img_logo);
            TextView act_left = (TextView) grid.findViewById(R.id.box_act_left);
            TextView time_left = (TextView) grid.findViewById(R.id.tv_time_left);
            ImageView priority = (ImageView) grid.findViewById(R.id.img_priority);
            ImageView chart = (ImageView) grid.findViewById(R.id.img_chart);
            ImageView edit = (ImageView) grid.findViewById(R.id.img_edit);

            //int gradien = 64 - ((plans[position].getAct_left() / plans[position].getFor_periode()) * 64);
            Random random = new Random();
            int gradien = random.nextInt(64);

            warna_samping.setBackgroundResource(RA.lGradien.get(gradien));
            title.setText(plans[position].getTitle());
            hori_line.setBackgroundResource(RA.lGradien.get(gradien));
            if(plans[position].getIcon() == -1) {
                logo.setImageResource(RA.lActivity.get(36));
            }
            else {
                logo.setImageResource(RA.lActivity.get(plans[position].getIcon()));
            }
            act_left.setText(plans[position].getAct_left() + "\nActivities Left");
            if(gradien < 41)
                act_left.setTextColor(Color.parseColor("#000000"));
            act_left.setBackgroundResource(RA.lGradien.get(gradien));

            int X = random.nextInt(7);
            int Y = random.nextInt(24);
            int Z = random.nextInt(60);
            time_left.setText("Activity will be start for\n"+X+" days, "+Y+" hours, and "+Z+" minutes\nfrom now");

            priority.setImageResource(RA.lPrioritySelected.get(plans[position].getPriority()));
        }
        else {
            grid = (View) convertView;
        }
        return grid;
    }
}