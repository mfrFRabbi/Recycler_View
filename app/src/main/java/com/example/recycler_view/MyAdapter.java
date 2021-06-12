package com.example.recycler_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private String[] countryName,countryDesc;
    private int[] images;

    private static ClickListener clickListener;

    public MyAdapter(Context context,int[] images, String[] countryName, String[] countryDesc ) {
        this.context = context;
        this.countryName = countryName;
        this.countryDesc = countryDesc;
        this.images = images;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
       View view =  layoutInflater.inflate(R.layout.layout_sample,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  MyAdapter.MyViewHolder holder, int position) {
        holder.countryName.setText(countryName[position]);
        holder.countryDesc.setText(countryDesc[position]);
        holder.flagImageView.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return countryName.length;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        TextView countryName,countryDesc;
        ImageView flagImageView;
        public MyViewHolder(@NonNull  View itemView) {
            super(itemView);
            countryName = itemView.findViewById(R.id.countryNameId);
            countryDesc = itemView.findViewById(R.id.countryDescriptionId);
            flagImageView = itemView.findViewById(R.id.imageId);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            MyAdapter.clickListener.onItemClickListener(v,getAdapterPosition());
        }

        @Override
        public boolean onLongClick(View v) {
            MyAdapter.clickListener.onItemLongClickListener(v,getAdapterPosition());
            return false;
        }
    }
    public interface ClickListener{
        void onItemClickListener(View v,int position);
        void onItemLongClickListener(View v,int position);
    }
    public void setOnItemClickListener(ClickListener clickListener){
        MyAdapter.clickListener = clickListener;
    }
}
