package com.example.asynctask;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List<Media> list = new ArrayList<>();

        Video v1 = new Video("https://res.cloudinary.com/dwbih2ydl/video/upload/v1551257200/OSMANLI_D%C3%9C%C5%9E%C3%9CK_BOYUT.mp4", 1);

        Video v2 = new Video("https://res.cloudinary.com/dwbih2ydl/video/upload/v1548766245/cloud/video/Konu%C5%9Fan_Kediler_3_-_En_Komik_Kedi_Videolar%C4%B1.mp4", 1);

        Image i1 = new Image("https://www.campusonline.com/upload/urunler/513490_ResimOkumaveModernslupTarihiEitimiTmBlmler_KOzFY58i/resimokumatumbolumler600min.jpg", 2);

        Image i2 = new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRWAb-49YbuhQbeVsZugKjhjngBf_LCiW8oeNOADIrH_twBAx6w", 2);

        list.add(v1);
        list.add(v2);
        list.add(i1);
        list.add(i2);

        viewPager = findViewById(R.id.viewPager);

        viewPager.setAdapter(new StatePagerAdapter(getSupportFragmentManager(), list));

        /*
        PagerAdapter adapter = new PagerAdapter(this, list);
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                View view = viewPager.getChildAt(i);
                Log.d("scrolledpage", String.valueOf(i));

                VideoView video = view.findViewById(R.id.videoView);
                if (video != null) {
                    video.stopPlayback();
                }

            }

            @Override
            public void onPageSelected(int i) {
                Log.d("pageselected", String.valueOf(i));
                View view = viewPager.getChildAt(i);


                VideoView video = view.findViewById(R.id.videoView);
                if (video != null) {
                    video.start();
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    */
    }


}

