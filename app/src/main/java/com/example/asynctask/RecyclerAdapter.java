package com.example.asynctask;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<Product> productList;
    private LayoutInflater inflater;
    private Context context;

    public RecyclerAdapter(Context context, List<Product> productList)
    {
        this.context = context;
        this.productList = productList;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.horizontal_recyc_layout, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Product selectedProduct = productList.get(i);
        myViewHolder.setData(selectedProduct, i);
    }



    @Override
    public int getItemCount() {
        return productList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        RecyclerView mrv;

        public MyViewHolder(View itemView) {
            super(itemView);
            mrv = itemView.findViewById(R.id.m_rec);


        }

        public void setData(Product selectedProduct, int position)
        {
            final MRecycAdapter mRecycAdapter = new MRecycAdapter(context, selectedProduct.getMediaList());
            mrv.setAdapter(mRecycAdapter);
            final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            mrv.setLayoutManager(linearLayoutManager);
            mrv.setHasFixedSize(true);
            mrv.setRecycledViewPool(new RecyclerView.RecycledViewPool());
            if (mrv.getOnFlingListener() == null){
                SnapHelper snapHelper = new PagerSnapHelper();
                snapHelper.attachToRecyclerView(mrv);
            }


        }

    }

}
