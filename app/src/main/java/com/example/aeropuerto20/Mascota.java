package com.example.aeropuerto20;

public class Mascota {
    private int id;
    private String codigo;
    private String nombre;
    private String raza;
    private String peso;
    private String vacuna;
    private String fechaNacimiento;

    public Mascota(int id, String codigo, String nombre, String raza, String peso, String vacuna, String fechaNacimiento) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.raza = raza;
        this.peso = peso;
        this.vacuna = vacuna;
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Datos de Mascota{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", raza='" + raza + '\'' +
                ", peso='" + peso + '\'' +
                ", vacuna='" + vacuna + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getVacuna() {
        return vacuna;
    }

    public void setVacuna(String vacuna) {
        this.vacuna = vacuna;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }



}
