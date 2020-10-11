package com.example.finalprojectapp.data.entities;

public class NewsFeedUser extends  User {
    public NewsFeedUser() {
        super();
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setAvatar(String avatar){
        this.avatar = avatar;
    }

    public String getAvatar() {
        return this.avatar;
    }
}
