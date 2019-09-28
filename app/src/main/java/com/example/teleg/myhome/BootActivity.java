package com.example.teleg.myhome;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class BootActivity extends Activity {
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }

    public static final String APP_PREFERENCES = "mySettings";
    public static final String APP_PREFERENCES_COUNTER = "counter";
    public static  int mState;

    Thread splashTread;
    private SharedPreferences mSettings;
    SharedPreferences.Editor editor;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boot);

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        StartAnimations();
    }

    private void StartAnimations() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        LinearLayout l = (LinearLayout) findViewById(R.id.lin_lay);
        l.clearAnimation();
        l.startAnimation(anim);

        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();
        ImageView iv = (ImageView) findViewById(R.id.splash);
        iv.clearAnimation();
        iv.startAnimation(anim);

        splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < 1500) {
                        sleep(100);
                        waited += 100;
                    }
                        mState = mSettings.getInt(APP_PREFERENCES_COUNTER, 0);
                        if(mState == 0) {
                            mState = 1;
                            editor = mSettings.edit();
                            editor.putInt(APP_PREFERENCES_COUNTER, mState);
                            editor.apply();
                            Intent intent1 = new Intent(BootActivity.this, StartHelpActivity.class);
                            intent1.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                            startActivity(intent1);
                            BootActivity.this.finish();
                        }else {
                            Intent intent = new Intent(BootActivity.this, MainActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                            startActivity(intent);
                            BootActivity.this.finish();
                        }

                } catch (InterruptedException e) {
                    //на всякий пожарный
                } finally {
                    BootActivity.this.finish();
                }
            }
        };
        splashTread.start();
    }
}