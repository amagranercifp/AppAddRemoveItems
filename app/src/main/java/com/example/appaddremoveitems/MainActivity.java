package com.example.appaddremoveitems;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView rvListadoItems;

    private ArrayList<String> list_items = new ArrayList<>();

    private Button btnAñadir;

    private ImageButton ibOrdenar;
    private EditText tvAñadirTexto;

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

        btnAñadir = (Button) findViewById(R.id.btnAñadir);

        ibOrdenar = (ImageButton)  findViewById(R.id.ibOrdenar);

        btnAñadir.setOnClickListener(this);

        ibOrdenar.setOnClickListener(this);


    }

    // Handles the row being being clicked
    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.btnAñadir){
            //Llamamos funcion de añadir items
            addItems(view);
        }
        if(view.getId() == R.id.ibOrdenar){
            //Llamamos funcion de añadir items
            sortItems(view);
        }


    }

    public void sortItems(View view){
            adapter.ordenarLista();
    }

    public void addItems(View view){
        tvAñadirTexto = (EditText) findViewById(R.id.tvAñadirTexto);

        //list_items.add(tvAñadirTexto.getText().toString());
        //adapter.list_items.add(tvAñadirTexto.getText().toString());
        //adapter.notifyDataSetChanged();

        adapter.añadirItems(tvAñadirTexto.getText().toString());
        Toast.makeText(view.getContext(),"Elemento añadido "+tvAñadirTexto.getText().toString(),Toast.LENGTH_LONG).show();
    }

    void initItems(){
        for(int i=0; i<15; i++){
            list_items.add("Item "+i);
        }
    }
}