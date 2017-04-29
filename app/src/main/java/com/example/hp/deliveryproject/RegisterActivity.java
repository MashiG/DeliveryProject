package com.example.hp.deliveryproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    private EditText et_name,et_email, et_password, et_confirmpassword  ;
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
        regbtn = (Button) findViewById(R.id.registbtn);
        regbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }

        });
        //hello im here murtaza

    }
    }

