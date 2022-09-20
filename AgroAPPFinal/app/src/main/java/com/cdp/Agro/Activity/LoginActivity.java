package com.cdp.Agro.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.cdp.Agro.R;

public class LoginActivity extends AppCompatActivity {

    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        btnRegister =  findViewById(R.id.btnRegistrarse);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                siguientePag();

            }
        });

    }

    public void siguientePag(){
        Intent intent = new Intent(this, UserSelectActivity.class);
        startActivity(intent);
    }
}
