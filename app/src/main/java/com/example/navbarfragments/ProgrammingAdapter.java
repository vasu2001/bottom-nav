package com.example.navbarfragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class ProgrammingAdapter extends RecyclerView.Adapter<ProgrammingAdapter.MyViewHolder>{

    private String[] data;
    public ProgrammingAdapter(String[] data){
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_layout, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String title = data[position];
        holder.title.setText(title);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title;

        public MyViewHolder(View itemView) {
            super((View)itemView);

            title = (TextView) itemView.findViewById(R.id.item_text);
        }
    }
}