package com.example.asynctask;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.VideoView;

import com.squareup.picasso.Picasso;

public class MFragment extends Fragment {

    private String url;
    private int type;
    private VideoView videoView;


    public static MFragment newInstance(Media media) {
        MFragment myFragment = new MFragment();
        Bundle args = new Bundle();
        args.putString("url", media.getUrl());
        args.putInt("type", media.getType());
        myFragment.setArguments(args);
        return myFragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.url = getArguments() != null ? getArguments().getString("url") : null;
        this.type = getArguments() != null ? getArguments().getInt("type") : 0;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.pager, container, false);

        if (type == 1)
        {
            videoView = view.findViewById(R.id.videoView);
            if (videoView != null) {
                videoView.setVisibility(View.VISIBLE);
                Uri uri = Uri.parse(this.url);
                videoView.setVideoURI(uri);
                if (getUserVisibleHint()) videoView.start();
            }
        }
        else {
            ImageView image = view.findViewById(R.id.imageView);
            image.setVisibility(View.VISIBLE);
            Picasso.get().load(Uri.parse(url)).into(image);
        }

        return view;
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (type == 1 && this.isVisible())
        {
            if (isVisibleToUser){
                //videoView.onWindowSystemUiVisibilityChanged(View.VISIBLE);
                //videoView.requestFocus();
                videoView.start();
            }
            else{
                //videoView.onWindowSystemUiVisibilityChanged(View.GONE);
                videoView.pause();
            }
        }
    }

}
