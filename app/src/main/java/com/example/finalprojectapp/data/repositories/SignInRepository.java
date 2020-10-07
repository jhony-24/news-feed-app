package com.example.finalprojectapp.data.repositories;
import com.example.finalprojectapp.data.interfaces.ManagementAccessPort;
import com.example.finalprojectapp.data.entities.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignInRepository implements ManagementAccessPort.SignIn {

    FirebaseAuth auth;
    public SignInRepository() {
        this.auth = FirebaseAuth.getInstance();
    }
    @Override
    public void signIn(User user, ManagementAccessPort.StatusAccess statusAccess) {
        this.auth.signInWithEmailAndPassword(user.email,user.password).addOnCompleteListener((task)->{
            if (task.isSuccessful()) {
                FirebaseUser firebaseUser = task.getResult().getUser();
                User userModel = new User();
                userModel.email = firebaseUser.getEmail();
                userModel.token = firebaseUser.getUid();
                statusAccess.success(userModel);
            }
            else {
                statusAccess.failed();
            }
        });
    }
}
