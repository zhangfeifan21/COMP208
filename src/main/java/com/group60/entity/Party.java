package com.group60.entity;


import java.util.Date;

public class Party {
    private String title;
    private String description;
    private int max_member;
    private int current_member;
    private String place;
    private int belongs_to;
    private Date start_time;

    public Party() {
    }

    public Party(String title, String description, int maximum_member, int current_member, String place, int belongs_to, Date start_time) {
        this.title = title;
        this.description = description;
        this.max_member = maximum_member;
        this.current_member = current_member;
        this.place = place;
        this.belongs_to = belongs_to;
        this.start_time = start_time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMax_member() {
        return max_member;
    }

    public void setMax_member(int maximum_member) {
        this.max_member = maximum_member;
    }

    public int getCurrent_member() {
        return current_member;
    }

    public void setCurrent_member(int current_member) {
        this.current_member = current_member;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getBelongs_to() {
        return belongs_to;
    }

    public void setBelongs_to(int belongs_to) {
        this.belongs_to = belongs_to;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }
}
