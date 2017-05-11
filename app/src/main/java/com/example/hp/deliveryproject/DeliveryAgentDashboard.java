package com.example.hp.deliveryproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by murtaza on 5/1/17.
 */

public class DeliveryAgentDashboard extends AppCompatActivity{

    ImageButton imgBtnDeliveryAgentDashboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deliveryagentdashboard);

        imgBtnDeliveryAgentDashboard = (ImageButton) findViewById(R.id.imageButtonDeliveryAgentDashboard);

        imgBtnDeliveryAgentDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeliveryAgentDashboard.this, DeliveryAgentViewPickup.class);
                startActivity(intent);
            }
        });
    }
}
