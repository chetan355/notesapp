package com.example.region.cipherchets.rootactivity.model;

import android.view.View;

public class Notes {
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
}
