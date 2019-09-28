package com.example.teleg.myhome.RestActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.teleg.myhome.R;
import com.example.teleg.myhome.Tape.Tape;
import com.example.teleg.myhome.Tape.TapeAdapter;

import java.util.ArrayList;

public class MyHomeActivity extends AppCompatActivity implements View.OnClickListener {

    TextView title,message;
    public static RecyclerView recyclerView;
    Button add;
    ImageView imageView;

    public  ArrayList<Tape> tapes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_friend);

        title = findViewById(R.id.TapeTile);
        message = findViewById(R.id.TapeText);

        recyclerView = (RecyclerView) findViewById(R.id.TapeList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        add = (Button) findViewById(R.id.addList);
        add.setOnClickListener(this);

        imageView = (ImageView) findViewById(R.id.backActMyH);
        imageView.setOnClickListener(this);

        tapes.add(new Tape(Integer.toString(tapes.size()+1),
                "Обычная новость",
                "У меня сегодня хорошее настроение"));

        TapeAdapter tapeAdapter = new TapeAdapter(tapes);
        recyclerView.setAdapter(tapeAdapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.addList:
                if( !title.getText().toString().isEmpty() &&  !message.getText().toString().isEmpty() ) {
                    tapes.add(new Tape(Integer.toString(tapes.size() + 1),
                            title.getText().toString(),
                            message.getText().toString()));
                    TapeAdapter tapeAdapter = new TapeAdapter(tapes);
                    recyclerView.setAdapter(tapeAdapter);
                }else {
                    Toast toast = Toast.makeText(this,
                            "Заполните все необходимые поля, чтобы опубликовать новую запись", Toast.LENGTH_SHORT);
                    toast.show();
                }
                break;
            case R.id.backActMyH:
                this.finish();
        }
    }
}
