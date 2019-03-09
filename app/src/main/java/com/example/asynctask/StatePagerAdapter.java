package com.example.asynctask;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

public class StatePagerAdapter extends FragmentStatePagerAdapter {


    private List<Media> mediaList;

    public StatePagerAdapter(FragmentManager fm, List<Media> mediaList) {
        super(fm);

        this.mediaList = mediaList;
    }

    @Override
    public Fragment getItem(int i) {
        return MFragment.newInstance(mediaList.get(i));
    }

    @Override
    public int getCount() {
        return mediaList.size();
    }
}
