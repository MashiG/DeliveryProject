package com.example.hp.deliveryproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;

/**
 * Created by murtaza on 4/30/17.
 */

public class ManagerAssignDeliveryAgent extends AppCompatActivity {
    ImageButton btnManageDelAgent = (ImageButton) findViewById(R.id.btnManageDelAgent);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.managerassigndeliveryagent);
    }
}
