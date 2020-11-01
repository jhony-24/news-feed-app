package com.example.finalprojectapp.data.repositories;
import com.example.finalprojectapp.data.interfaces.ManagementAccessPort;
import com.example.finalprojectapp.data.entities.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class SignInRepository implements ManagementAccessPort.SignIn {

    FirebaseAuth auth;
    FirebaseFirestore store;
    public SignInRepository() {
        this.auth = FirebaseAuth.getInstance();
        this.store = FirebaseFirestore.getInstance();
    }
    @Override
    public void signIn(User user, ManagementAccessPort.StatusAccess statusAccess) {
        SignInRepository self = this;
        this.auth.signInWithEmailAndPassword(user.getEmail(),user.getPassword()).addOnCompleteListener((task)->{
            if (task.isSuccessful()) {
                FirebaseUser firebaseUser = task.getResult().getUser();
                String userId = firebaseUser.getUid();
                self.store.collection("users").whereEqualTo("id",userId).get().addOnCompleteListener(runnable -> {
                    QuerySnapshot querySnapshot = runnable.getResult();
                    DocumentSnapshot data = querySnapshot.getDocuments().get(0);
                    User userModel = new User();
                    userModel.setId(data.getString("id"));
                    userModel.setEmail(data.getString("email"));
                    userModel.setFullName(data.getString("fullName"));
                    statusAccess.success(userModel);
                });

            }
            else {
                statusAccess.failed();
            }
        });
    }
}
