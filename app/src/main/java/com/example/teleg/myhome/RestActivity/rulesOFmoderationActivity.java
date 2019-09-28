package com.example.teleg.myhome.RestActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.teleg.myhome.R;

public class rulesOFmoderationActivity extends AppCompatActivity {

    ListView listView1;
    ListView listView2;
    ListView listView3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_ofmoderation);

        String[] Items1 = getResources().getStringArray(R.array.generalities);
        String[] Items2 = getResources().getStringArray(R.array.TheReasonForTheRejection);
        String[] Items3 = getResources().getStringArray(R.array.TheReasonToLimitTheActions);

        listView1 = findViewById(R.id.List1);
        listView2 = findViewById(R.id.List2);
        listView3 = findViewById(R.id.List3);

        final ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, Items1);
        final ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, Items2);
        final ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, Items3);

        listView1.setAdapter(adapter1);
        listView2.setAdapter(adapter2);
        listView3.setAdapter(adapter3);

    }
}
