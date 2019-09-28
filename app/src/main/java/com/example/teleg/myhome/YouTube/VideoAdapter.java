//package com.example.teleg.myhome.YouTube;
//
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.example.teleg.myhome.R;
//import com.google.android.youtube.player.YouTubePlayerView;
//
//import java.util.ArrayList;
//
//public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder>{
//
//    ArrayList<Video> videos;
//
//    public VideoAdapter(ArrayList<Video> Videos){
//        this.videos = videos;
//    }
//
//    public class VideoViewHolder extends RecyclerView.ViewHolder{
//        View video_view;
//
//        public VideoViewHolder (View view)
//        {
//            super(view);
//
//            video_view = (YouTubePlayerView) view.findViewById(R.id.view2);
//
//        }
//
//    }
//
//    @NonNull
//    @Override
//    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
//        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_video_item, viewGroup, false);
//        return new VideoViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
//        holder.video_view.set(videos.get(position).getPath());
//    }
//
//    @Override
//    public int getItemCount() {
//        return videos.size();
//    }
//
//}
