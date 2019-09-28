package com.example.teleg.myhome.RestActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.teleg.myhome.EditProfileActivity;
import com.example.teleg.myhome.R;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    ImageView imageView;

    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        imageView = findViewById(R.id.backAct);
        button = findViewById(R.id.saveSetting);

        imageView.setOnClickListener(this);
        button.setOnClickListener(this);

        context = this;

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
                                            SettingActivity.this.finish();
                                        }
                                    });
                    AlertDialog alertDialog = mDialogBuilder.create();
                    alertDialog.show();
                    break;
                case R.id.saveSetting:
                    Toast toast = Toast.makeText(this,
                            "Успешное сохранение настроек", Toast.LENGTH_SHORT);
                    toast.show();
                    break;
            }
        }
}
