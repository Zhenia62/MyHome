package com.example.teleg.myhome.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.teleg.myhome.MainViewFragment.NewSurveyActivity;
import com.example.teleg.myhome.R;
import com.example.teleg.myhome.Survey.Survey;
import com.example.teleg.myhome.Survey.SurveyAdapter;

import java.util.ArrayList;


public class SurveyFragment extends Fragment implements View.OnClickListener {

    RecyclerView recyclerView;
    View promptsView;


    FloatingActionButton fab;
    Spinner spinner;
    LinearLayout linearLayout;

    Context context;

    public SurveyFragment() {
    }

    public static SurveyFragment newInstance() {
        return new SurveyFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_surveys_list, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewSurveys);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        ArrayList<Survey> surveys = new ArrayList<>();

        context = getContext();
        linearLayout = (LinearLayout) view.findViewById(R.id.dopInfo);

        fab = (FloatingActionButton) view.findViewById(R.id.fab3);
        fab.setOnClickListener(this);


        String[] SuraveySortArray = { "Все", "Активные", "Завершенные", "Пройденные",
                "Не пройденные"};
        final Spinner spinner = (Spinner) view.findViewById(R.id.spinSort);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, SuraveySortArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        LayoutInflater li = LayoutInflater.from(context);
        promptsView = li.inflate(R.layout.information, null);

        surveys.add(new Survey(R.drawable.question,
                "Новые деревья на улицах города",
                "На улицах города сажают много новых деревьев. Например, на Московском шоссе (от р.Павловка до ТЦ Барс)" +
                        " посадили 3-4 года назад. Половина из них уже засохла. Кто отвечает за их состояние?" +
                        " Почему никто не требуют их замены? Почему за деревьями никто не ухаживает, никто их не поливает?",
                "22.12.2010",
                "02.14.2011",
                "2100",
                "2000"));

        surveys.add(new Survey(R.drawable.question,
                "Общественный транспорт",
                "Жители ул. Михайловское шоссе, все сталкиваются с проблемой вечером добраться до дома." +
                        " После 18.00 автобусы ходят мало, хорошо если раз в час 13 автобус проедет. а о 57 автобусе и говорить нечего." +
                        " Я предлагаю продолжить маршрут 82 маршрутки до М5МООЛ. Либо другой маршрут, 62 например.",
                "12.02.2010",
                "12.13.2010",
                "800",
                "650"));


        SurveyAdapter surveyAdapter = new SurveyAdapter(surveys);
        recyclerView.setAdapter(surveyAdapter);
        return view;
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab3:
                Intent intent = new Intent(getContext(), NewSurveyActivity.class);
                startActivity(intent);
                break;
        }
    }
}