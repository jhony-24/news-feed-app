package com.example.finalprojectapp.data.entities;

public class User {
    private String id;
    private String fullName;
    private String username;
    private String email;
    private String password;
    private String description;
    private String token;
    private String avatar;

    public User(){ }
    public User(String fullName, String username, String email, String password, String description, String token) {
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.description = description;
        this.token = token;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
