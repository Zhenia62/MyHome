package com.example.teleg.myhome;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.teleg.myhome.fragments.MainFragment;
import com.example.teleg.myhome.fragments.regFragments.fragment1;
import com.example.teleg.myhome.fragments.regFragments.fragment2;
import com.example.teleg.myhome.fragments.regFragments.fragment3;
import com.example.teleg.myhome.fragments.regFragments.fragment4;
import com.example.teleg.myhome.fragments.regFragments.fragment5;
import com.example.teleg.myhome.fragments.regFragments.fragment6;

import static java.security.AccessController.getContext;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {

    public int Position;

    private static final String TAG = getContext().getClass().getSimpleName();
    Button back;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Position = 0;

        loadFragment(fragment1.newInstance());

        back = ( Button ) findViewById(R.id.back);
        next = ( Button ) findViewById(R.id.next);

        back.setOnClickListener(this);
        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                Position--;
                switch (Position) {
                    case -1:
                        Intent intent = new Intent(this, MainActivity.class);
                        startActivity(intent);
                        break;
                    case 0:
                        loadFragment(fragment1.newInstance());
                        break;
                    case 1:
                        loadFragment(fragment2.newInstance());
                        break;
                    case 2:
                        loadFragment(fragment3.newInstance());
                        break;
                    case 3:
                        loadFragment(fragment4.newInstance());
                        break;
                    case 4:
                        loadFragment(fragment5.newInstance());
                        break;
                    case 5:
                        loadFragment(fragment6.newInstance());
                        break;
                }
                break;
            case R.id.next:
                Position++;
                switch (Position) {
                    case 1:
                        loadFragment(fragment2.newInstance());
                        break;
                    case 2:
                        loadFragment(fragment3.newInstance());
                        break;
                    case 3:
                        loadFragment(fragment4.newInstance());
                        break;
                    case 4:
                        loadFragment(fragment5.newInstance());
                        break;
                    case 5:
                        loadFragment(fragment6.newInstance());
                        break;
                    case 6:
                        Intent intent = new Intent(this, MainActivity.class);
                        startActivity(intent);
                        break;
                }
                break;
        }
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.firstFrame, fragment);
        ft.commit();
    }
}
