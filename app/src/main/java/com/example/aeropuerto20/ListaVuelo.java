package com.example.aeropuerto20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.aeropuerto20.databinding.ActivityListaVueloBinding;

public class ListaVuelo extends AppCompatActivity {
    ActivityListaVueloBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_vuelo);
    }
}