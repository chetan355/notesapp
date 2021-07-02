package com.example.region.cipherchets.rootactivity.model;

public class Notes {
    private int id;
    private String date;
    private String time;
    private String short_desc;
    private String long_desc;

    public Notes(String date, String time, String short_desc, String long_desc) {
        this.date = date;
        this.time = time;
        this.short_desc = short_desc;
        this.long_desc = long_desc;
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
