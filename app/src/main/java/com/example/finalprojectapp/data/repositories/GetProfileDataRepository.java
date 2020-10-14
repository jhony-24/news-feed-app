package com.example.finalprojectapp.data.repositories;
import com.example.finalprojectapp.data.entities.User;
import com.example.finalprojectapp.data.interfaces.LoadUserPort;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class GetProfileDataRepository implements LoadUserPort {
    FirebaseFirestore db;
    public GetProfileDataRepository() {
        this.db = FirebaseFirestore.getInstance();
    }

    @Override
    public void getUserDataById(User user, LoadUserPort.UserDataId userDataId) {
        this.db.collection("users").whereEqualTo("id",user.getId()).addSnapshotListener((value,error) -> {
            if(error == null && value != null) {
                DocumentSnapshot queryDocumentSnapshot = value.getDocuments().get(0);
                User userInformation = new User();
                userInformation.setAvatar(queryDocumentSnapshot.get("avatar").toString());
                userInformation.setFullName(queryDocumentSnapshot.get("fullName").toString());
                userInformation.setEmail(queryDocumentSnapshot.get("email").toString());
                userDataId.getUserId(userInformation);
            }
        });
    }
}
