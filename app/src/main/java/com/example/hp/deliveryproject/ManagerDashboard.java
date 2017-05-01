package com.example.hp.deliveryproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by murtaza on 4/30/17.
 */

public class ManagerDashboard extends AppCompatActivity {

    ImageButton btnManageDelAgent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.managerdashboard);

        btnManageDelAgent = (ImageButton) findViewById(R.id.btnManageDelAgent);
        btnManageDelAgent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent manageDelAgent = new Intent(ManagerDashboard.this,ManagerManagedDeliveryAgentActivity.class);
                startActivity(manageDelAgent);
            }
        });

    }
}
