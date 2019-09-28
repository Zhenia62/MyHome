package com.example.teleg.myhome.Tape;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.teleg.myhome.R;

import java.util.ArrayList;

import static com.example.teleg.myhome.RestActivity.MyHomeActivity.recyclerView;

public class TapeAdapter extends RecyclerView.Adapter<TapeAdapter.TapeViewHolder> {


    ArrayList<Tape> tapes;

    public TapeAdapter(ArrayList<Tape> tapes){
        this.tapes = tapes;
    }

    public class TapeViewHolder extends RecyclerView.ViewHolder{

        TextView count;
        TextView title;
        TextView text;
        //Button button;

        public TapeViewHolder (View view)
        {
            super(view);
            count = (TextView) view.findViewById(R.id.TapeCardCount);
            title = (TextView) view.findViewById(R.id.TapeCardTitle);
            text = (TextView) view.findViewById(R.id.TapeCardMessage);
            //button = (Button) view.findViewById(R.id.del);
        }

    }


    @NonNull
    @Override
    public TapeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tape_list_item, viewGroup, false);
        return new TapeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TapeViewHolder holder, int position) {
        holder.count.setText(tapes.get(position).getCount());
        holder.title.setText(tapes.get(position).getTitle());
        holder.text.setText(tapes.get(position).getText());
        //holder.button.setOnClickListener(new View.OnClickListener() {

          //  @Override
            //public void onClick(View v) {
              //  recyclerView.removeItemDecorationAt(0);
            //}
        //});
    }

    @Override
    public int getItemCount() {
        return tapes.size();
    }

}