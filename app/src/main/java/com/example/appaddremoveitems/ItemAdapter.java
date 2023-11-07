package com.example.appaddremoveitems;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    ArrayList<String> list_items;

    public ItemAdapter(ArrayList<String> list_items) {
        this.list_items = list_items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail_layout,parent,false);

        return new ItemAdapter.ViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return list_items.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(list_items.get(position));
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvItem;
        Button btnBorrar;

        private ItemAdapter adapter;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvItem = itemView.findViewById(R.id.tvItem);
            btnBorrar = itemView.findViewById(R.id.btnBorrar);

            btnBorrar.setOnClickListener(view ->{

            });
        }

        void bindData(final String item){
            tvItem.setText(item);
        }


    }
}
