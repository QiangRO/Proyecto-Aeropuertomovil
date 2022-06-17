package com.example.aeropuerto20;

public class vuelos {
    private int cod;
    private String destino;
    private String fechasalida;
    private String fechallegada;

    public vuelos(int cod, String destino, String fechasalida, String fechallegada) {
        this.cod = cod;
        this.destino = destino;
        this.fechasalida = fechasalida;
        this.fechallegada = fechallegada;
    }

    @Override
    public String toString() {
        return "Datos de Vuelo{" +
                "cod=" + cod +
                ", destino='" + destino + '\'' +
                ", fechasalida='" + fechasalida + '\'' +
                ", fechallegada='" + fechallegada + '\'' +
                '}';
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getFechasalida() {
        return fechasalida;
    }

    public void setFechasalida(String fechasalida) {
        this.fechasalida = fechasalida;
    }

    public String getFechallegada() {
        return fechallegada;
    }

    public void setFechallegada(String fechallegada) {
        this.fechallegada = fechallegada;
    }
}
