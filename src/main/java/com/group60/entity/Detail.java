package com.group60.entity;

public class Detail {
    private String gender;
    private String interests;
    private String description;
    private String contact_mobile;
    private String contact_email;

    public Detail() {
    }

    public Detail(String gender, String interests, String description, String contact_mobile, String contact_email) {
        this.gender = gender;
        this.interests = interests;
        this.description = description;
        this.contact_mobile = contact_mobile;
        this.contact_email = contact_email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContact_mobile() {
        return contact_mobile;
    }

    public void setContact_mobile(String contact_mobile) {
        this.contact_mobile = contact_mobile;
    }

    public String getContact_email() {
        return contact_email;
    }

    public void setContact_email(String contact_email) {
        this.contact_email = contact_email;
    }
}
