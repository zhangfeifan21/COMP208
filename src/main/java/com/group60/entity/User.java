package com.group60.entity;

public class User {
    private Integer user_id;
    private String email_address;
    private String password;
    private String verification_code;

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", email_address='" + email_address + '\'' +
                ", password='" + password + '\'' +
                ", verification_code='" + verification_code + '\'' +
                '}';
    }

    public User() {
    }

    public User(Integer user_id, String email_address, String password, String verification_code) {
        this.user_id = user_id;
        this.email_address = email_address;
        this.password = password;
        this.verification_code = verification_code;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerification_code() {
        return verification_code;
    }

    public void setVerification_code(String verification_code) {
        this.verification_code = verification_code;
    }
}
