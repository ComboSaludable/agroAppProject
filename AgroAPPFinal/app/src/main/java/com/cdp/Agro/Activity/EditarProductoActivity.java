package com.cdp.Agro.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.cdp.Agro.R;
import com.cdp.Agro.db.DbProducto;
import com.cdp.Agro.entidades.Producto;


public class EditarProductoActivity extends AppCompatActivity {

    EditText txtNombre, txtCategoria, txtPrecio, txtDescripcion;
    Button guardar;
    Boolean correcto = false;
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

        DbProducto dbProducto = new DbProducto(EditarProductoActivity.this);
        producto = dbProducto.verProducto(id);

        if (producto != null){
            txtNombre.setText(producto.getNombre());
            txtCategoria.setText(producto.getCategoria());
            txtPrecio.setText(producto.getPrecio());
            txtDescripcion.setText(producto.getDescripcion());




        }

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!txtNombre.getText().toString().equals("") && !txtPrecio.getText().toString().equals("") ){

                    correcto = dbProducto.editarProducto(id, txtNombre.getText().toString(),txtCategoria.getText().toString(), txtPrecio.getText().toString(), txtDescripcion.getText().toString());


                    if(correcto){
                        Toast.makeText(EditarProductoActivity.this, "REGISTRO ACTUALIZADO", Toast.LENGTH_LONG).show();
                        verRegistro();
                    } else {
                        Toast.makeText(EditarProductoActivity.this, "ERROR AL ACTUALIZAR", Toast.LENGTH_LONG).show();

                    }
                } else {
                    Toast.makeText(EditarProductoActivity.this, "DEBE LLENAR LOS CAMPOS OBLIGATORIOS", Toast.LENGTH_LONG).show();

                }
            }


        });

}




private void verRegistro(){
    Intent intent = new Intent(this, ProveedorPantallaActivity.class);
    intent.putExtra("ID", id);
    startActivity(intent);
}
}