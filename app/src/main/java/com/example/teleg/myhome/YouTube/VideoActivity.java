package com.example.teleg.myhome.YouTube;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.teleg.myhome.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class VideoActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener, View.OnClickListener {


    ImageView imageView;


    private static final int RECOVERY_REQUEST = 1;
    private YouTubePlayerView youTubeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        youTubeView.initialize(YouTubeConfig.API_KEY, this);

        imageView = (ImageView) findViewById(R.id.backActV);
        imageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch(v.getId())
        {
            case R.id.backActV:
                finish();
                break;
            //case  R.id.menu1:
                //Сортировка
               // break;
          //  case  R.id.menu2:
               // Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ryazangov.ru/governor/event/"));
               // startActivity(intent1);
               // break;
           // case  R.id.menu3:
               // Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ryazangov.ru/governor/interview/"));
              //  startActivity(intent2);
               // break;
            //case  R.id.menu4:
                //Сортировка
               // break;
        }
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        if (!b) {
            youTubePlayer.cueVideo("NQHXYna9pg8");
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()) {
            youTubeInitializationResult.getErrorDialog(this, RECOVERY_REQUEST).show();
        } else {
            String error = String.format(getString(R.string.player_error), youTubeInitializationResult.toString());
            Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_REQUEST) {
            // Retry initialization if user performed a recovery action
            getYouTubePlayerProvider().initialize(YouTubeConfig.API_KEY, this);
        }
    }

    protected YouTubePlayerView getYouTubePlayerProvider() {
        return youTubeView;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
