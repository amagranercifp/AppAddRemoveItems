package com.example.appaddremoveitems;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    ArrayList<String> list_items;
    int orden=0;

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
                String texto_item = list_items.get(getAdapterPosition());
                Toast.makeText(itemView.getContext(),"Elemento eliminado "+texto_item,Toast.LENGTH_LONG).show();
                list_items.remove(getAdapterPosition());
                notifyItemRemoved(getAdapterPosition());

            });
        }

        void bindData(final String item){
            tvItem.setText(item);
        }

    }

    void añadirItems(String item){

        list_items.add(item);

        notifyDataSetChanged();

    }

    void ordenar(int modo){
        if(modo == 1) {
            //Ascendente
            Collections.sort(list_items);
        }else if(modo == 2){
            //Descendente
            Collections.sort(list_items, Collections.reverseOrder());
        }else{
            ordenarLista();
        }
        notifyDataSetChanged();
    }

    void ordenarLista(){
        //Ordenar ascendente
        //Collections.sort(list_items);

        //Ordenar descendente
        //Collections.sort(list_items, Collections.reverseOrder());

        if(orden == 0){
            Collections.sort(list_items);
            orden=1;
        }
        else{
            Collections.sort(list_items, Collections.reverseOrder());
            orden=0;
        }
        notifyDataSetChanged();

    }
}
