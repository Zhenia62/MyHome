package com.example.teleg.myhome.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.teleg.myhome.RestActivity.MainProfile;
import com.example.teleg.myhome.R;
import com.example.teleg.myhome.RestActivity.MyHomeActivity;
import com.example.teleg.myhome.RestActivity.MyMessageActivity;
import com.example.teleg.myhome.RestActivity.PreferActivity;
import com.example.teleg.myhome.RestActivity.SettingActivity;
import com.example.teleg.myhome.RestActivity.rulesOFmoderationActivity;


public class RestFragment extends Fragment implements View.OnClickListener{


    ListView listView;

    LinearLayout linearLayout;

    private OnNoItemClickListener mOnNoItemClickListener;
    public interface OnNoItemClickListener { void onNoItemClicked(); }

    public RestFragment() {
    }

    public static RestFragment newInstance() {
        return new RestFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rest, container, false);


        String[] Items = getResources().getStringArray(R.array.items);

        listView = view.findViewById(R.id.listView);

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_list_item_1, Items);

        listView.setAdapter(adapter);

        linearLayout = (LinearLayout) view.findViewById(R.id.profile);
        linearLayout.setOnClickListener(this);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int value = position;

                switch (value) {
                    case 0:
                        Intent intent0 = new Intent(view.getContext(), MyMessageActivity.class);
                        startActivity(intent0);
                        break;
                    case 1:
                        Intent intent1 = new Intent(view.getContext(), SettingActivity.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(view.getContext(), PreferActivity.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(view.getContext(), MyHomeActivity.class);
                        startActivity(intent3);
                        break;
                    case 4:
                        //пользовательское соглашение
                        break;
                    case 5:
                        //Регламент
                        break;
                    case 6:
                        Intent intent7 = new Intent(view.getContext(), rulesOFmoderationActivity.class);
                        startActivity(intent7);
                        break;
                    case 7:
                        //обратная связь
                        break;
                }
            }
        });

        return view;
    }


    @Override
    public void onClick(View v){
        switch(v.getId())
        {
            case  R.id.profile:
                Intent intent1 = new Intent(getContext(), MainProfile.class);
                startActivity(intent1);
                break;

        }
    }

}
