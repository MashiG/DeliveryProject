package com.example.hp.deliveryproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import Controller.OrdersListController;
import Model.DeliveryDetails;

/**
 * Created by murtaza on 4/30/17.
 */

public class ManagerViewPickup extends AppCompatActivity {

    private List<DeliveryDetails> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private OrdersListController orderListController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.managerviewpickup);
        setContentView(R.layout.recycler_view_layout);

        System.out.println("HELLO WORLD");

        recyclerView= (RecyclerView) findViewById(R.id.recycler_view);
        orderListController = new OrdersListController(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(orderListController);

        prepareMovieData();




    }

    private void prepareMovieData() {
        DeliveryDetails delDet = new DeliveryDetails("one","one","one","one","one","one","one","one","one");
        movieList.add(delDet);

        delDet= new DeliveryDetails("one1","one1","one1","one1","one1","one1","one1","one1","one1");
        movieList.add(delDet);
        delDet= new DeliveryDetails("one1","one1","one1","one1","one1","one1","one1","one1","one1");
        movieList.add(delDet);delDet= new DeliveryDetails("one1","one1","one1","one1","one1","one1","one1","one1","one1");
        movieList.add(delDet);delDet= new DeliveryDetails("one1","one1","one1","one1","one1","one1","one1","one1","one1");
        movieList.add(delDet);delDet= new DeliveryDetails("one1","one1","one1","one1","one1","one1","one1","one1","one1");
        movieList.add(delDet);delDet= new DeliveryDetails("one1","one1","one1","one1","one1","one1","one1","one1","one1");
        movieList.add(delDet);delDet= new DeliveryDetails("one1","one1","one1","one1","one1","one1","one1","one1","one1");
        movieList.add(delDet);delDet= new DeliveryDetails("one1","one1","one1","one1","one1","one1","one1","one1","one1");
        movieList.add(delDet);delDet= new DeliveryDetails("one1","one1","one1","one1","one1","one1","one1","one1","one1");
        movieList.add(delDet);delDet= new DeliveryDetails("one1","one1","one1","one1","one1","one1","one1","one1","one1");
        movieList.add(delDet);delDet= new DeliveryDetails("one1","one1","one1","one1","one1","one1","one1","one1","one1");
        movieList.add(delDet);delDet= new DeliveryDetails("one1","one1","one1","one1","one1","one1","one1","one1","one1");
        movieList.add(delDet);delDet= new DeliveryDetails("one1","one1","one1","one1","one1","one1","one1","one1","one1");
        movieList.add(delDet);delDet= new DeliveryDetails("one1","one1","one1","one1","one1","one1","one1","one1","one1");
        movieList.add(delDet);delDet= new DeliveryDetails("one1","one1","one1","one1","one1","one1","one1","one1","one1");
        movieList.add(delDet);delDet= new DeliveryDetails("one1","one1","one1","one1","one1","one1","one1","one1","one1");
        movieList.add(delDet);delDet= new DeliveryDetails("one1","one1","one1","one1","one1","one1","one1","one1","one1");
        movieList.add(delDet);delDet= new DeliveryDetails("one1","one1","one1","one1","one1","one1","one1","one1","one1");
        movieList.add(delDet);delDet= new DeliveryDetails("one1","one1","one1","one1","one1","one1","one1","one1","one1");
        movieList.add(delDet);delDet= new DeliveryDetails("one1","one1","one1","one1","one1","one1","one1","one1","one1");
        movieList.add(delDet);delDet= new DeliveryDetails("one1","one1","one1","one1","one1","one1","one1","one1","one1");
        movieList.add(delDet);delDet= new DeliveryDetails("one1","one1","one1","one1","one1","one1","one1","one1","one1");
        movieList.add(delDet);delDet= new DeliveryDetails("one1","one1","one1","one1","one1","one1","one1","one1","one1");
        movieList.add(delDet);delDet= new DeliveryDetails("one1","one1","one1","one1","one1","one1","one1","one1","one1");
        movieList.add(delDet);delDet= new DeliveryDetails("one1","one1","one1","one1","one1","one1","one1","one1","one1");
        movieList.add(delDet);delDet= new DeliveryDetails("one1","one1","one1","one1","one1","one1","one1","one1","one1");
        movieList.add(delDet);delDet= new DeliveryDetails("one1","one1","one1","one1","one1","one1","one1","one1","one1");
        movieList.add(delDet);delDet= new DeliveryDetails("one1","one1","one1","one1","one1","one1","one1","one1","one1");
        movieList.add(delDet);delDet= new DeliveryDetails("one1","one1","one1","one1","one1","one1","one1","one1","one1");
        movieList.add(delDet);delDet= new DeliveryDetails("one1","one1","one1","one1","one1","one1","one1","one1","one1");
        movieList.add(delDet);delDet= new DeliveryDetails("one1","one1","one1","one1","one1","one1","one1","one1","one1");
        movieList.add(delDet);
        orderListController.notifyDataSetChanged();

    }

}
