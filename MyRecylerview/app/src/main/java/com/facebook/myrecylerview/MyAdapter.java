package com.facebook.myrecylerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyviewHolder>{
    Context ctx;
    String names[];
    int images[];

    public MyAdapter(Context ctx, String[] names, int[] images) {
        this.ctx = ctx;
        this.names = names;
        this.images = images;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new MyviewHolder(LayoutInflater.from(ctx).inflate(R.layout.everyrow_design,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        holder.iv.setImageResource(images[position]);
        holder.tv.setText(names[position]);

    }

    @Override
    public int getItemCount() {

        return images.length;
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv;
        public MyviewHolder(@NonNull View itemView) {

            super(itemView);
            iv= itemView.findViewById(R.id.image1);
            tv =itemView.findViewById(R.id.text1);
        }

    }
}