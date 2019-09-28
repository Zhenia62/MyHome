package com.example.teleg.myhome.fragments;


import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.teleg.myhome.Complaint.Complaint;
import com.example.teleg.myhome.Complaint.ComplaintAdapter;
import com.example.teleg.myhome.Event.EventAdapter;
import com.example.teleg.myhome.MainViewFragment.MoreComplainActivity;
import com.example.teleg.myhome.MainViewFragment.NewComplaintActivity;
import com.example.teleg.myhome.MainViewFragment.NewProposalActivity;
import com.example.teleg.myhome.R;

import java.util.ArrayList;

public class ComplaintFragment extends Fragment implements View.OnClickListener{

    RecyclerView recycleView;
    Context context;

    Activity activity;
    FloatingActionButton fab;

    Button moreInfo;

    public ComplaintFragment() {
    }

    public static ComplaintFragment newInstance() { return new ComplaintFragment();}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_complaint_list, container, false);
        context = getContext();

        recycleView = (RecyclerView) view.findViewById(R.id.recyclerViewComplaint);
        recycleView.setLayoutManager(new LinearLayoutManager(view.getContext()));


        ArrayList<Complaint> complaints = new ArrayList<>();

        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(this);




        moreInfo = (Button) view.findViewById(R.id.moreInformationAboutComplaint);
        //moreInfo.setOnClickListener();




        complaints.add(new Complaint(R.drawable.caution_ico,
        "Самовольный захват муниципальной земли путём возведения забора.",
        "Строительство",
        "Жалоба",
        "Принято к исполнению",
        "Россия, Рязань, улица Пугачёва, 109",
        "Нарушения при строительстве",
        "Застройщиком ООО \"РТС\" заканчивается строительство многоквартирного дома \"ЖК СМАРТ дом на Славянском проспекте\", имеющий строительный адрес г.Рязань ул.Пугачева №109. Вместо временного строительного забора вокруг дома начато возведение металлического 2х метрового забора. Судя по данным публичной кадастровой карты, границы ограждения значительно выступают за пределы кадастрового участка (62:29:0090030:643), отведенного под строительство. По предварительной оценке, самовольно занято будет примерно пол гектара муниципальной земли. Ограждение будет мешать всем жителям близлежащих домов. Прошу проверить границы и законность установки забора вокруг участка с кадастровым номером 62:29:0090030:643 . В случае выявления нарушений, привлечь застройщика ООО \"РТС\" к ответственности согласно статьи 7.1 КоАП РФ. \"КоАП РФ Статья 7.1."));

        complaints.add(new Complaint(R.drawable.caution_ico,
                "Самовольный захват муниципальной земли путём возведения забора.",
                "Строительство",
                "Жалоба",
                "Принято к исполнению",
                "Есенина 2а",
                "фигня",
                "Застройщиком ООО \"РТС\" заканчивается строительство многоквартирного дома \"ЖК СМАРТ дом на Славянском проспекте\", имеющий строительный адрес г.Рязань ул.Пугачева №109. Вместо временного строительного забора вокруг дома начато возведение металлического 2х метрового забора. Судя по данным публичной кадастровой карты, границы ограждения значительно выступают за пределы кадастрового участка (62:29:0090030:643), отведенного под строительство. По предварительной оценке, самовольно занято будет примерно пол гектара муниципальной земли. Ограждение будет мешать всем жителям близлежащих домов. Прошу проверить границы и законность установки забора вокруг участка с кадастровым номером 62:29:0090030:643 . В случае выявления нарушений, привлечь застройщика ООО \"РТС\" к ответственности согласно статьи 7.1 КоАП РФ. \"КоАП РФ Статья 7.1."));


        ComplaintAdapter complaintAdapter = new ComplaintAdapter(complaints);
        recycleView.setAdapter(complaintAdapter);

        return view;
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if(context instanceof  Activity){
            activity = (Activity) context;
        }
    }


    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.fab:
                LayoutInflater li = LayoutInflater.from(context);
                View promptsView = li.inflate(R.layout.new_complaint_dialog, null);

                AlertDialog.Builder mDialogBuilder = new AlertDialog.Builder(context);
                mDialogBuilder.setView(promptsView);
                mDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("Жалоба/Вопрос",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Intent intent1 = new Intent(getContext(), NewComplaintActivity.class);
                                        startActivity(intent1);
                                    }
                                })
                        .setNegativeButton("Предложение",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Intent intent2 = new Intent(getContext(), NewProposalActivity.class);
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
                break;
        }
    }
}
