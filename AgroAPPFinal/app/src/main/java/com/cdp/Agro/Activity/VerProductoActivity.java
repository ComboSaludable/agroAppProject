package com.cdp.Agro.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.cdp.Agro.R;
import com.cdp.Agro.db.DbProducto;
import com.cdp.Agro.entidades.Producto;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class VerProductoActivity extends AppCompatActivity {

    EditText txtNombre, txtCategoria, txtPrecio, txtDescripcion;
    FloatingActionButton editarButton;
    Button guardar;


    Producto producto;
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_producto);

        txtNombre = findViewById(R.id.editTextTextPersonName6);
        txtCategoria = findViewById(R.id.editTextTextPersonName7);
        txtPrecio = findViewById(R.id.editTextNumberDecimal);
        txtDescripcion = findViewById(R.id.editTextTextMultiLine);
        editarButton = findViewById(R.id.fabEditarButton);
        guardar = findViewById(R.id.button8);

        if(savedInstanceState == null){

            Bundle extras = getIntent().getExtras();
            if (extras == null){
                id = Integer.parseInt(null);
            } else {
                id = extras.getInt("ID");
            }

        }else {

            id = (int) savedInstanceState.getSerializable("ID");

        }

        DbProducto dbProducto = new DbProducto(VerProductoActivity.this);
        producto = dbProducto.verProducto(id);

        if (producto != null){
            txtNombre.setText(producto.getNombre());
            txtCategoria.setText(producto.getCategoria());
            txtPrecio.setText(producto.getPrecio());
            txtDescripcion.setText(producto.getDescripcion());
            txtNombre.setInputType(InputType.TYPE_NULL);
            txtCategoria.setInputType(InputType.TYPE_NULL);
            txtPrecio.setInputType(InputType.TYPE_NULL);
            txtDescripcion.setInputType(InputType.TYPE_NULL);
            guardar.setVisibility(View.INVISIBLE);



        }

        editarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( VerProductoActivity.this, EditarProductoActivity.class);
                intent.putExtra("ID", id);
                startActivity(intent);
            }
        });

    }
}