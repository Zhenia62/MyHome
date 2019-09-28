package com.example.teleg.myhome.MainViewFragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.teleg.myhome.Complaint.ComplainDocumentInfo;
import com.example.teleg.myhome.Complaint.Complaint;
import com.example.teleg.myhome.R;

public class MoreComplainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_complain);


        imageView = findViewById(R.id.backAct);
        imageView.setOnClickListener(this);


        TextView tvTitle = (TextView) findViewById(R.id.more_complain_title);
        TextView tvCategory = (TextView) findViewById(R.id.more_complain_category);
        TextView tvType = (TextView) findViewById(R.id.more_complain_type);
        TextView tvStatus = (TextView) findViewById(R.id.more_complain_status);
        TextView tvAddress = (TextView) findViewById(R.id.more_complain_address);
        TextView tvTheme = (TextView) findViewById(R.id.more_complain_theme);
        TextView tvText = (TextView) findViewById(R.id.more_complain_mainText);

        ImageView ivImg = (ImageView) findViewById(R.id.im1);


        ComplainDocumentInfo documentInfo = (ComplainDocumentInfo)getIntent().getParcelableExtra("ComplainDocumentInfo");


        tvTitle.setText(documentInfo.getTitle());
        tvCategory.setText(documentInfo.getCategory());
        tvType.setText(documentInfo.getType());
        tvStatus.setText(documentInfo.getStatus());
        tvAddress.setText(documentInfo.getAddress());
        tvTheme.setText(documentInfo.getTheme());
        tvText.setText(documentInfo.getText());

        //ivImg.setImageResource(Integer.parseInt(documentInfo.getImg()));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backAct:
                this.finish();
                break;
        }
    }
}
