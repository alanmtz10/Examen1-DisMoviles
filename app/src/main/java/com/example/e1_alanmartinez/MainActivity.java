package com.example.e1_alanmartinez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class MainActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;

    private String user = "admin@admin.com";
    private String pass = "admin";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.email = findViewById(R.id.editText_email);
        this.password = findViewById(R.id.editText_password);
    }

    public void onClickListener(View view) {
        if (view.getId() == R.id.btn_iniciarSesion) {
            if (this.email.getText().toString().equals(this.user) && this.password.getText().toString().equals(this.pass)) {
                Intent intent = new Intent(MainActivity.this, Menu.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "Correo o contraseña incorrectos", Toast.LENGTH_LONG).show();
            }
        } else if (view.getId() == R.id.btn_salir) {
            finishAffinity();
        }
    }

}