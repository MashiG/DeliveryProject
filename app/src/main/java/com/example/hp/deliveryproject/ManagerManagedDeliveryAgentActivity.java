package com.example.hp.deliveryproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Bhagya Rathnayake on 5/1/2017.
 */

public class ManagerManagedDeliveryAgentActivity extends AppCompatActivity {
    ImageButton btnManagedDelAgent;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.managerviewdeliveryagent);

        btnManagedDelAgent = (ImageButton) findViewById(R.id.btnAddNewAgent);
        btnManagedDelAgent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerDelAgent = new Intent(ManagerManagedDeliveryAgentActivity.this,AddDeliveryPerson.class);
                startActivity(registerDelAgent);
            }
        });
    }
}
