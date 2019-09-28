package com.example.teleg.myhome.fragments.regFragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.teleg.myhome.R;


public class fragment4 extends Fragment {

    public fragment4() {

    }

    public static fragment4 newInstance() { return new fragment4();}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fragment4, container, false);
    }


}
