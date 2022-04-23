package com.group60.entity;

public class CheckMember {
    private int current_member;
    private int max_member;

    public CheckMember() {
    }

    public CheckMember(int current_member, int max_member) {
        this.current_member = current_member;
        this.max_member = max_member;
    }

    public int getCurrent_member() {
        return current_member;
    }

    public void setCurrent_member(int current_member) {
        this.current_member = current_member;
    }

    public int getMax_member() {
        return max_member;
    }

    public void setMax_member(int max_member) {
        this.max_member = max_member;
    }
}
