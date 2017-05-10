package Controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hp.deliveryproject.R;

import java.util.List;

import Model.DeliveryDetails;

/**
 * Created by murtaza on 5/10/17.
 */

public class UserViewPickupController extends RecyclerView.Adapter<UserViewPickupController.MyViewHolder> {

    private List<DeliveryDetails> deliveryDetailsList;

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

    public UserViewPickupController(List<DeliveryDetails> deliveryDetailsList){
        this.deliveryDetailsList = deliveryDetailsList;
    }

    @Override
    public UserViewPickupController.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.userrequestrow, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserViewPickupController.MyViewHolder holder, int position) {
        DeliveryDetails deliveryDetails = deliveryDetailsList.get(position);
        holder.date.setText(deliveryDetails.getDeliveryDate());
        holder.fromLocation.setText(deliveryDetails.getFromLocation());
        holder.toLocation.setText(deliveryDetails.getToLocation());
        holder.status.setText(deliveryDetails.getStatus());

    }

    @Override
    public int getItemCount() {
        return deliveryDetailsList.size();
    }
}
