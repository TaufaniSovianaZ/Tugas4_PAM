package com.example.tugas4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.List;

public class Adapter_Layout extends RecyclerView.Adapter<Adapter_Layout.ItemViewHolder> {

    private List<Item_Layout> itemList;

    public Adapter_Layout(List<Item_Layout> itemList) {
        this.itemList = itemList;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_view, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Item_Layout currentItem = itemList.get(position);
        holder.tvInput1.setText(currentItem.getInput1());
        holder.tvInput2.setText(currentItem.getInput2());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView tvInput1, tvInput2;
        ShapeableImageView imageView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            tvInput1 = itemView.findViewById(R.id.tv_in1);
            tvInput2 = itemView.findViewById(R.id.tv_in2);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}