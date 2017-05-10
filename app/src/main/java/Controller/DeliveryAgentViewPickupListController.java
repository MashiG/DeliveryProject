package Controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hp.deliveryproject.R;

import java.util.List;

import Model.DeliveryDetails;
import Model.User;

/**
 * Created by Bhagya Rathnayake on 5/10/2017.
 */

public class DeliveryAgentViewPickupListController extends RecyclerView.Adapter<DeliveryAgentViewPickupListController.MyViewHolder> {

    private List<DeliveryDetails> deliveryAgentViewPickupList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView date, fromLocation, toLocation;

        public MyViewHolder(View view){
            super(view);
            date = (TextView) view.findViewById((R.id.deliveryAgentViewPickupRowDate));
            fromLocation = (TextView) view.findViewById((R.id.deliveryAgentViewPickupRowFromLocation));
            toLocation = (TextView) view.findViewById((R.id.deliveryAgentViewPickupRowToLocation));
        }
    }

    public DeliveryAgentViewPickupListController(List<DeliveryDetails> deliveryAgentViewPickupList){
        this.deliveryAgentViewPickupList = deliveryAgentViewPickupList;
    }

    @Override
    public DeliveryAgentViewPickupListController.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.deliveryagentviewpickup_row, parent, false);
        return new DeliveryAgentViewPickupListController.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        DeliveryDetails deliveryAgent = deliveryAgentViewPickupList.get(position);
        holder.date.setText(deliveryAgent.getDeliveryDate());
        holder.fromLocation.setText(deliveryAgent.getFromLocation());
        holder.toLocation.setText(deliveryAgent.getToLocation());
    }

    @Override
    public int getItemCount() {
        return deliveryAgentViewPickupList.size();
    }

}