package com.example.teleg.myhome;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class EditProfileActivity extends AppCompatActivity implements View.OnClickListener {

    String[] years = new String[32];
    String[] days = new String[32];
    String[] months;
    String[] sex;

    Context context;
    Button button;

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        for(int i = 0; i <= 31; i++)
        {
           days[i] = Integer.toString(i);
        }

        int year = 1970;
        for(int i = 0; i <= 31; i++)
        {
            years[i] = Integer.toString(year);
            year++;
        }

        sex = new String[] {"Мужской","Женский"};
        months = new String[]{"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август","Сентябрь","Октябрь","Ноябрь","Декабрь"};

        Spinner spinner1 = (Spinner) findViewById(R.id.sexS);
        Spinner spinner2 = (Spinner) findViewById(R.id.dayS);
        Spinner spinner3 = (Spinner) findViewById(R.id.monthS);
        Spinner spinner4 = (Spinner) findViewById(R.id.yearS);

        context = this;

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sex);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, days);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, months);
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, years);


        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter2);
        spinner3.setAdapter(adapter3);
        spinner4.setAdapter(adapter4);


        button = findViewById(R.id.saveEditions);
        button.setOnClickListener(this);
        imageView = findViewById(R.id.backAct);
        imageView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.backAct:
                LayoutInflater li = LayoutInflater.from(context);
                AlertDialog.Builder mDialogBuilder = new AlertDialog.Builder(context);
                mDialogBuilder
                        .setTitle("Внимание!")
                        .setMessage("Вы точно хотите выйти? Все изменения не будут сохранены.")
                        .setCancelable(false)
                        .setPositiveButton("Продолжить",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                })
                        .setNegativeButton("Выход",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        EditProfileActivity.this.finish();
                                    }
                                });
                AlertDialog alertDialog = mDialogBuilder.create();
                alertDialog.show();
                break;
            case R.id.saveEditions:
                Toast toast = Toast.makeText(this,
                        "Успешное сохранение пользователя", Toast.LENGTH_SHORT);
                toast.show();
                break;
        }
    }
}
