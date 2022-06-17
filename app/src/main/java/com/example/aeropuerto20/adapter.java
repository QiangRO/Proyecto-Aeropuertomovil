package com.example.aeropuerto20;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.List;

public class adapter extends ArrayAdapter<vuelos> {
    Context context;
    List<vuelos> arrayvuelos;


    public adapter(@NonNull Context context, List<vuelos> arrayvuelos ) {
        super(context, R.layout.lista_vuelos,arrayvuelos);
        this.context=context;
        this.arrayvuelos=arrayvuelos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_vuelos,null, true);
        TextView txtcodigo,txtdestinos, txtllegada, txtsalida;
        txtcodigo = view.findViewById(R.id.txtcodigo);
        txtdestinos = view.findViewById(R.id.txtdestinos);
        txtllegada = view.findViewById(R.id.txtllegada);
        txtsalida = view.findViewById(R.id.txtsalida);
        txtcodigo.setText(arrayvuelos.get(position).getCod_vuelos());
        txtdestinos.setText(arrayvuelos.get(position).getDestino());
        txtllegada.setText(arrayvuelos.get(position).getFecha_llegada());
        txtsalida.setText(arrayvuelos.get(position).getFecha_salida());

        return view;
    }
}

