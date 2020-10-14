package com.example.e1_alanmartinez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void changeActivity(View view) {
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
            case R.id.btn_mas:
                intent.setClass(Menu.this, Mas.class);
                break;
            default:
                finishAffinity();
        }

        startActivity(intent);
    }
}