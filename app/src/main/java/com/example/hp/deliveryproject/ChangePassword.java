package com.example.hp.deliveryproject;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Bhagya Rathnayake on 5/1/2017.
 */

public class ChangePassword extends AppCompatActivity {

    EditText old_password, new_password, conf_new_password;
    Button submit_button;
    SharedPreferences svUserName;
    String currentUser;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.changepassword);
        submit_button= (Button) findViewById(R.id.buttonchangepassword);
        old_password=(EditText) findViewById(R.id.editText9);
        currentUser=svUserName.
        //old_password.setText(svUserName.toString());
        new_password=(EditText) findViewById(R.id.editText11);
        conf_new_password=(EditText) findViewById(R.id.editText13);
        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                svUserName = getSharedPreferences("MYPREFS",0);
                //currentUser=svUserName.getString("email","");
                //overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
                FirebaseDatabase chkDB= FirebaseDatabase.getInstance();
                DatabaseReference chkref=chkDB.getReference("table");
                //chkref=chkref.child("users");
                chkref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Snackbar mySnackbar = Snackbar.make(getWindow().getDecorView().findViewById(android.R.id.content), svUserName.toString(), Snackbar.LENGTH_LONG);
                        mySnackbar.show();
                        //if (dataSnapshot.child("users").hasChild(svUserName.toString())){

                        //}
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
