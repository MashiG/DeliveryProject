package com.example.hp.deliveryproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Bhagya Rathnayake on 5/11/2017.
 */

public class UpdateUserAcoountActivity extends AppCompatActivity {

    Button updateButton;
    TextView userName,Telephone;
    String name,phone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updateaccount);
        updateButton = (Button) findViewById(R.id.buttonupdate);
        userName= (TextView) findViewById(R.id.nameinput);
        Telephone= (TextView) findViewById(R.id.phoneinput);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=userName.getText().toString();
                phone=Telephone.getText().toString();
                UpdateData(name,phone);
            }
        });

    }

    private void UpdateData(String Name,String Phone)
    {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference DBupdatRef= db.getReference("tables");
        DBupdatRef.child("users").child(name).child("phoneNumber").setValue(Phone);
        Toast.makeText(this, "Succesfully Updated details of "+name, Toast.LENGTH_SHORT).show();
    }

}
