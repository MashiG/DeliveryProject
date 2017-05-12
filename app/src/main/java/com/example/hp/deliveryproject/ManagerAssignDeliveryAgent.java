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
    EditText et_name;
    ImageButton assignAgent;
    Button allocate;
    private String name;
    private String deliveryID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.managerallocatedeliveryagent);
        et_name=(EditText) findViewById(R.id.etName);
        allocate = (Button) findViewById(R.id.buttonallocate);
        name=et_name.getText().toString();
        allocate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Get the bundle
                Bundle bundle = getIntent().getExtras();

                //Extract the data…
                final String deliveryID1 = bundle.getString("deliveryID");

                System.out.println("DELIVERY ID "+deliveryID1);


                FirebaseDatabase chkDB= FirebaseDatabase.getInstance();
                DatabaseReference chkref=chkDB.getReference("tables/deliverydetails");
                chkref.child(deliveryID1).child("deliveryAgentID").setValue(et_name.getText().toString());
                finish();

//                chkref.addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//
//                        if (dataSnapshot.hasChild(deliveryID1)){
//                            FirebaseDatabase DBupdate= FirebaseDatabase.getInstance();
//                            DatabaseReference DBupdatRef= DBupdate.getReference("tables/deliverydetails/"+deliveryID1+"/status");
//                            DBupdatRef.setValue("allocated");//(UserUpdatePassword);
//                            DBupdatRef= DBupdate.getReference("tables/deliverydetails/"+deliveryID1+"/status/deliveryAgentID");
//                            DBupdatRef.setValue(""+name);
//                            Snackbar mySnackbar = Snackbar.make(getWindow().getDecorView().findViewById(android.R.id.content), "Update Successfully", Snackbar.LENGTH_LONG);
//                            mySnackbar.show();
//                            finish();
//
//
////                            Snackbar mySnackbar1 = Snackbar.make(getWindow().getDecorView().findViewById(android.R.id.content), currentUser+" done", Snackbar.LENGTH_LONG);
////                            mySnackbar1.show();
////
////                            UserUpdatePassword.setPassword(new_password.getText().toString());
//
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError databaseError) {
//
//                    }
//                });

            }
        });
    }

//    private void assignDelAgent(String Agent)
//    {
//
//        //Get the bundle
//        Bundle bundle = getIntent().getExtras();
//
//        //Extract the data…
//        String deliveryID1 = bundle.getString("deliveryID");
//
//        System.out.println("DELIVERY ID "+deliveryID1);
//        System.out.println("AGENT "+Agent);
//
//
//
////        FirebaseDatabase database = FirebaseDatabase.getInstance();
////        DatabaseReference myRef = database.getReference("tables");
////        myRef.child("deliverydetails").child(""+deliveryID1).child("status").setValue("assigned");
////        myRef.child("deldeliverydetails").child(""+deliveryID1).child("deliveryAgentID").setValue(Agent);
////        System.out.println();
//    }

}
