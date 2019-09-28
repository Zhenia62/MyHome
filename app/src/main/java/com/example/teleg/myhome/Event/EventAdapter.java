package com.example.teleg.myhome.Event;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.teleg.myhome.R;

import java.util.ArrayList;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    ArrayList<Event> events;

    public EventAdapter (ArrayList<Event> events)
    {
        this.events = events;
    }

    public  class EventViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView user;
        TextView title;
        TextView address;
        TextView type;
        TextView text;
        TextView date;
        public  EventViewHolder (View view)
        {
            super(view);
            img = ( ImageView ) view.findViewById(R.id.images);
            user = ( TextView ) view.findViewById(R.id.name);
            address = ( TextView ) view.findViewById(R.id.address);
            type = ( TextView ) view.findViewById(R.id.type);
            text = ( TextView ) view.findViewById(R.id.mainText);
            date = ( TextView ) view.findViewById(R.id.date);

        }
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_news, viewGroup, false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        holder.date.setText(events.get(position).getDate());
        holder.text.setText(events.get(position).getText());
        holder.type.setText(events.get(position).getType());
        holder.address.setText(events.get(position).getAddress());
        holder.user.setText(events.get(position).getUser());
        holder.img.setImageResource(events.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return events.size();
    }
}
