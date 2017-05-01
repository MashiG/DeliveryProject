package com.example.hp.deliveryproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by murtaza on 4/29/17.
 */

public class UserDashboard extends AppCompatActivity {
    ImageButton viewImage, accountImage, changepasswordImage, addPickupRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userdashboard);
        //Access images from layout to implement action listeners
        viewImage = (ImageButton) findViewById(R.id.userdashboardimgview);
        accountImage = (ImageButton) findViewById(R.id.userdashboardimgaccount);
        changepasswordImage = (ImageButton) findViewById(R.id.userdashboardimgchangepassword);
        addPickupRequest = (ImageButton) findViewById(R.id.userdashboardimgaddpickuprequests);

        viewImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent orderRequestsViewIntent = new Intent(UserDashboard.this, UserAddPickupRequest.class);
            }
        });

        addPickupRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent userAddPickupRequest
            }
        });



    }
}
