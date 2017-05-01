package com.example.hp.deliveryproject;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Bhagya Rathnayake on 5/1/2017.
 */

public class ChangePassword extends AppCompatActivity {

    EditText old_password, new_password, conf_new_password;
    Button submit_button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.changepassword);
        submit_button= (Button) findViewById(R.id.buttonchangepassword);
        old_password=(EditText) findViewById(R.id.editText9);
        new_password=(EditText) findViewById(R.id.editText11);
        conf_new_password=(EditText) findViewById(R.id.editText13);
        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
