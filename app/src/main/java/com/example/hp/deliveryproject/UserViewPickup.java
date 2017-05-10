package com.example.hp.deliveryproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import Controller.UserViewPickupController;
import Model.DeliveryDetails;

/**
 * Created by murtaza on 5/10/17.
 */

public class UserViewPickup extends AppCompatActivity{
    private List<DeliveryDetails> deliveryDetailsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private UserViewPickupController mAdapter;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userrecyclerview);

        recyclerView = (RecyclerView) findViewById(R.id.user_recycler_view);

        mAdapter = new UserViewPickupController(deliveryDetailsList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //CONNECT TO DATABASE AND THEN SET RECYLER VIEW ADAPTER
        databaseReference = FirebaseDatabase.getInstance().getReference("tables/deliverydetails");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                prepareDeliveryDetailsData(dataSnapshot);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

    private void prepareDeliveryDetailsData(DataSnapshot dataSnapshot) {
        for(DataSnapshot dataSnapshotItem : dataSnapshot.getChildren()){
            deliveryDetailsList.add(dataSnapshotItem.getValue(DeliveryDetails.class));
            mAdapter = new UserViewPickupController(deliveryDetailsList);
            recyclerView.setAdapter(mAdapter);
        }
        mAdapter.notifyDataSetChanged();
    }


}
