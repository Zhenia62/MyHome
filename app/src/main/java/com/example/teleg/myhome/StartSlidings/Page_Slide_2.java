package com.example.teleg.myhome.StartSlidings;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.teleg.myhome.R;

public class Page_Slide_2 extends Fragment {

    VideoView videoPlayer;
    Uri myVideoUri;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page_slide_2, container, false);

        videoPlayer =  (VideoView) view.findViewById(R.id.view_my_home);
        myVideoUri= Uri.parse( "android.resource://" + view.getContext().getPackageName() + "/" + R.raw.nash_dom_ryazan);
        videoPlayer.setVideoURI(myVideoUri);
        MediaController mediaController = new MediaController(getContext());
        videoPlayer.setMediaController(mediaController);
        mediaController.setMediaPlayer(videoPlayer);

        return view;
    }

    public void play(View view){
        videoPlayer.start();
    }
    public void pause(View view){
        videoPlayer.pause();
    }
    public void stop(View view){
        videoPlayer.stopPlayback();
        videoPlayer.resume();
    }
}
