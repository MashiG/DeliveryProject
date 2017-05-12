package com.example.hp.deliveryproject;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import Model.User;

/**
 * Created by murtaza on 4/30/17.
 */

public class ManagerAssignDeliveryAgent extends AppCompatActivity {
    ImageButton assignAgent;
    Button allocate;
    private String name;
    private EditText et_name;
    private String deliveryID;

//    public ManagerAssignDeliveryAgent(int Id)
//    {
//        assignDelAgent(Id);
//        System.out.println("MANAGER ACCESSED");
//    }


/*
    private void assignDelAgent(int DelId)
    {
        System.out.println("METHOD ACCESSED");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("tables");
        myRef.child("deliverydetails").child(""+DelId).child("status").setValue("assigned");
        System.out.println("DELIVERY UPDATED");
    }*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.managerallocatedeliveryagent);
        allocate = (Button) findViewById(R.id.buttonallocate);

        allocate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Get the bundle
                Bundle bundle = getIntent().getExtras();

                //Extract the data…
                String deliveryID1 = bundle.getString("deliveryID");

                System.out.println("DELIVERY ID "+deliveryID1);

                et_name=(EditText) findViewById(R.id.name);
                FirebaseDatabase chkDB= FirebaseDatabase.getInstance();
                DatabaseReference chkref=chkDB.getReference("tables/deliverydetails");
                chkref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        if (dataSnapshot.hasChild(deliveryID)){
                            FirebaseDatabase DBupdate= FirebaseDatabase.getInstance();
                            DatabaseReference DBupdatRef= DBupdate.getReference("tables/deliverydetails/"+deliveryID+"/status");
                            DBupdatRef.setValue("allocated");//(UserUpdatePassword);
                            DBupdatRef= DBupdate.getReference("tables/deliverydetails/"+deliveryID+"/status/deliveryAgentID");
                            DBupdatRef.setValue(et_name);
                            Snackbar mySnackbar = Snackbar.make(getWindow().getDecorView().findViewById(android.R.id.content), "Update Successfully", Snackbar.LENGTH_LONG);
                            mySnackbar.show();
                            finish();


                            //Snackbar mySnackbar1 = Snackbar.make(getWindow().getDecorView().findViewById(android.R.id.content), currentUser+" done", Snackbar.LENGTH_LONG);
                            //mySnackbar1.show();

                            //UserUpdatePassword.setPassword(new_password.getText().toString());

                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });
    }

}
