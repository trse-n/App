package com.example.myapplication2;

import android.content.Context;
import android.widget.Toast;

import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;

public class Utility {

    static CollectionReference getCollectionReferenceForZametki(){
        return FirebaseFirestore.getInstance().collection("zametki");
    }

    static void showToast(Context context, String message) {
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }


    static CollectionReference getCollectionReferenceForData(){
        return FirebaseFirestore.getInstance().collection("data");
    }

}
