package com.example.asynctask;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class PagerAdapter extends android.support.v4.view.PagerAdapter {

    private Context mContext;
    private List<Media> mVideoList;

    public PagerAdapter(Context context, List<Media> videoList)
    {
        this.mContext = context;
        this.mVideoList = videoList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        //LayoutInflater inflater = LayoutInflater.from(mContext);
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.pager, container, false);

        Media media = mVideoList.get(position);

        if (media.getType() == 1)
        {
            VideoView video = view.findViewById(R.id.videoView);
            video.setVisibility(View.VISIBLE);
            Uri uri = Uri.parse(media.getUrl());
            video.setVideoURI(uri);
            video.start();

        }else {
            ImageView image = view.findViewById(R.id.imageView);
            image.setVisibility(View.VISIBLE);
            Picasso.get().load(media.getUrl()).into(image);
        }

        container.addView(view);
        return view;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return mVideoList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }
}
