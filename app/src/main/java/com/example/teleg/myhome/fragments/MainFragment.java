package com.example.teleg.myhome.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.cardiomood.android.controls.gauge.SpeedometerGauge;
import com.example.teleg.myhome.MainActivity;
import com.example.teleg.myhome.MainViewFragment.NewComplaintActivity;
import com.example.teleg.myhome.MainViewFragment.NewProposalActivity;
import com.example.teleg.myhome.R;
import com.example.teleg.myhome.RegistrationActivity;
import com.example.teleg.myhome.mainPhotoProject.PhotoProject;
import com.example.teleg.myhome.mainPhotoProject.PhotoProjectAdapter;
import com.github.anastr.speedviewlib.AwesomeSpeedometer;
import com.github.anastr.speedviewlib.SpeedView;

import java.util.ArrayList;

import static android.view.GestureDetector.*;

public class MainFragment extends Fragment implements View.OnClickListener, View.OnTouchListener
{

    public View view;

    ViewFlipper flipper;

    Button button;

    Button newComplaint;

    RecyclerView recycleView;

    Context context;

    private TextView final_text;
    SharedPreferences mSettings;


    Animation animFlipInForward;
    Animation animFlipOutForward;
    Animation animFlipInBackward;
    Animation animFlipOutBackward;



    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);

        context = getContext();

        flipper = (ViewFlipper) view.findViewById(R.id.viewflipper);

        animFlipInForward = AnimationUtils.loadAnimation(view.getContext(),
                R.anim.flipin);
        animFlipOutForward = AnimationUtils.loadAnimation(view.getContext(),
                R.anim.flipout);
        animFlipInBackward = AnimationUtils.loadAnimation(view.getContext(),
                R.anim.flipin_reverse);
        animFlipOutBackward = AnimationUtils.loadAnimation(view.getContext(),
                R.anim.flipout_reverse);

        button = (Button) view.findViewById(R.id.in_out);

        SpeedView speedView1 = (SpeedView) view.findViewById(R.id.speedView1);
        speedView1.speedTo(30, 4000);
        speedView1.speedPercentTo(20);

        SpeedView speedView2 = (SpeedView) view.findViewById(R.id.speedView2);
        speedView2.speedTo(30, 4000);
        speedView2.speedPercentTo(20);


        recycleView = (RecyclerView) view.findViewById(R.id.recyclerViewProject);
        recycleView.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false));


        newComplaint = (Button) view.findViewById(R.id.newComplaint);
        newComplaint.setOnClickListener(this);

        ArrayList<PhotoProject> photos = new ArrayList<>();

        photos.add(new PhotoProject(R.drawable.p1,
                R.drawable.p1_2));

        photos.add(new PhotoProject(R.drawable.p2,
                R.drawable.p2_2));

        photos.add(new PhotoProject(R.drawable.p3,
                R.drawable.p3_2));

        photos.add(new PhotoProject(R.drawable.p4,
                R.drawable.p4_2));

        PhotoProjectAdapter photoAdapter = new PhotoProjectAdapter(photos);
        recycleView.setAdapter(photoAdapter);


        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.newComplaint:
                LayoutInflater li = LayoutInflater.from(context);
                View promptsView = li.inflate(R.layout.new_complaint_dialog, null);

                AlertDialog.Builder mDialogBuilder = new AlertDialog.Builder(context);
                mDialogBuilder.setView(promptsView);
                mDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("Жалоба/Вопрос",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Intent intent1 = new Intent(view.getContext(), NewComplaintActivity.class);
                                        startActivity(intent1);
                                    }
                                })
                        .setNegativeButton("Предложение",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Intent intent2 = new Intent(view.getContext(), NewProposalActivity.class);
                                        startActivity(intent2);
                                    }
                                })
                        .setNeutralButton("Отмена",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alertDialog = mDialogBuilder.create();
                alertDialog.show();

        }


    }
    private void SwipeLeft(){
        flipper.setInAnimation(animFlipInBackward);
        flipper.setOutAnimation(animFlipOutBackward);
        flipper.showPrevious();
    }

    private void SwipeRight() {
        flipper.setInAnimation(animFlipInForward);
        flipper.setOutAnimation(animFlipOutForward);
        flipper.showNext();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    SimpleOnGestureListener simpleOnGestureListener = new SimpleOnGestureListener() {

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                               float velocityY) {

            float sensitvity = 50;
            if ((e1.getX() - e2.getX()) > sensitvity) {
                SwipeLeft();
            } else if ((e2.getX() - e1.getX()) > sensitvity) {
                SwipeRight();
            }
            return true;
        }
    };

    GestureDetector gestureDetector = new GestureDetector(context,
            simpleOnGestureListener);


}



