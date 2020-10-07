package com.example.finalprojectapp.data.repositories;
import com.example.finalprojectapp.data.entities.User;
import com.example.finalprojectapp.data.interfaces.ManagementAccessPort;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;

public class SignUpRepository implements ManagementAccessPort.SignUp {
    FirebaseAuth auth;
    FirebaseFirestore store;
    public SignUpRepository() {
        this.auth = FirebaseAuth.getInstance();
        this.store = FirebaseFirestore.getInstance();
    }

    @Override
    public void signUp(User user, ManagementAccessPort.StatusAccess statusAccess) {
        SignUpRepository self = this;
        self.auth.createUserWithEmailAndPassword(user.email,user.password).addOnCompleteListener(taskAuth -> {
            if(taskAuth.isSuccessful()) {
                self.store.collection("users").add(self.newUser(user)).addOnCompleteListener(taskCollection -> {
                    statusAccess.success(user);
                });
            }
            else {
                statusAccess.failed();
            }
        });
    }

    private Map<String,Object> newUser(User user) {
        Map<String,Object> newMapUser = new HashMap<String,Object>();
        newMapUser.put("email", user.email);
        newMapUser.put("fullName", user.fullName);
        newMapUser.put("description",user.description);
        return newMapUser;
    }
}
