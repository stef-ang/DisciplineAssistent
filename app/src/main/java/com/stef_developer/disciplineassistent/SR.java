package com.stef_developer.disciplineassistent;

import android.widget.ImageView;

/**
 * Created by Stefanus Anggara on 12/06/2015.
 */
// SR = set resource
public class SR {
    public static void setImgP (ImageView img, int p) {
        img.setImageResource(RA.lPriority.get(p));
//        img.setTag(RA.lPriority.get(p));
    }

    public static void setImgPSelected (ImageView img, int p) {
        img.setImageResource(RA.lPrioritySelected.get(p));
//        img.setTag(RA.lPrioritySelected.get(p));
    }

    public static void setImgD (ImageView img, int p) {
        img.setImageResource(RA.lDay.get(p));
//        img.setTag(RA.lDay.get(p));
    }

    public static void setImgDSelected (ImageView img, int p) {
        img.setImageResource(RA.lDaySelected.get(p));
//        img.setTag(RA.lDaySelected.get(p));
    }
}
