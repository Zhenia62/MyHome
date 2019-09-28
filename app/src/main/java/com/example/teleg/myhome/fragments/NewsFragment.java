package com.example.teleg.myhome.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.teleg.myhome.Event.Event;
import com.example.teleg.myhome.Event.EventAdapter;
import com.example.teleg.myhome.R;
import com.example.teleg.myhome.YouTube.VideoActivity;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.yandex.mapkit.geometry.Point;

import java.util.ArrayList;

public class NewsFragment extends Fragment implements View.OnClickListener{

    private final Point TARGET_LOCATION = new Point(59.945933, 30.320045);



    RecyclerView recycleView;

    MapView mapView;
    GoogleMap map;

    ImageView imageView;
    TextView textView;
    FloatingActionButton fab;


    public NewsFragment() {
    }

    public static NewsFragment newInstance() {
        return new NewsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_list, container, false);

        recycleView = (RecyclerView) view.findViewById(R.id.recyclerViewN);
        recycleView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        ArrayList<Event> events = new ArrayList<>();

        events.add(new Event(R.drawable.panda,
                "Телегин Евгений",
                "Россия, Рязань, улица Пугачёва, 109",
                "Самовольный захват муниципальной земли ",
                "Застройщиком ООО РТС заканчивается строительство многоквартирного дома ЖК СМАРТ дом на Славянском проспекте, имеющий строительный адрес г.Рязань ул.Пугачева №109." +
                        "Вместо временного строительного забора вокруг дома начато возведение металлического 2х метрового забора." +
                        " Судя по данным публичной кадастровой карты, границы ограждения значительно выступают за пределы кадастрового участка (62:29:0090030:643), отведенного под строительство. ",
                "28.04.1999"));

        events.add(new Event(R.drawable.panda,
                "Афанасий Фет",
                "Россия, Рязань, улица Пугачёва, 10000",
                "Нападение картошки",
                "Нападение картшечной армии",
                "28.04.1999"));

        events.add(new Event(R.drawable.panda,
                "Телегин Евгений",
                "Россия, Рязань, улица Пугачёва, 109",
                "Самовольный захват муниципальной земли ",
                "Застройщиком ООО РТС заканчивается строительство многоквартирного дома ЖК СМАРТ дом на Славянском проспекте, имеющий строительный адрес г.Рязань ул.Пугачева №109." +
                        "Вместо временного строительного забора вокруг дома начато возведение металлического 2х метрового забора." +
                        " Судя по данным публичной кадастровой карты, границы ограждения значительно выступают за пределы кадастрового участка (62:29:0090030:643), отведенного под строительство. ",
                "28.04.1999"));

        EventAdapter eventAdapter = new EventAdapter(events);
        recycleView.setAdapter(eventAdapter);

        textView = (TextView) view.findViewById(R.id.videoListText);
        imageView = (ImageView) view.findViewById(R.id.videoListImage);

        textView.setOnClickListener(this);
        imageView.setOnClickListener(this);

        return view;
    }

    /*@Override
    public void onStop() {
        mapView.onStop();
        MapKitFactory.getInstance().onStop();
        super.onStop();
    }

    @Override
    public void onStart() {
        super.onStart();
        MapKitFactory.getInstance().onStart();
        mapView.onStart();
    }*/




    @Override
    public void onClick(View v){
        switch(v.getId())
        {
            case  R.id.videoListImage:
                Intent intent1 = new Intent(v.getContext(), VideoActivity.class);
                startActivity(intent1);
                break;
            case  R.id.videoListText:
                Intent intent2 = new Intent(v.getContext(), VideoActivity.class);
                startActivity(intent2);
                break;
        }
    }

}