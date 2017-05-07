package Controller;

import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp.deliveryproject.MainActivity;
import com.example.hp.deliveryproject.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import Model.DeliveryDetails;

/**
 * Created by Bhagya Rathnayake on 5/2/2017.
 */

public class OrdersListController extends RecyclerView.Adapter<OrdersListController.DeliveryViewHolder>{

    FirebaseDatabase databaseInstance;
    DatabaseReference dbReference;
    private List<DeliveryDetails> deliveryDetailsList;

    public class DeliveryViewHolder extends RecyclerView.ViewHolder
    {
        public TextView title, year, genre;

        public DeliveryViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
        }
    }



    public OrdersListController(List<DeliveryDetails> details)
    {
        this.deliveryDetailsList=details;
    }

    public OrdersListController()
    {
        databaseInstance=FirebaseDatabase.getInstance();
    }

    @Override
    public DeliveryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.request_row, parent, false);

        return new DeliveryViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(DeliveryViewHolder holder, int position) {

        DeliveryDetails deliveryDetails = deliveryDetailsList.get(position);
        holder.title.setText(deliveryDetails.getDeliveryID());
        holder.genre.setText(deliveryDetails.getFromLocation());
        holder.year.setText(deliveryDetails.getToLocation());

    }

    @Override
    public int getItemCount()
    {
        return deliveryDetailsList.size();
    }

    public DatabaseReference getPendingRequests()
    {
        dbReference=databaseInstance.getReference("tables");
        dbReference=dbReference.child("deliverydetails");
        return dbReference;
    }

    public void getAcceptedRequests()
    {

    }

    public void getAllRequests()
    {

    }

}
