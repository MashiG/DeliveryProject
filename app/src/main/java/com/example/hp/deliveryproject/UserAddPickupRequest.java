package com.example.hp.deliveryproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.math.BigDecimal;

import Model.DeliveryDetails;
import Model.Packages;

/**
 * Created by murtaza on 4/30/17.
 */

public class UserAddPickupRequest extends AppCompatActivity implements View.OnFocusChangeListener{

    EditText lengthText, widthText, heightText;
    BigDecimal volume, price, length, width, height;
    TextView priceDisplay;
    Button submit;
    EditText deliveryDateText, toLocationText, fromLocationText, phoneText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.useraddpickuprequest);

        lengthText = (EditText) findViewById(R.id.userAddPickupRequestLength);
        widthText = (EditText) findViewById(R.id.userAddPickupRequestWidth);
        heightText = (EditText) findViewById(R.id.userAddPickupRequestHeight);
        priceDisplay = (TextView) findViewById(R.id.userAddPickupRequestPrice);
        submit = (Button) findViewById(R.id.userAddPickupRequestSubmit);
        deliveryDateText = (EditText) findViewById(R.id.userAddPickupRequestDeliveryDate);
        toLocationText = (EditText) findViewById(R.id.userAddPickupRequestToLocation);
        fromLocationText = (EditText) findViewById(R.id.userAddPickupRequestFromLocation);
        phoneText = (EditText) findViewById(R.id.phone);

        lengthText.setOnFocusChangeListener(this);
        widthText.setOnFocusChangeListener(this);
        heightText.setOnFocusChangeListener(this);

        price = new BigDecimal("45");
        volume = new BigDecimal("235.0");
        /*
        Packages pack = new Packages("1",volume.toString(),"",price.toString());
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("tables/packages");
        myRef.setValue(pack);*/

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeliveryDetails deliveryDetails = new DeliveryDetails("1",fromLocationText.getText().toString(),toLocationText.getText().toString(),"","murtazasmart","pending",deliveryDateText.getText().toString(),"nodeliveryagent assigned",price.toString());
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("tables/deliverydetails");
                myRef.push().setValue(deliveryDetails);
            }
        });





    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if(v == lengthText || v == widthText || v == heightText){
            length = new BigDecimal(lengthText.getText().toString());
            width = new BigDecimal(widthText.getText().toString());
            height = new BigDecimal(heightText.getText().toString());
            volume = new BigDecimal(length.multiply(width.multiply(height)).toString());
            priceDisplay.setText(volume.toString());

        }
    }
}
