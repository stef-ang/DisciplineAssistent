package com.stef_developer.disciplineassistent.table_objects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Stefanus Anggara on 07/06/2015.
 */
public class Plan_Day implements Parcelable {

    private int id_p_d;
    private int id_plan;
    private int id_day;

    public Plan_Day(int id_p_d, int id_plan, int day_id) {
        super();
        this.id_p_d = id_p_d;
        this.id_plan = id_plan;
        this.id_day = day_id;
    }

    public Plan_Day(int id_plan, int day_id) {
        super();
        this.id_plan = id_plan;
        this.id_day = day_id;
    }

    public Plan_Day(Parcel in) {
        super();
        this.id_p_d = in.readInt();
        this.id_plan = in.readInt();
        this.id_day = in.readInt();
    }

    public int getId_p_d() {
        return id_p_d;
    }

    public void setId_p_d(int id_p_d) {
        this.id_p_d = id_p_d;
    }

    public int getId_plan() {
        return id_plan;
    }

    public void setId_plan(int id_plan) {
        this.id_plan = id_plan;
    }

    public int getId_day() {
        return id_day;
    }

    public void setId_day(int id_day) {
        this.id_day = id_day;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(getId_p_d());
        dest.writeInt(getId_plan());
        dest.writeInt(getId_day());
    }

    public static final Creator<Plan_Day> CREATOR = new Creator<Plan_Day>() {
        @Override
        public Plan_Day createFromParcel(Parcel source) {
            return new Plan_Day(source);
        }

        @Override
        public Plan_Day[] newArray(int size) {
            return new Plan_Day[size];
        }
    };

    @Override
    public int hashCode() {
        final int primne = 31;
        int result = 1;
        result = primne * result + id_p_d;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        Plan_Day other = (Plan_Day) o;
        if (id_p_d != other.id_p_d)
            return false;
        return true;
    }
}
