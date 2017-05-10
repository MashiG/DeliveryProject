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
import Model.User;

/**
 * Created by Bhagya Rathnayake on 5/10/2017.
 */

public class AgentListController extends RecyclerView.Adapter<AgentListController.userViewHolder> {

    FirebaseDatabase databaseInstance;
    DatabaseReference dbReference;
    private List<User> userDetailsList;

    public List<User> getUserList() {
        return userDetailsList;
    }

    public void setUserList(List<User> userDetailsList) {
        this.userDetailsList = userDetailsList;
    }

    public class userViewHolder extends RecyclerView.ViewHolder
    {
        public TextView title, genre;
        public ImageButton year;

        public userViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (ImageButton) view.findViewById(R.id.year);
        }
    }

    public AgentListController(List<User> details)
    {
        this.userDetailsList=details;
    }

    public AgentListController()
    {
        databaseInstance=FirebaseDatabase.getInstance();
    }

    @Override
    public AgentListController.userViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.managerrequestrow, parent, false);

        return new AgentListController.userViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AgentListController.userViewHolder holder, int position) {

        User deliveryDetails = userDetailsList.get(position);
        holder.title.setText(deliveryDetails.getName());
        holder.genre.setText(deliveryDetails.getEmail());

    }

    @Override
    public int getItemCount()
    {
        return userDetailsList.size();
    }

    public DatabaseReference getAgentList()
    {
        dbReference=databaseInstance.getReference("tables");
        dbReference=dbReference.child("users");
        return dbReference;
    }

    public void getAcceptedRequests()
    {

    }

    public void getAllRequests()
    {

    }

}
