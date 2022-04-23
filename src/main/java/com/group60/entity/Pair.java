package com.group60.entity;

public class Pair {
    private int party_id;
    private int user_id;

    public Pair(int party_id, int user_id) {
        this.party_id = party_id;
        this.user_id = user_id;
    }

    public Pair() {
    }

    public int getParty_id() {
        return party_id;
    }

    public void setParty_id(int party_id) {
        this.party_id = party_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
