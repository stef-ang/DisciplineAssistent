package com.stef_developer.disciplineassistent.table_objects;

import android.os.Parcel;
import android.os.Parcelable;

import java.sql.Time;
import java.util.Date;

/**
 * Created by Stefanus Anggara on 07/06/2015.
 */
public class Plan implements Parcelable {

    private int id;
    private String title;
    private String detail;
    private String priority;
    private int for_periode;
    private Time start;
    private Time finish;
    private String motivation;
    private String icon;
    private String reward;
    private Date date_create;
    private int act_left;
    private int success;
    private int fail;

    public Plan() {
        super();
    }

    public Plan(Date date_create) {
        super();
        this.date_create = date_create;
    }

    private Plan (Parcel in) {
        super();
        this.id = in.readInt();
        this.title = in.readString();
        this.detail = in.readString();
        this.priority = in.readString();
        this.for_periode = in.readInt();
        this.start = new Time(in.readLong());
        this.finish = new Time(in.readLong());
        this.motivation = in.readString();
        this.icon = in.readString();
        this.reward = in.readString();
        this.date_create = new Date(in.readLong());
        this.act_left = in.readInt();
        this.success = in.readInt();
        this.fail = in.readInt();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public int getFor_periode() {
        return for_periode;
    }

    public void setFor_periode(int for_periode) {
        this.for_periode = for_periode;
    }

    public Time getStart() {
        return start;
    }

    public void setStart(Time start) {
        this.start = start;
    }

    public Time getFinish() {
        return finish;
    }

    public void setFinish(Time finish) {
        this.finish = finish;
    }

    public String getMotivation() {
        return motivation;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public Date getDate_create() {
        return date_create;
    }

    public void setDate_create(Date date_create) {
        this.date_create = date_create;
    }

    public int getAct_left() {
        return act_left;
    }

    public void setAct_left(int act_left) {
        this.act_left = act_left;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public int getFail() {
        return fail;
    }

    public void setFail(int fail) {
        this.fail = fail;
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
        dest.writeInt(getId());
        dest.writeString(getTitle());
        dest.writeString(getDetail());
        dest.writeString(getPriority());
        dest.writeInt(getFor_periode());
        dest.writeLong(getStart().getTime());
        dest.writeLong(getFinish().getTime());
        dest.writeString(getMotivation());
        dest.writeString(getIcon());
        dest.writeString(getReward());
        dest.writeLong(getDate_create().getTime());
        dest.writeInt(getAct_left());
        dest.writeInt(getSuccess());
        dest.writeInt(getFail());
    }

    public static final Creator<Plan> CREATOR = new Creator<Plan>() {
        @Override
        public Plan createFromParcel(Parcel source) {
            return new Plan(source);
        }

        @Override
        public Plan[] newArray(int size) {
            return new Plan[size];
        }
    };

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
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
        Plan other = (Plan) o;
        if(id != other.id)
            return false;
        return true;
    }
}
