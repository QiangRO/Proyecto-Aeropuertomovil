package com.example.aeropuerto20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.widget.Toast;
import android.view.View;
import com.android.volley.Response;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.aeropuerto20.databinding.ActivityPetcheckBinding;

import org.json.JSONException;
import org.json.JSONObject;


public class PetCheck extends AppCompatActivity {
    ActivityPetcheckBinding binding;

    RequestQueue colaPeticiones;
    private JSONObject parametros;
    private final String URL_BASE = "http://192.168.56.1/movil";
    private String endPoint = "/insertarmascota.php";

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_petcheck);
        binding = ActivityPetcheckBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //drawerLayout=findViewById(R.id.drawer_activity);
        //Inicializar cola de peticiones
        colaPeticiones = Volley.newRequestQueue(this);
        binding.btnMostrarLista.setOnClickListener(view -> insertarDatosEndPoint());
    }

    private void insertarDatosEndPoint() {
        obtenerInformacion();
        //Una peticion http a su servicio End Point que sirve para insercion de registros
        //En un endpoint donde vas a insertar registros a tu DB
        //el tercer parametro del request que armas ya no es null
        //sino es el objeto JSON que tiene todos tus datos que quieres insertar
        JsonObjectRequest requestInsercionDatos = new JsonObjectRequest(
                Request.Method.POST,
                URL_BASE + endPoint,
                parametros,
                response -> {
                    try {
                        if (response.get("respuesta").toString().equals("ok")) {
                            Toast.makeText(PetCheck.this,
                                    "Los datos fueron ingresados correctamente",
                                    Toast.LENGTH_SHORT).show();
                            binding.etCodigoMascota.setText("");
                            binding.etNomMascota.setText("");
                            binding.etRaza.setText("");
                            binding.etPesoMascota.setText("");
                            binding.etVacunaMascota.setText("");
                            binding.etFechaNacimiento.setText("");
                        } else {
                            Toast.makeText(PetCheck.this,
                                    "Problemas con el servicio, intente más tarde",
                                    Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error -> {
                    Toast.makeText(PetCheck.this, error.getMessage(),
                            Toast.LENGTH_SHORT).show();
                }
        );
        colaPeticiones.add(requestInsercionDatos);
    }

    private void obtenerInformacion() {
        parametros = new JSONObject();
        try {
            parametros.put("codigo", binding.etCodigoMascota.getText().toString());
            parametros.put("nombre", binding.etNomMascota.getText().toString());
            parametros.put("raza", binding.etRaza.getText().toString());
            parametros.put("peso", binding.etPesoMascota.getText().toString());
            parametros.put("vacuna", binding.etVacunaMascota.getText().toString());
            parametros.put("fechaNacimiento", binding.etFechaNacimiento.getText().toString());
            //parametros.put("raza", Integer.parseInt(binding.etRaza.getText().toString()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        /*
        Armar un objeto JSON
        parametros = {
            "descripcion": "Tomates",
            "codigo": "exc123",
            "precio": 120
        }
         */
    }
    public  void Clickhome(View view){
        MainActivity.redirectActivity(this,MainActivity.class);
    }

    public void clickDashboard(View view){
        MainActivity.redirectActivity(this, CheckIn.class);
    }

    public void clickAboutUs(View view){
        recreate();
    }

    public void clickLogout(View view){
        MainActivity.logout(this);
    }
}