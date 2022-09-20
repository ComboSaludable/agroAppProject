package com.cdp.Agro.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.cdp.Agro.R;
import com.cdp.Agro.adaptadores.ListaPedidoAdapter;
import com.cdp.Agro.db.DbPedido;
import com.cdp.Agro.entidades.Pedido;

import java.util.ArrayList;

public class ListarPedidosActivity extends AppCompatActivity {



    RecyclerView listaPedidos;
    ArrayList<Pedido> listArrayPedidos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_pedidos);
        listaPedidos =  findViewById(R.id.listaPedidos);
        listaPedidos.setLayoutManager(new LinearLayoutManager(this));

        DbPedido dbPedido = new DbPedido(ListarPedidosActivity.this);

        listArrayPedidos = new ArrayList<>();

        ListaPedidoAdapter adapter = new ListaPedidoAdapter(dbPedido.mostrarPedido());

        listaPedidos.setAdapter(adapter);


    }



}