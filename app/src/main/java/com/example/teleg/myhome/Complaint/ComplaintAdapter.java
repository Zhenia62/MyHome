package com.example.teleg.myhome.Complaint;

import android.content.Context;
import android.content.Intent;
import android.provider.DocumentsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.teleg.myhome.MainViewFragment.MoreComplainActivity;
import com.example.teleg.myhome.R;
import com.example.teleg.myhome.fragments.ComplaintFragment;

import java.util.ArrayList;


public class ComplaintAdapter extends RecyclerView.Adapter<ComplaintAdapter.ComplaintViewHolder> {

    ArrayList<Complaint> complaints;
    Context context;

    public ComplaintAdapter(ArrayList<Complaint> complaints) { this.complaints = complaints; }

    public class ComplaintViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView title;
        TextView category;
        TextView type;
        TextView status;
        TextView address;
        TextView theme;
        TextView text;
        Button button;


        public ComplaintViewHolder(View view){
            super(view);
            this.img = ( ImageView ) view.findViewById(R.id.complain_img);
            this.title = ( TextView )view.findViewById(R.id.complain_title);
            this.category = ( TextView )view.findViewById(R.id.complain_category);
            this.type = ( TextView )view.findViewById(R.id.complain_type);
            this.status = ( TextView )view.findViewById(R.id.complain_status);
            this.address = ( TextView )view.findViewById(R.id.complain_address);
            this.theme = ( TextView )view.findViewById(R.id.complain_theme);
            this.text = ( TextView )view.findViewById(R.id.complain_mainText);
            this.button = (Button)view.findViewById(R.id.moreInformationAboutComplaint);

        }
    }

    @NonNull
    @Override
    public ComplaintViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_complaint,viewGroup,false);
        context = viewGroup.getContext();
        return new ComplaintViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ComplaintViewHolder holder, int i) {

        holder.text.setText(complaints.get(i).getText());
        holder.theme.setText(complaints.get(i).getTheme());
        holder.address.setText(complaints.get(i).getAddress());
        holder.status.setText(complaints.get(i).getStatus());
        holder.type.setText(complaints.get(i).getType());
        holder.category.setText(complaints.get(i).getCategory());
        holder.title.setText(complaints.get(i).getTitle());
        holder.img.setImageResource(complaints.get(i).getImg());
        holder.button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String Ttext = holder.text.getText().toString();
                String Ttheme = holder.theme.getText().toString();
                String Taddress = holder.address.getText().toString();
                String Tstatus= holder.status.getText().toString();
                String Ttype = holder.type.getText().toString();
                String Tcategory = holder.category.getText().toString();
                String Ttitle = holder.title.getText().toString();
                String Timg = Integer.toString(holder.img.getId());

                Intent intent = new Intent(v.getContext(), MoreComplainActivity.class);
                intent.putExtra("ComplainDocumentInfo", new ComplainDocumentInfo(
                        Ttext,Ttheme,Taddress,
                        Tstatus,Ttype,Tcategory,
                        Ttitle,Timg));
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return complaints.size();
    }
}
