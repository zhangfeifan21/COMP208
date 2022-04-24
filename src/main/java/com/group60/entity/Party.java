package com.group60.entity;


import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Party {
    private int party_id;
    private String title;
    private String description;
    private int max_member;
    private int current_member;
    private String place;
    private int belongs_to;
    private String holder_name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date start_time;

    public Party() {
    }

    public Party(int party_id, String title, String description, int max_member, int current_member, String place, int belongs_to, String holder_name, Date start_time) {
        this.party_id = party_id;
        this.title = title;
        this.description = description;
        this.max_member = max_member;
        this.current_member = current_member;
        this.place = place;
        this.belongs_to = belongs_to;
        this.holder_name = holder_name;
        this.start_time = start_time;
    }

    public int getParty_id() {
        return party_id;
    }

    public void setParty_id(int party_id) {
        this.party_id = party_id;
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

    public String getHolder_name() {
        return holder_name;
    }

    public void setHolder_name(String holder_name) {
        this.holder_name = holder_name;
    }
}
