package com.example.e1_alanmartinez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Mas extends AppCompatActivity {

    ImageView imagen;
    TextView hora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mas);

        this.imagen = findViewById(R.id.mas_image);
        this.hora = findViewById(R.id.tv_horaActual);

        String horaActual = DateFormat.getDateTimeInstance().format(new Date());
        hora.setText(horaActual);

    }

    public void switchImage(View view) {
        if (imagen.getVisibility() == ImageView.INVISIBLE) {
            imagen.setVisibility(ImageView.VISIBLE);
        } else {
            imagen.setVisibility(ImageView.INVISIBLE);
        }
    }
}