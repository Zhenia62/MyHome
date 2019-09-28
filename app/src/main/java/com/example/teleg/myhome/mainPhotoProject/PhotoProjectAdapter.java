package com.example.teleg.myhome.mainPhotoProject;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.teleg.myhome.R;

import java.util.ArrayList;

public class PhotoProjectAdapter extends RecyclerView.Adapter<PhotoProjectAdapter.PhotoViewHolder> {

        ArrayList<PhotoProject> photos;

        public PhotoProjectAdapter (ArrayList<PhotoProject> photos)
        {
            this.photos = photos;
        }

        public  class PhotoViewHolder extends RecyclerView.ViewHolder{
            ImageView img1;
            ImageView img2;
            public  PhotoViewHolder (View view)
            {
                super(view);
                img1 = ( ImageView ) view.findViewById(R.id.image_1);
                img2 = ( ImageView ) view.findViewById(R.id.image_2);
            }
        }

        @NonNull
        @Override
        public PhotoProjectAdapter.PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.project_card, viewGroup, false);
            return new PhotoProjectAdapter.PhotoViewHolder(view);
        }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int i) {
        holder.img1.setImageResource(photos.get(i).getImg1());
        holder.img2.setImageResource(photos.get(i).getImg2());
    }


        @Override
        public int getItemCount() {
            return photos.size();
        }




}
