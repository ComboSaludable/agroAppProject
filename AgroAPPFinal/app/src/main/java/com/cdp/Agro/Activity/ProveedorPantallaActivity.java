package com.cdp.Agro.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.cdp.Agro.R;

public class ProveedorPantallaActivity extends AppCompatActivity {


    ImageView  listaProductos, listarPeticiones, agregarProducto, perfil;
    Button cerrarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_principal_proveedor);
        cerrarSesion =  findViewById(R.id.button7);
        listaProductos = findViewById(R.id.imageButton2);
        listarPeticiones = findViewById(R.id.imageButton4);
        agregarProducto = findViewById(R.id.imageButton3);
        perfil = findViewById(R.id.imageButton5);


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

        listarPeticiones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toPedidosList();
            }
        });


        agregarProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toAddProduct();
            }
        });

        perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toEditarPerfil();
            }
        });


    }

    public void toAddProduct(){
        Intent intent = new Intent(this, NuevoProductoActivity.class);
        startActivity(intent);
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
        Intent intent = new Intent(this, EditarPerfilProveedorActivity.class);
        startActivity(intent);
    }



    public void toLogin(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
