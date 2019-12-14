package com.example.libreria_act;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class Home_act extends AppCompatActivity {

    private ViewFlipper vf;
    private int[] images = {R.drawable.a, R.drawable.b, R.drawable.c};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_act);

        vf = (ViewFlipper)findViewById(R.id.slider);

        // se iteran las instrucciones del slider
        for(int i = 0; i<images.length; i++)
        {
            Instrucciones(images[i]);
        }
    }

    public void Instrucciones(int i)
    {
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);

        vf.addView(view); //  añadimos la vista
        vf.setFlipInterval(2800); // intervalo de imagenes
        vf.setAutoStart(true); // el slider inicia de forma automatica

        // Sentido al slider
        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setOutAnimation(this, android.R.anim.slide_out_right);
    }

    public void Libros(View v)
    {
        String[] listaLibros = {"Farenheti","Revival","Tesla"};
        int[] costolib= {5000,12000,25000};



        Intent i = new Intent(this, Libros_act.class);
        i.putExtra("libros", listaLibros);
        i.putExtra("precio", costolib);
        startActivity(i);
    }
    public void Registro(View v){
        Intent i = new Intent(this, Ingresar.class);
        startActivity(i);
    }
}
