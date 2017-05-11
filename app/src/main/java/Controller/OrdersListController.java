package Controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.hp.deliveryproject.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import Model.DeliveryDetails;

/**
 * Created by Bhagya Rathnayake on 5/2/2017.
 */

public class OrdersListController extends RecyclerView.Adapter<OrdersListController.MyViewHolder>{

    private List<DeliveryDetails> managerViewPickupList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView date, fromLocation, toLocation, status;

        public MyViewHolder(View view){
            super(view);
            date = (TextView) view.findViewById((R.id.userReqestRowDate));
            fromLocation = (TextView) view.findViewById((R.id.userRequestRowFromLocation));
            toLocation = (TextView) view.findViewById((R.id.userRequestRowToLocation));
            status = (TextView) view.findViewById(R.id.userRequestRowStatus);
        }
    }

    public OrdersListController(List<DeliveryDetails> managerViewPickupList){
        this.managerViewPickupList = managerViewPickupList;
    }

    @Override
    public OrdersListController.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.userrequestrow, parent, false);
        return new OrdersListController.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(OrdersListController.MyViewHolder holder, int position) {
        DeliveryDetails deliveryDetails = managerViewPickupList.get(position);
        holder.date.setText(deliveryDetails.getDeliveryDate());
        holder.fromLocation.setText(deliveryDetails.getFromLocation());
        holder.toLocation.setText(deliveryDetails.getToLocation());

    }

    @Override
    public int getItemCount() {
        return managerViewPickupList.size();
    }
}
