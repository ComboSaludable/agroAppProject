package com.cdp.Agro.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;


import com.cdp.Agro.R;
import com.cdp.Agro.adaptadores.ListaProductoAdapter;
import com.cdp.Agro.db.DbProducto;
import com.cdp.Agro.entidades.Producto;

import java.util.ArrayList;

public class ListarProductosActivity extends AppCompatActivity {



    RecyclerView listaProductos;
    ArrayList<Producto>  listArrayProductos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_productos);
        listaProductos =  findViewById(R.id.listaProductos);
        listaProductos.setLayoutManager(new LinearLayoutManager(this));

        DbProducto dbProducto = new DbProducto(ListarProductosActivity.this);

        listArrayProductos = new ArrayList<>();

        ListaProductoAdapter adapter = new ListaProductoAdapter(dbProducto.mostrarProductos());

        listaProductos.setAdapter(adapter);






    }

}