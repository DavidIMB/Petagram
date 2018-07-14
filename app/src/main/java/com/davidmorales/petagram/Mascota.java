package com.davidmorales.petagram;

public class Mascota {

    private int id;
    private String nombre;
    private int foto;
    private int calificacion = 0;

    public Mascota(int foto, String nombre){
        this.foto = foto;
        this.nombre = nombre;
    }

    public Mascota() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
