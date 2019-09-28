package com.example.teleg.myhome.fragments.regFragments;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ComlainHolder extends RecyclerView.ViewHolder {

    CardView cardView;
    TextView  title, category, type, status, address, theme, text;


    public ComlainHolder(@NonNull View itemView) {
        super(itemView);
    }
}
