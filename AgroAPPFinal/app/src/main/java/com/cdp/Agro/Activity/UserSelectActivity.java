package com.cdp.Agro.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.cdp.Agro.R;

public class UserSelectActivity extends AppCompatActivity {



    RadioButton cliente, proveedor;
    Button btnSiguiente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrarse1);
        cliente =  findViewById(R.id.radioButton);
        proveedor =  findViewById(R.id.radioButton2);
        btnSiguiente = findViewById(R.id.button4);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();

            }
        });

    }

    public void validate(){

        String cad = "Entrando...: \n";

        if (cliente.isChecked()==true){
            cad +="CLIENTE\n";
            clientPag();
        }

        if (proveedor.isChecked()){
            cad+="PROVEEDOR";
            proveedorPag();
        }

        Toast.makeText(getApplicationContext(), cad, Toast.LENGTH_LONG).show();

    }


    public void clientPag(){
        Intent intent = new Intent(this, ClientePantallaActivity.class);
        startActivity(intent);
    }

    public void proveedorPag(){
        Intent intent = new Intent(this, ProveedorPantallaActivity.class);
        startActivity(intent);
    }

}
