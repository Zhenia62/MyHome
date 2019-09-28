package com.example.teleg.myhome.fragments.regFragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.teleg.myhome.R;
import com.example.teleg.myhome.fragments.NewsFragment;


public class fragment3 extends Fragment {



    public fragment3(){

    }
    public static fragment3 newInstance() {
        return new fragment3();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_fragment3, container, false);
    }

}
