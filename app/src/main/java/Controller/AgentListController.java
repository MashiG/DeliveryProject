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
 * Created by Bhagya Rathnayake on 5/10/2017.
 */

public class AgentListController extends RecyclerView.Adapter<AgentListController.DeliveryViewHolder> {

    FirebaseDatabase databaseInstance;
    DatabaseReference dbReference;
    private List<DeliveryDetails> deliveryDetailsList;

    public List<DeliveryDetails> getDeliveryDetailsList() {
        return deliveryDetailsList;
    }

    public void setDeliveryDetailsList(List<DeliveryDetails> deliveryDetailsList) {
        this.deliveryDetailsList = deliveryDetailsList;
    }

    public class DeliveryViewHolder extends RecyclerView.ViewHolder
    {
        public TextView title, genre;
        public ImageButton year;

        public DeliveryViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (ImageButton) view.findViewById(R.id.year);
        }
    }

    public AgentListController(List<DeliveryDetails> details)
    {
        this.deliveryDetailsList=details;
    }

    public AgentListController()
    {
        databaseInstance=FirebaseDatabase.getInstance();
    }

    @Override
    public AgentListController.DeliveryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.managerrequestrow, parent, false);

        return new AgentListController.DeliveryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AgentListController.DeliveryViewHolder holder, int position) {

        DeliveryDetails deliveryDetails = deliveryDetailsList.get(position);
        holder.title.setText(deliveryDetails.getDeliveryID());
        holder.genre.setText(deliveryDetails.getFromLocation());

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
