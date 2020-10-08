package com.example.finalprojectapp.data.entities;

public class NewPost {
    private String avatar;
    private String fullName;
    private String datetime;
    private String message;

    public NewPost(){

    }

    public NewPost(String avatar, String fullName, String datetime, String message) {
        this.avatar = avatar;
        this.fullName = fullName;
        this.datetime = datetime;
        this.message = message;
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}
