package com.example.teleg.myhome.Survey;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.teleg.myhome.MainViewFragment.MoreSurveyActivity;
import com.example.teleg.myhome.R;
import com.google.android.youtube.player.internal.v;

import java.util.ArrayList;

public class SurveyAdapter extends RecyclerView.Adapter<SurveyAdapter.SurveyViewHolder> {

    ArrayList<Survey> surveys;
    Context context;

    public SurveyAdapter(ArrayList<Survey> surveys){
        this.surveys = surveys;
    }

    public class SurveyViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView title;
        TextView text;
        TextView dateStart;
        TextView dateStop;
        TextView views;
        TextView voted;

        Button button;

        public SurveyViewHolder (View view)
        {
            super(view);

            img = (ImageView) view.findViewById(R.id.images);
            title = (TextView) view.findViewById(R.id.mainHeader);
            text = (TextView) view.findViewById(R.id.mainTextSu);
            dateStart = (TextView) view.findViewById(R.id.dateStartView);
            dateStop = (TextView) view.findViewById(R.id.dateStopView);
            views = (TextView) view.findViewById(R.id.viewsView);
            voted = (TextView) view.findViewById(R.id.votedView);

            button = (Button) view.findViewById(R.id.MoreInformationAboutComplaint);

        }

    }




    @NonNull
    @Override
    public SurveyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_surveys, viewGroup, false);
        context = viewGroup.getContext();
        return new SurveyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SurveyViewHolder holder, int position) {
        holder.title.setText(surveys.get(position).getTitle());
        holder.text.setText(surveys.get(position).getText());
        holder.dateStart.setText(surveys.get(position).getDateStart());
        holder.dateStop.setText(surveys.get(position).getDateStop());
        holder.views.setText(surveys.get(position).getViews());
        holder.voted.setText(surveys.get(position).getVoted());
        holder.button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String Ttitle = holder.title.getText().toString();
                String Ttext = holder.text.getText().toString();
                String TdateStart = holder.dateStart.getText().toString();
                String TdateStop = holder.dateStop.getText().toString();
                String Tview = holder.views.getText().toString();
                String Tvoted = holder.voted.getText().toString();

                Intent intent = new Intent(v.getContext(), MoreSurveyActivity.class);
                intent.putExtra("SurveyDocumentInfo", new SurveyDocumentInfo(
                        Ttitle, Ttext, TdateStart,
                        TdateStop, Tview, Tvoted));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return surveys.size();
    }

}
