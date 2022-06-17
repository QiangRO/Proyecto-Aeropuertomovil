package com.example.aeropuerto20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.aeropuerto20.databinding.ActivityInformacionBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import javax.crypto.Mac;

public class informacion extends AppCompatActivity {
    ActivityInformacionBinding binding;
    //Cola de Peticiones -> a solicitudes que se hacen concurrentes en Internet
    private RequestQueue colaPeticiones;

    private final String URL_BASE = "http://192.168.0.5/aeropuerto";
    private String endPoint = "/mascotas.php";
    private ArrayList<Mascota> mascotas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_informacion);
        binding = ActivityInformacionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        colaPeticiones = Volley.newRequestQueue(this);

        binding.btnMostrarLista.setOnClickListener(view -> {
            buscarmascota("http://192.168.0.5/aeropuerto/mascotas.php?codigo="+binding.etmostrarmascotas.getText()+"");
        });

    }

    private void buscarmascota(String url) {
        JsonArrayRequest reqInformacion = new JsonArrayRequest(url, response -> {
            JSONObject objeto = null;
            if (response.length() > 0) {
                try {
                    Log.d("TAG", response.toString());
                    for (int i = 0; i < response.length(); i++) {
                        objeto = new JSONObject(response.get(i).toString());
                        Mascota p = new Mascota(
                                objeto.getInt("id"),
                                objeto.getString("codigo"),
                                objeto.getString("nombre"),
                                objeto.getString("raza"),
                                objeto.getString("peso"),
                                objeto.getString("vacuna"),
                                objeto.getString("fechaNacimiento")
                        );
                        mascotas.add(p);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                error -> {
                    Toast.makeText(informacion.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }

        );
        colaPeticiones.add(reqInformacion);

        mostrarResultadosEndPoint();
    }

    private void mostrarResultadosEndPoint() {
        String mensaje = "";
        for (Mascota p: mascotas) {
            mensaje += p.toString();
        }
        binding.txtListaMascotas.setText(mensaje);
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
                                Mascota p = new Mascota(
                                        objeto.getInt("id"),
                                        objeto.getString("codigo"),
                                        objeto.getString("nombre"),
                                        objeto.getString("raza"),
                                        objeto.getString("peso"),
                                        objeto.getString("vacuna"),
                                        objeto.getString("fechaNacimiento")
                                );
                                mascotas.add(p);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                error -> {
                    Toast.makeText(informacion.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }

        );
        colaPeticiones.add(reqInformacion);
    }
}