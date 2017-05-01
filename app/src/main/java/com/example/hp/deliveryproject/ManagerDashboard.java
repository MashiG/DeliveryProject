package com.example.hp.deliveryproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by murtaza on 4/30/17.
 */

public class ManagerDashboard extends AppCompatActivity {
    Button btnManageDelAgent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.managerdashboard);

        btnManageDelAgent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent manageDelAgent = new Intent(ManagerDashboard.this,AddDeliveryPerson.class);
                startActivity(manageDelAgent);
            }
        });
    }
}
