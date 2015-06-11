package com.stef_developer.disciplineassistent;

import java.util.ArrayList;

/**
 * Created by Stefanus Anggara on 12/06/2015.
 */
// RA = resource access
public class RA {

    public static final ArrayList<Integer> lPriority = new ArrayList<Integer>() {{
        add(R.drawable.p1);
        add(R.drawable.p2);
        add(R.drawable.p3);
        add(R.drawable.p4);
        add(R.drawable.p5);
    }};

    public static final ArrayList<Integer> lPrioritySelected = new ArrayList<Integer>() {{
        add(R.drawable.p1_selected);
        add(R.drawable.p2_selected);
        add(R.drawable.p3_selected);
        add(R.drawable.p4_selected);
        add(R.drawable.p5_selected);
    }};

    public static final ArrayList<Integer> lDay = new ArrayList<Integer>() {{
        add(R.drawable.d0);
        add(R.drawable.d1);
        add(R.drawable.d2);
        add(R.drawable.d3);
        add(R.drawable.d4);
        add(R.drawable.d5);
        add(R.drawable.d6);
    }};

    public static final ArrayList<Integer> lDaySelected = new ArrayList<Integer>() {{
        add(R.drawable.d0_selected);
        add(R.drawable.d1_selected);
        add(R.drawable.d2_selected);
        add(R.drawable.d3_selected);
        add(R.drawable.d4_selected);
        add(R.drawable.d5_selected);
        add(R.drawable.d6_selected);
    }};
}
