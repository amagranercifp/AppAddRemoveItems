package com.example.appaddremoveitems;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvListadoItems;

    private ArrayList<String> list_items = new ArrayList<>();;

    private ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initItems();

        if(adapter == null){
            adapter = new ItemAdapter(list_items);
        }


        rvListadoItems = (RecyclerView) findViewById(R.id.rvListadoItems);
        rvListadoItems.setAdapter(adapter);
        rvListadoItems.setLayoutManager(new LinearLayoutManager(this));


    }

    void initItems(){
        for(int i=0; i<15; i++){
            list_items.add("Item "+i);
        }
    }
}