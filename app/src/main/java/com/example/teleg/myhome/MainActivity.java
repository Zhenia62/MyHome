package com.example.teleg.myhome;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.teleg.myhome.RestActivity.MainProfile;
import com.example.teleg.myhome.RestActivity.MyHomeActivity;
import com.example.teleg.myhome.RestActivity.MyMessageActivity;
import com.example.teleg.myhome.RestActivity.PreferActivity;
import com.example.teleg.myhome.RestActivity.SettingActivity;
import com.example.teleg.myhome.RestActivity.rulesOFmoderationActivity;
import com.example.teleg.myhome.fragments.ComplaintFragment;
import com.example.teleg.myhome.fragments.MainFragment;
import com.example.teleg.myhome.fragments.NewsFragment;
import com.example.teleg.myhome.fragments.SurveyFragment;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;
import com.yarolegovich.slidingrootnav.SlidingRootNavLayout;

import static com.example.teleg.myhome.StartSlidings.Page_Slide_3.APP_PREFERENCES_LOGIN;
import static com.example.teleg.myhome.StartSlidings.Page_Slide_3.APP_SECOND_PREFERENCES;
import static com.example.teleg.myhome.StartSlidings.Page_Slide_3.mLogin;
import static com.example.teleg.myhome.StartSlidings.Page_Slide_3.mSettings;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SlidingRootNav {
    private static final String TAG = "MainActivity";

    public TextView mTextMessage;
    Button button, buttonMenu;

    Toolbar toolbar;

    ListView listView;
    LinearLayout linearLayout;

    public static int position = 0;

    //FlowingDrawer flowingDrawer;
    Context context;

    static public SlidingRootNav slidingRootNav;
    SlidingRootNavBuilder slidingRootNavBuilder;

    private SharedPreferences.Editor editor;
    SlidingRootNavLayout adaptee;

    public Intent intentREG;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    getSupportActionBar().setTitle("Главная");
                    loadFragment(MainFragment.newInstance());
                    return true;
                case R.id.navigation_complaints:
                    getSupportActionBar().setTitle("Обращения");
                    loadFragment(ComplaintFragment.newInstance());
                    return true;
                case R.id.navigation_events:
                    getSupportActionBar().setTitle("Новости");
                    loadFragment(NewsFragment.newInstance());
                    return true;
                case R.id.navigation_surveys:
                    getSupportActionBar().setTitle("Опросы");
                    loadFragment(SurveyFragment.newInstance());
                    return true;
                //case R.id.navigation_rest:
                    //getSupportActionBar().setTitle("Остальное");
                    //loadFragment(RestFragment.newInstance());
                    //return true;

            }
            return false;
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        slidingRootNav = new SlidingRootNavBuilder(this)
                .withMenuOpened(false)
                .withToolbarMenuToggle(toolbar)
                .withContentClickableWhenMenuOpened(false)
                .withSavedState(savedInstanceState)
                .withMenuLayout(R.layout.right_menu)
                .inject();


        buttonMenu = (Button) findViewById(R.id.dopMenu);
        buttonMenu.setOnClickListener(this);

        toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        String[] Items = getResources().getStringArray(R.array.items);

        listView = findViewById(R.id.listView);

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, Items);

        listView.setAdapter(adapter);

        linearLayout = (LinearLayout) findViewById(R.id.profile);
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


        context = this;

        if(position == 1)
        {
            position = 0;
            loadFragment(ComplaintFragment.newInstance());
        }else {
            loadFragment(MainFragment.newInstance());
        }

        button = (Button) findViewById(R.id.in_out);
        button.setOnClickListener(this);


        mSettings = getSharedPreferences(APP_SECOND_PREFERENCES, Context.MODE_PRIVATE);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if(mLogin == 1) {
        button.setText(R.string.out);
        }

    }

    public void loadFragment(Fragment fragment) {


        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        ft.replace(R.id.fl_content, fragment);
        ft.commit();

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.in_out:
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
                                                Toast toast = Toast.makeText(MainActivity.this,
                                                        "Успешно", Toast.LENGTH_SHORT);
                                                button.setText(R.string.out);
                                                toast.show();
                                                dialog.cancel();
                                            } else {
                                                Toast toast = Toast.makeText(MainActivity.this,
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
                }
                else
                {
                    mLogin = 0;
                    button.setText(R.string.in);
                }
                break;
            case  R.id.profile:
                Intent intent1 = new Intent(this, MainProfile.class);
                startActivity(intent1);
                break;
            case R.id.dopMenu:
                slidingRootNav.openMenu();
                break;
        }
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);

        if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Log.i(TAG,"onConfigurationChanged: orientation = portrait");
        }else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            Log.i(TAG,"onConfigurationChanged: orientation = landscape");
        }
    }

    @Override
    public boolean isMenuClosed() {
        return false;
    }

    @Override
    public boolean isMenuOpened() {
        return false;
    }

    @Override
    public boolean isMenuLocked() {
        return false;
    }

    @Override
    public void closeMenu() {
        closeMenu(true);
    }

    @Override
    public void closeMenu(boolean animated) {

    }

    @Override
    public void openMenu() {
        openMenu(true);
    }

    @Override
    public void openMenu(boolean animated) {

    }

    @Override
    public void setMenuLocked(boolean locked) {

    }

    @Override
    public SlidingRootNavLayout getLayout() {
        return null;
    }

}


