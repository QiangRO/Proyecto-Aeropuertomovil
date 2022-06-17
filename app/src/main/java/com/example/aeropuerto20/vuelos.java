package com.example.aeropuerto20;

public class vuelos {
    String cod_vuelos, destino,fecha_llegada,fecha_salida;

    public vuelos() {
    }

    public vuelos(String cod_vuelos, String destino, String fecha_llegada, String fecha_salida) {

        this.cod_vuelos = cod_vuelos;
        this.destino = destino;
        this.fecha_llegada = fecha_llegada;
        this.fecha_salida = fecha_salida;
    }

    public String getCod_vuelos() {
        return cod_vuelos;
    }

    public void setCod_vuelos(String cod_vuelos) {
        this.cod_vuelos = cod_vuelos;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getFecha_llegada() {
        return fecha_llegada;
    }

    public void setFecha_llegada(String fecha_llegada) {
        this.fecha_llegada = fecha_llegada;
    }

    public String getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }
}
