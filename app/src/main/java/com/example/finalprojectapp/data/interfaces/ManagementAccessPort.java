package com.example.finalprojectapp.data.interfaces;

import com.example.finalprojectapp.data.entities.PersistKeyValue;
import com.example.finalprojectapp.data.entities.User;

import java.util.Map;

public interface ManagementAccessPort {
    interface StatusAccess {
        void success(User user);
        void failed();
    }
    interface SignIn {
        void signIn(User user, StatusAccess statusAccess);
    }

    interface SignUp {
        void signUp(User user,StatusAccess statusAccess);
    }
    interface PersistAccountAccess{
        void persist(PersistKeyValue[] valuesPersist);
        String getPersistValue( String key);
    }
}
