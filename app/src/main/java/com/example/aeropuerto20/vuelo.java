package com.example.aeropuerto20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class vuelo extends AppCompatActivity {
    ListView listView;
    adapter adaapter;
    public static ArrayList<vuelos> vuelosArrayList = new ArrayList<>();
    String url = "http://kaeytt123.byethost24.com/aeropuerto/mostrarvuelos.php";
    vuelos vuuelos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vuelo);
        listView = findViewById(R.id.listmostrar);
        adaapter = new adapter(this, vuelosArrayList);
        listView.setAdapter(adaapter);


        retrieveData();


    }
    public void retrieveData(){

        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        try{

                            JSONObject jsonObject = new JSONObject(response);
                            String exito = jsonObject.getString("exito");
                            JSONArray jsonArray = jsonObject.getJSONArray("datos");

                            if(exito.equals("1")){


                                for(int i=0;i<jsonArray.length();i++){

                                    JSONObject object = jsonArray.getJSONObject(i);

                                    String cod_vuelos = object.getString("cod_vuelos");
                                    String destino = object.getString("destino");
                                    String fecha_llegada = object.getString("fecha_llegada");
                                    String fecha_salida = object.getString("fecha_salida");


                                    vuuelos = new vuelos(cod_vuelos,destino,fecha_llegada,fecha_salida);
                                    vuelosArrayList.add(vuuelos);
                                    adaapter.notifyDataSetChanged();



                                }



                            }
                        }
                        catch (JSONException e){
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(vuelo.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);




    }
}
