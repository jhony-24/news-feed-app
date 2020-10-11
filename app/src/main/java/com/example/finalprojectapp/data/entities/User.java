package com.example.finalprojectapp.data.entities;

public class User {
    public String fullName;
    public String username;
    public String email;
    public String password;
    public String description;
    public String token;
    public String avatar;

    public User(){ }
    public User(String fullName, String username, String email, String password, String description, String token) {
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.description = description;
        this.token = token;
    }
}
