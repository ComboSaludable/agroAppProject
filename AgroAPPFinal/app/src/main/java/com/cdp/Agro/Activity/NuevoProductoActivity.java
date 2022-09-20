package com.cdp.Agro.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.cdp.Agro.R;
import com.cdp.Agro.db.DbProducto;

public class NuevoProductoActivity extends AppCompatActivity {

    EditText txtNombre, txtCategoria, txtDescripcion, txtPrecio, txtStock, txtDisponibilidad;

    Button btnGuarda;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuevo_producto);

        txtNombre = findViewById(R.id.txtNombreAgregarProducto);
        txtCategoria = findViewById(R.id.txtCategoriaProducto);
        txtDescripcion= findViewById(R.id.txtDescripcionProducto);
        txtPrecio= findViewById(R.id.txtPrecioProducto);
        txtStock= findViewById(R.id.txtStockProducto);
        txtDisponibilidad = findViewById(R.id.txtStockDisponibilidades);
        btnGuarda = findViewById(R.id.btnAgregarProducto);

        btnGuarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!txtNombre.getText().toString().equals("") && !txtCategoria.getText().toString().equals("")
                        && !txtDescripcion.getText().toString().equals("") && !txtPrecio.getText().toString().equals("")
                        && !txtStock.getText().toString().equals("")) {

                    DbProducto dbProducto = new DbProducto(NuevoProductoActivity.this);
                    long id = dbProducto.insertarProducto(1,txtNombre.getText().toString(), txtCategoria.getText().toString(),
                            Double.parseDouble(txtPrecio.getText().toString()),txtDescripcion.getText().toString(),
                            Integer.parseInt(txtStock.getText().toString()),txtDisponibilidad.getText().toString());

                    if (id > 0) {
                        Toast.makeText(NuevoProductoActivity.this, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
                        limpiar();
                        siguientePag();

                    } else {
                        Toast.makeText(NuevoProductoActivity.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(NuevoProductoActivity.this, "DEBE LLENAR LOS CAMPOS OBLIGATORIOS", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void siguientePag(){
        Intent intent = new Intent(this, ProveedorPantallaActivity.class);
        startActivity(intent);
    }



    private void limpiar() {
        txtNombre.setText("");
        txtCategoria.setText("");
        txtPrecio.setText("");
        txtDescripcion.setText("");
        txtStock.setText("");
    }

}
