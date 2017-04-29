package com.example.hp.deliveryproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import Model.User;

public class RegisterActivity extends AppCompatActivity{
    private EditText et_name,et_email, et_password, et_confirmpassword, et_phone  ;
    private String name,Email,password,confirmpassword;
    Button regbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        et_name = (EditText) findViewById(R.id.name);
        et_email = (EditText) findViewById(R.id.Email);
        et_password = (EditText) findViewById(R.id.Password);
        et_confirmpassword = (EditText) findViewById(R.id.confirmpassword);
        et_phone = (EditText) findViewById(R.id.phone);
        regbtn = (Button) findViewById(R.id.registbtn);
        regbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
                User userReg =  new User(et_name.getText().toString(),et_confirmpassword.getText().toString(),true,et_email.getText().toString(),et_phone.getText().toString());
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("tables");

                myRef = myRef.child("users");
                myRef = myRef.child(userReg.getEmail());
                myRef.setValue(userReg);
            }

        });

    }
}

