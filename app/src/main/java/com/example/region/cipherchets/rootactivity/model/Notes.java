package com.example.region.cipherchets.rootactivity.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

import java.io.Serializable;

public class Notes implements Parcelable {
    private int id;
    private String date;
    private String time;
    private String short_desc;
    private String long_desc;
    private View view;

    public Notes(String date, String time, String short_desc, String long_desc,View view) {
        this.date = date;
        this.time = time;
        this.short_desc = short_desc;
        this.long_desc = long_desc;
        this.view = view;
    }

    public Notes() {
    }

    protected Notes(Parcel in) {
        id = in.readInt();
        date = in.readString();
        time = in.readString();
        short_desc = in.readString();
        long_desc = in.readString();
    }

    public static final Creator<Notes> CREATOR = new Creator<Notes>() {
        @Override
        public Notes createFromParcel(Parcel in) {
            return new Notes(in);
        }

        @Override
        public Notes[] newArray(int size) {
            return new Notes[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShort_desc() {
        return short_desc;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public void setShort_desc(String short_desc) {
        this.short_desc = short_desc;
    }

    public String getLong_desc() {
        return long_desc;
    }

    public void setLong_desc(String long_desc) {
        this.long_desc = long_desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(date);
        dest.writeString(time);
        dest.writeString(short_desc);
        dest.writeString(long_desc);
    }
}
