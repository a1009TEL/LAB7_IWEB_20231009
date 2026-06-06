package com.lab6.app.bean;

public class Mascota {
    private String nombre;
    private int edad;
    private float peso;
    private Especie especie;
    private Veterinario veterinario;
    private Dueno dueno;

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public float getPeso() {
        return peso;
    }

    public Especie getEspecie() {
        return especie;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public Dueno getDueno() {
        return dueno;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public void setDueno(Dueno dueno) {
        this.dueno = dueno;
    }
}
