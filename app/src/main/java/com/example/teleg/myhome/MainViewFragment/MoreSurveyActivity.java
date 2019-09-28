package com.example.teleg.myhome.MainViewFragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.teleg.myhome.R;
import com.example.teleg.myhome.Survey.Survey;
import com.example.teleg.myhome.Survey.SurveyDocumentInfo;

public class MoreSurveyActivity extends AppCompatActivity implements  View.OnClickListener{

    ImageView imageView;
    Button voteB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_survey);


        voteB = (Button) findViewById(R.id.vote);
        voteB.setOnClickListener(this);


        TextView tvTitle = (TextView) findViewById(R.id.mainHeader);
        TextView tvText = (TextView) findViewById(R.id.mainTextSu);
        TextView tvDateStart = (TextView) findViewById(R.id.dateStartView);
        TextView tvDateStop = (TextView) findViewById(R.id.dateStopView);
        TextView tvViews = (TextView) findViewById(R.id.viewsView);
        TextView tvVoted = (TextView) findViewById(R.id.votedView);



        SurveyDocumentInfo documentInfo = (SurveyDocumentInfo)getIntent().getParcelableExtra("SurveyDocumentInfo");


        tvTitle.setText(documentInfo.getTitle());
        tvText.setText(documentInfo.getText());
        tvDateStart.setText(documentInfo.getDateStart());
        tvDateStop.setText(documentInfo.getDateStop());
        tvViews.setText(documentInfo.getViews());
        tvVoted.setText(documentInfo.getVoted());



        imageView = findViewById(R.id.backAct);
        imageView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backAct:
                this.finish();
                break;
            case  R.id.vote:
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Ваш выбор зафиксирвоан", Toast.LENGTH_SHORT);
                toast.show();
                this.finish();
        }
    }


}
