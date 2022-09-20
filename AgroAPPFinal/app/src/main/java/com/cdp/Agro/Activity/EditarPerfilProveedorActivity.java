package com.cdp.Agro.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.cdp.Agro.R;

public class EditarPerfilProveedorActivity extends AppCompatActivity {

    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrarse3);
        btnGuardar =  findViewById(R.id.btnFinalizar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toClientPantalla();

            }
        });

    }

    public void toClientPantalla(){
        Intent intent = new Intent(this, ProveedorPantallaActivity.class);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), "OK", Toast.LENGTH_LONG).show();

    }
}