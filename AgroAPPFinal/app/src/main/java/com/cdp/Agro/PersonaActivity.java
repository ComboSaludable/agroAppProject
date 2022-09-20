package com.cdp.Agro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.cdp.Agro.Activity.ListarPedidosActivity;
import com.cdp.Agro.db.DbPersona;

import java.util.Date;



public class PersonaActivity extends AppCompatActivity {

    EditText txtNombre,txtApellido,txtDireccion,
            txtTelefono, txtFechaNacimiento,
            txtIdentificacion,txtUbicacion;

    Button btnSiguiente;
    Button btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrarse2);

        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        txtDireccion = findViewById(R.id.txtDireccion);
        txtFechaNacimiento = findViewById(R.id.txtFechaNacimiento);
        txtIdentificacion = findViewById(R.id.txtIdentificacion);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtUbicacion = findViewById(R.id.txtUbicacion);
        btnSiguiente = findViewById(R.id.btnSiguiente);


        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DbPersona dbPersona = new DbPersona(PersonaActivity.this);
                long id = dbPersona.insertarPersona(txtNombre.getText().toString(),
                        txtApellido.getText().toString(),
                        (Date) txtFechaNacimiento.getText(),
                        txtIdentificacion.getText().toString(),
                        txtTelefono.getText().toString(),
                        txtUbicacion.getText().toString());
                if (id > 0) {
                    Toast.makeText(PersonaActivity.this, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
                    limpiar();
                } else {
                    Toast.makeText(PersonaActivity.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_LONG).show();

                }
                nuevoRegistro();
            }
        });
    }


    private void limpiar(){
        txtNombre.setText("");
        txtApellido.setText("");
        txtFechaNacimiento.setText("");
        txtIdentificacion.setText("");
        txtTelefono.setText("");
        txtUbicacion.setText("");
    }

    public void nuevoRegistro(){
        Intent intent = new Intent(this, ListarPedidosActivity.class);
        startActivity(intent);
    }






}
