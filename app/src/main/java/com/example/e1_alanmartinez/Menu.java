package com.example.e1_alanmartinez;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void changeActivity(View view) {
        boolean activity = true;
        Intent intent = new Intent();

        switch (view.getId()) {
            case R.id.btn_calculadora:
                intent.setClass(Menu.this, Calculadora.class);
                break;
            case R.id.btn_imagenes:
                intent.setClass(Menu.this, Imagenes.class);
                break;
            case R.id.btn_web:
                intent.setClass(Menu.this, Web.class);
                break;
            case R.id.btn_video:
                intent.setClass(Menu.this, Video.class);
                break;
            case R.id.btn_acerca:
                break;
            case R.id.btn_mas:
                intent.setClass(Menu.this, Mas.class);
                break;
            case R.id.btn_gps:
                intent.setClass(Menu.this, Mapa.class);
                break;
            default:
                activity = false;
                System.out.println("Saliendo");
                new AlertDialog.Builder(Menu.this)
                        .setIcon(R.drawable.ic_launcher_background)
                        .setTitle("Salir")
                        .setMessage("¿Salir de la aplicacion?")
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
        }

        if (activity) {
            startActivity(intent);
        }
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(Menu.this, "Saliendo de la aplicacion", Toast.LENGTH_LONG).show();
        super.onDestroy();
    }
}