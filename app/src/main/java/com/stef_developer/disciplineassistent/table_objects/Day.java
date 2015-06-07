package com.stef_developer.disciplineassistent.table_objects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Stefanus Anggara on 07/06/2015.
 */
public class Day implements Parcelable {

    private int id_day;
    private String name_ind;
    private String name_eng;

    public Day(int id_day, String name_ind, String name_eng) {
        super();
        this.id_day = id_day;
        this.name_ind = name_ind;
        this.name_eng = name_eng;
    }

    public Day (Parcel in) {
        super();
        this.id_day = in.readInt();
        this.name_ind = in.readString();
        this.name_eng = in.readString();
    }

    public int getId_day() {
        return id_day;
    }

    public void setId_day(int id_day) {
        this.id_day = id_day;
    }

    public String getName_ind() {
        return name_ind;
    }

    public void setName_ind(String name_ind) {
        this.name_ind = name_ind;
    }

    public String getName_eng() {
        return name_eng;
    }

    public void setName_eng(String name_eng) {
        this.name_eng = name_eng;
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
        dest.writeInt(getId_day());
        dest.writeString(getName_ind());
        dest.writeString(getName_eng());
    }

    public static final Creator<Day> CREATOR = new Creator<Day>() {
        @Override
        public Day createFromParcel(Parcel source) {
            return new Day(source);
        }

        @Override
        public Day[] newArray(int size) {
            return new Day[size];
        }
    };

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        Day other = (Day) o;
        if(id_day != other.id_day)
            return false;
        return true;
    }
}
