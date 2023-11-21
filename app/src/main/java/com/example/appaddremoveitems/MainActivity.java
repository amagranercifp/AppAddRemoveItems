package com.example.appaddremoveitems;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView rvListadoItems;

    private ArrayList<String> list_items = new ArrayList<>();

    private Button btnAñadir;

    private ImageButton ibOrdenar;
    private EditText tvAñadirTexto;

    private ItemAdapter adapter;

    Toolbar toolbar;

    SearchView barraBusqueda;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        barraBusqueda = findViewById(R.id.svBusqueda);

        barraBusqueda.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filtrado(newText);
                return false;
            }
        });



        //Inicialización de los datos
        initItems();

        if(adapter == null){
            adapter = new ItemAdapter(list_items);
        }

        rvListadoItems = (RecyclerView) findViewById(R.id.rvListadoItems);
        rvListadoItems.setAdapter(adapter);
        rvListadoItems.setLayoutManager(new LinearLayoutManager(this));


        btnAñadir = (Button) findViewById(R.id.btnAñadir);

        btnAñadir.setOnClickListener(this);


    }

    private void filtrado(String texto){
        ArrayList<String> filteredList_items = new ArrayList<>();
        for(String item : list_items){
            if(item.toLowerCase().contains(texto.toLowerCase())){
                filteredList_items.add(item);
            }
        }
        adapter.setFilterList(filteredList_items);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.opcion1){
            //Ascendente
            sortItems(1);
        }
        else if(id == R.id.opcion2){
            //Descendente
            sortItems(2);
        }
        else if(id == R.id.opcion3){
            //Interactivo
            sortItems(3);
        }

        return true;
    }

    // Handles the row being being clicked
    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.btnAñadir){
            //Llamamos funcion de añadir items
            addItems(view);
        }
    }

    public void sortItems(int modo){
        adapter.ordenar(modo);
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