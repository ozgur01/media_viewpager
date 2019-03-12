package com.example.asynctask;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MRecycAdapter extends RecyclerView.Adapter<MRecycAdapter.MyViewHolder2> {

    private List<Media>  mediaList;
    private LayoutInflater inflater;


    public MRecycAdapter(Context context, List<Media> mediaList)
    {
        this.mediaList = mediaList;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.pager, viewGroup, false);
        MyViewHolder2 holder = new MyViewHolder2(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder2 myViewHolder2, int i) {
        Media selectedMedia = mediaList.get(i);
        myViewHolder2.setData(selectedMedia, i);
    }

    @Override
    public int getItemCount() {
        return mediaList.size();
    }




    @Override
    public void onViewAttachedToWindow(@NonNull MyViewHolder2 holder) {
        super.onViewAttachedToWindow(holder);
        VideoView v = holder.itemView.findViewById(R.id.videoView);
        if (v != null)
            v.start();
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull MyViewHolder2 holder) {
        super.onViewDetachedFromWindow(holder);
        VideoView v = holder.itemView.findViewById(R.id.videoView);
        if (v != null)
            v.pause();
    }



    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    class MyViewHolder2 extends RecyclerView.ViewHolder {

        ImageView imageView;
        VideoView videoView;
        FrameLayout placeholder;

        public MyViewHolder2(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            videoView = itemView.findViewById(R.id.videoView);
            placeholder = itemView.findViewById(R.id.placeholder);
        }

        public void setData(Media selectedMedia, int position)
        {
            if (selectedMedia.getType() == 1){
                videoView.setVisibility(View.VISIBLE);
                Uri uri = Uri.parse(selectedMedia.getUrl());
                videoView.setVideoURI(uri);
                videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        placeholder.setVisibility(View.GONE);
                    }
                });
                //videoView.start();
            }else {
                imageView.setVisibility(View.VISIBLE);
                Picasso.get().load(Uri.parse(selectedMedia.getUrl())).into(imageView);
            }
        }

    }

}
