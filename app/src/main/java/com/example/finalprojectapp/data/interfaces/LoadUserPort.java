package com.example.finalprojectapp.data.interfaces;

import com.example.finalprojectapp.data.entities.User;

public interface LoadUserPort {
    interface UserDataId{
        void getUserId(User user);
    }
    void getUserDataById(User user,UserDataId loadUserPort);
}
