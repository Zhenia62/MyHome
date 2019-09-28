package com.example.teleg.myhome.StartSlidings;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.teleg.myhome.MainActivity;
import com.example.teleg.myhome.R;
import com.example.teleg.myhome.RegistrationActivity;


public class Page_Slide_3 extends Fragment implements View.OnClickListener {

    Button buttonIN, buttonREG, button, buttonSKIP;
    Context context;

    public Intent intentREG;

    public static final String APP_SECOND_PREFERENCES = "mySettingsLogin";
    public static final String APP_PREFERENCES_LOGIN = "login";
    public static  int mLogin;

    static public SharedPreferences mSettings;
    private SharedPreferences.Editor editor;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page_slide_3, container, false);

        buttonIN = (Button) view.findViewById(R.id.account_a);
        buttonIN.setOnClickListener(this);
        buttonREG = (Button) view.findViewById(R.id.account_b);
        buttonREG.setOnClickListener(this);

        context = view.getContext();


        buttonSKIP =(Button) view.findViewById(R.id.skip);
        buttonSKIP.setOnClickListener(this);

        intentREG = new Intent(getContext(), RegistrationActivity.class);

        mSettings = view.getContext().getSharedPreferences(APP_SECOND_PREFERENCES, Context.MODE_PRIVATE);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.account_a:
                mLogin = mSettings.getInt(APP_PREFERENCES_LOGIN, 0);
                if(mLogin == 0) {
                    mLogin = 1;
                    editor = mSettings.edit();
                    editor.putInt(APP_PREFERENCES_LOGIN, mLogin);
                    editor.apply();

                    LayoutInflater li = LayoutInflater.from(context);
                    final View promptsView = li.inflate(R.layout.dialog, null);

                    AlertDialog.Builder mDialogBuilder = new AlertDialog.Builder(context);
                    mDialogBuilder.setView(promptsView);

                    final EditText userMail = (EditText) promptsView.findViewById(R.id.input_mail);
                    final EditText userPassword = (EditText) promptsView.findViewById(R.id.input_password);
                    mDialogBuilder
                            .setCancelable(false)
                            .setNeutralButton("Регистрация",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            String url = "http://нашдом62.рф/my/";
                                            Intent i = new Intent(Intent.ACTION_VIEW);
                                            i.setData(Uri.parse(url));
                                            startActivity(i);
                                        }
                                    })
                            .setPositiveButton("Вход",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            String mail = userMail.getText().toString();
                                            String password = userPassword.getText().toString();
                                            if (mail.equals("1") && password.equals("2")) {
                                                Toast toast = Toast.makeText(getContext(),
                                                        "Успешно", Toast.LENGTH_SHORT);
                                                toast.show();
                                                Intent intent = new Intent(getContext(), MainActivity.class);
                                                startActivity(intent);
                                            } else {
                                                Toast toast = Toast.makeText(getContext(),
                                                        "Неверный логин или пароль", Toast.LENGTH_SHORT);
                                                toast.show();
                                            }

                                        }
                                    })
                            .setNegativeButton("Отмена",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });

                    AlertDialog alertDialog = mDialogBuilder.create();
                    alertDialog.show();
                }else {
                    Toast toast = Toast.makeText(getContext(),
                            "Вы уже вошли в систему", Toast.LENGTH_SHORT);
                    toast.show();
                }
                break;
            case  R.id.account_b:
                String url = "http://нашдом62.рф/my/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                break;
            case R.id.skip:
                Intent intentM = new Intent(getContext(), MainActivity.class);
                startActivity(intentM);

        }
    }
}
