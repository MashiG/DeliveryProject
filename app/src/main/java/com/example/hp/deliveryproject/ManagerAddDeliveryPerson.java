package com.example.hp.deliveryproject;

import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
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
 * Created by murtaza on 5/10/17.
 */

public class ManagerAddDeliveryPerson extends AppCompatActivity {

    private EditText et_name, et_email, et_password, et_phone  ;
    private String name,Email,password,phone;
    Button regbtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        et_name=(EditText) findViewById(R.id.name);
        et_email=(EditText)findViewById(R.id.Email);
        et_password=(EditText) findViewById(R.id.Password);
        et_phone=(EditText) findViewById(R.id.phone);
        regbtn=(Button) findViewById(R.id.registbtn);

        regbtn.setOnClickListener(new View.OnClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.ECLAIR)
            @Override
            public void onClick(View v){
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference rootRef =database.getReference("tables");
                rootRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

    }
}
