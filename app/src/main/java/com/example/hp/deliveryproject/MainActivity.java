package com.example.hp.deliveryproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import Model.User;

public class MainActivity extends AppCompatActivity {
    Button regBtn, loginBtn;
    EditText textPassword, textEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        regBtn= (Button) findViewById(R.id.registerBtn);
        loginBtn = (Button) findViewById(R.id.loginBtn);
        textPassword = (EditText) findViewById((R.id.textPassword));
        textEmail = (EditText) findViewById(R.id.textEmailAddress);
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registrationIntent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(registrationIntent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }

        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("tables");
                myRef = myRef.child("users");
                myRef = myRef.child(textEmail.getText().toString());
                if(myRef == null)
                    loginStatus(false);
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        User user = dataSnapshot.getValue(User.class);
                        if(textPassword.getText().toString().equals(user.getPassword()))
                            loginStatus(true);
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });
        // Write a message to the database

        /*User user = new User();
        user.setUsername("murtazasmart");
        user.setPassword("hello");

        myRef.setValue(user);

        User usertra;

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User trialuser = dataSnapshot.getValue(User.class);
                System.out.println(trialuser.getUsername());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/
        //TEST COMMIT BHAGYA
        //testing 123 kasun :D
    }

    public void loginStatus(boolean loggedIn){
        System.out.println("EMAIL  - "+textEmail.getText().toString());
        if(loggedIn){
            System.out.println("LOGGED IN "+textEmail.getText().toString());
            Intent userDashboard = new Intent(MainActivity.this, UserDashboard.class );
            startActivity(userDashboard);
        }
        else{
            System.out.println("ERROR LOGGIN"+textEmail.getText().toString());
        }

    }
}
