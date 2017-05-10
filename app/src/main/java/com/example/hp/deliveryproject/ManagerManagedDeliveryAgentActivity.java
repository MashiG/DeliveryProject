package com.example.hp.deliveryproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import Controller.OrdersListController;
import Model.DeliveryDetails;

/**
 * Created by Bhagya Rathnayake on 5/1/2017.
 */

public class ManagerManagedDeliveryAgentActivity extends AppCompatActivity {
    ImageButton btnManagedDelAgent;
    private List<DeliveryDetails> deliveryList = new ArrayList<>();
    private RecyclerView recyclerView;
    private OrdersListController orderListController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.managerviewdeliveryagent);

        recyclerView= (RecyclerView) findViewById(R.id.recycler_view_list);
        orderListController = new OrdersListController(deliveryList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(orderListController);
        prepareMovieData();


        btnManagedDelAgent = (ImageButton) findViewById(R.id.btnAddNewAgent);
        btnManagedDelAgent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerDelAgent = new Intent(ManagerManagedDeliveryAgentActivity.this,AddDeliveryPerson.class);
                startActivity(registerDelAgent);
            }
        });



    }

    private void prepareMovieData() {

//        Iterator<DeliveryDetails> itr = deliveryList.iterator();
//
//        if(deliveryList.size()==0)
//        {
////            Toast emptyListMessage = new Toast.makeText(ManagerViewPickup.this,"",Toast.LENGTH_LONG);
////            emptyListMessage.setGravity(Gravity.CENTER,0,0);
////            emptyListMessage.show();
//        }
//
//        while(itr.hasNext())
//        {
        DeliveryDetails delDet = new DeliveryDetails("one","one","one","one","one","one","one","one","one");
        deliveryList.add(delDet);

        delDet = new DeliveryDetails("one","one","one","one","one","one","one","one","one");
        deliveryList.add(delDet);

        delDet = new DeliveryDetails("one","one","one","one","one","one","one","one","one");
        deliveryList.add(delDet);

        delDet = new DeliveryDetails("one","one","one","one","one","one","one","one","one");
        deliveryList.add(delDet);

        delDet = new DeliveryDetails("one","one","one","one","one","one","one","one","one");
        deliveryList.add(delDet);

        delDet = new DeliveryDetails("one","one","one","one","one","one","one","one","one");
        deliveryList.add(delDet);

        delDet = new DeliveryDetails("one","one","one","one","one","one","one","one","one");
        deliveryList.add(delDet);

        delDet = new DeliveryDetails("one","one","one","one","one","one","one","one","one");
        deliveryList.add(delDet);

        delDet = new DeliveryDetails("one","one","one","one","one","one","one","one","one");
        deliveryList.add(delDet);

        delDet = new DeliveryDetails("one","one","one","one","one","one","one","one","one");
        deliveryList.add(delDet);

        delDet = new DeliveryDetails("one","one","one","one","one","one","one","one","one");
        deliveryList.add(delDet);

        delDet = new DeliveryDetails("one","one","one","one","one","one","one","one","one");
        deliveryList.add(delDet);

        delDet = new DeliveryDetails("one","one","one","one","one","one","one","one","one");
        deliveryList.add(delDet);
//        }


    }


}
