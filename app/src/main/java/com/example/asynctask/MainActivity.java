package com.example.asynctask;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_main);

        //recyclerView = findViewById(R.id.recylerview);

        recyclerView = findViewById(R.id.recylerview);

        List<Media> list = new ArrayList<>();

        Video v1 = new Video("https://res.cloudinary.com/dwbih2ydl/video/upload/v1551257200/OSMANLI_D%C3%9C%C5%9E%C3%9CK_BOYUT.mp4", 1);

        Video v2 = new Video("https://res.cloudinary.com/dwbih2ydl/video/upload/v1548766245/cloud/video/Konu%C5%9Fan_Kediler_3_-_En_Komik_Kedi_Videolar%C4%B1.mp4", 1);

        Image i1 = new Image("https://www.campusonline.com/upload/urunler/513490_ResimOkumaveModernslupTarihiEitimiTmBlmler_KOzFY58i/resimokumatumbolumler600min.jpg", 2);

        Image i2 = new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRWAb-49YbuhQbeVsZugKjhjngBf_LCiW8oeNOADIrH_twBAx6w", 2);

        list.add(v1);
        list.add(v2);
        list.add(i1);
        list.add(i2);

        List<Product> productList = new ArrayList<>();
        productList.add(new Product("urun1", list));
        productList.add(new Product("urun2", list));
        productList.add(new Product("urun2", list));
        productList.add(new Product("urun2", list));
        productList.add(new Product("urun2", list));
        productList.add(new Product("urun2", list));
        productList.add(new Product("urun2", list));
        productList.add(new Product("urun2", list));
        productList.add(new Product("urun2", list));
        productList.add(new Product("urun2", list));
        productList.add(new Product("urun2", list));
        productList.add(new Product("urun2", list));
        productList.add(new Product("urun2", list));
        productList.add(new Product("urun2", list));
        productList.add(new Product("urun2", list));
        productList.add(new Product("urun2", list));
        productList.add(new Product("urun2", list));
        productList.add(new Product("urun2", list));
        productList.add(new Product("urun2", list));
        productList.add(new Product("urun2", list));

        RecyclerAdapter a = new RecyclerAdapter(this, productList);
        recyclerView.setAdapter(a);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int completelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
                int firstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                int lastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();

                View completelyView = linearLayoutManager.findViewByPosition(completelyVisibleItemPosition);
                View firstVisibleView = linearLayoutManager.findViewByPosition(firstVisibleItemPosition);
                View lastVisibleView = linearLayoutManager.findViewByPosition(lastVisibleItemPosition);


                if (firstVisibleView != null){
                    if (linearLayoutManager.isViewPartiallyVisible(firstVisibleView, false, false)) {
                        VideoView fv = firstVisibleView.findViewById(R.id.videoView);
                        if (fv != null) fv.pause();
                    }
                }

                if (lastVisibleView != null){
                    if (linearLayoutManager.isViewPartiallyVisible(lastVisibleView, false, false)) {
                        VideoView lv = lastVisibleView.findViewById(R.id.videoView);
                        if (lv != null) lv.pause();
                    }
                }

                if (completelyView != null){
                    VideoView cv = completelyView.findViewById(R.id.videoView);
                    if (cv != null)
                        cv.start();
                }
            }
        });


        /*
        final MRecycAdapter mRecycAdapter = new MRecycAdapter(this, list);
        recyclerView.setAdapter(mRecycAdapter);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
*/


        /*
        RecyclerAdapter productAdapter = new RecyclerAdapter(this, productList, getSupportFragmentManager());
        recyclerView.setAdapter(productAdapter);

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                int pos = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
                View view = linearLayoutManager.findViewByPosition(pos);
                if (view != null)
                {
                    ViewPager active_pager = view.findViewById(R.id.viewPager2);
                    TextView title = view.findViewById(R.id.product_title);

                    Log.d("asd", "title");
                }
            }
        });
         */


        //viewPager = findViewById(R.id.viewPager);

        //viewPager.setAdapter(new StatePagerAdapter(getSupportFragmentManager(), list));

    }


}

