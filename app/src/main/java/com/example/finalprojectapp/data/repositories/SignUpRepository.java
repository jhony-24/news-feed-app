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
        System.out.println("clicked");
        self.auth.createUserWithEmailAndPassword(user.getEmail(),user.getPassword()).addOnCompleteListener(taskAuth -> {
            if(taskAuth.isSuccessful()) {
                String newUserId = taskAuth.getResult().getUser().getUid();
                self.store.collection("users").add(self.newUser(user, newUserId)).addOnCompleteListener(taskCollection -> {
                    statusAccess.success(user);
                });
            }
            else {
                statusAccess.failed();
            }
        });
    }

    private Map<String,Object> newUser(User user,String userId) {
        Map<String,Object> newMapUser = new HashMap<String,Object>();
        newMapUser.put("id",userId);
        newMapUser.put("email", user.getEmail());
        newMapUser.put("fullName", user.getFullName());
        newMapUser.put("avatar", user.getAvatar());
        return newMapUser;
    }
}
