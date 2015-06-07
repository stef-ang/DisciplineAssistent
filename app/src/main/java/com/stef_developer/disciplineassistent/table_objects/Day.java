package com.stef_developer.disciplineassistent.table_objects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Stefanus Anggara on 07/06/2015.
 */
public class Day implements Parcelable {

    private String name;
    private String fullname;

    public Day (String name, String fullname) {
        super();
        this.name = name;
        this.fullname = fullname;
    }

    public Day (Parcel in) {
        super();
        this.name = in.readString();
        this.fullname = in.readString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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
        dest.writeString(getName());
        dest.writeString(getFullname());
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
        if(name != other.name)
            return false;
        return true;
    }
}
