package com.example.aeropuerto20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.aeropuerto20.databinding.ActivityInformacionBinding;
import com.example.aeropuerto20.databinding.ActivityListaVueloBinding;
import com.example.aeropuerto20.databinding.ActivityVueloBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

public class vuelo extends AppCompatActivity {
    ActivityVueloBinding binding;
    //Cola de Peticiones -> a solicitudes que se hacen concurrentes en Internet
    private RequestQueue colaPeticiones;

    private final String URL_BASE = "http://192.168.0.5/aeropuerto";
    private String endPoint = "/vuelos.php";
    private ArrayList<vuelos> vueloss = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_vuelo);
        binding = ActivityVueloBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        colaPeticiones = Volley.newRequestQueue(this);
        peticionServicioWebBasico();
        mostrarResultadosEndPoint();
        binding.btnmostrarvuelo.setOnClickListener(view -> {
            peticionServicioWebBasico();
            mostrarResultadosEndPoint();
        });


    }
    private void mostrarResultadosEndPoint() {
        String mensaje = "";
        for (vuelos v: vueloss) {
            mensaje += v.toString();
        }
        binding.txtlistavuelos.setText(mensaje);
    }

    private void peticionServicioWebBasico() {
        JsonArrayRequest reqInformacion = new JsonArrayRequest(
                Request.Method.GET,
                URL_BASE+endPoint,
                null,
                response -> {
                    if (response.length() > 0) {
                        try {
                            Log.d("TAG", response.toString());
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject objeto = new JSONObject(response.get(i).toString());
                                vuelos v = new vuelos(
                                        objeto.getInt("cod"),
                                        objeto.getString("destino"),
                                        objeto.getString("fechasalida"),
                                        objeto.getString("fechallegada")
                                );
                                vueloss.add(v);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                error -> {
                    Toast.makeText(vuelo.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }

        );
        colaPeticiones.add(reqInformacion);
    }

}
