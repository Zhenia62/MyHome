package com.example.teleg.myhome.fragments.regFragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.teleg.myhome.R;

public class fragment5 extends Fragment {
    public fragment5() {

    }

    public static fragment5 newInstance() {
        return new fragment5();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fragment5, container, false);
    }
}