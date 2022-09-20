package com.cdp.Agro.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.cdp.Agro.R;

public class ClientePantallaActivity extends AppCompatActivity {


    ImageView perfil, listaProductos, listarPedidos;
    Button cerrarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_principal_cliente);
        cerrarSesion =  findViewById(R.id.button13);
        listaProductos = findViewById(R.id.imageView9);
        listarPedidos = findViewById(R.id.imageView8);
        perfil = findViewById(R.id.imageView7);

        cerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toLogin();

            }
        });

        listaProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toProductList();
            }
        });

        listarPedidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toPedidosList();
            }
        });

        perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toEditarPerfil();
            }
        });


    }

    public void toProductList(){
        Intent intent = new Intent(this, ListarProductosActivity.class);
        startActivity(intent);
    }

    public void toPedidosList(){
        Intent intent = new Intent(this, ListarPedidosActivity.class);
        startActivity(intent);
    }


    public void toEditarPerfil(){
        Intent intent = new Intent(this, EditarPerfilActivity.class);
        startActivity(intent);
    }



    public void toLogin(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }


}
