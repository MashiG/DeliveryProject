package com.example.hp.deliveryproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by murtaza on 5/1/17.
 */

public class DeliveryAgentDashboard extends AppCompatActivity{

    ImageButton imgBtnDeliveryAgentDashboard;
    Button logOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deliveryagentdashboard);

        imgBtnDeliveryAgentDashboard = (ImageButton) findViewById(R.id.imageButtonDeliveryAgentDashboard);
        logOut= (Button) findViewById(R.id.buttonlogout);

        imgBtnDeliveryAgentDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeliveryAgentDashboard.this, DeliveryAgentViewPickup.class);
                startActivity(intent);
            }
        });

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intt = new Intent(DeliveryAgentDashboard.this,MainActivity.class);
                startActivity(intt);
                finish();
            }
        });
    }
}
