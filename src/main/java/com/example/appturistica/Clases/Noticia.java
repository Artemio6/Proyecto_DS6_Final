package com.example.appturistica.Clases;

import android.graphics.drawable.Drawable;

public class Noticia {
    private String titulo;
    private String autor;
    private int me_gustas;
    private String detalle;
    private Drawable imagen;
    private Drawable Icono;
    private double latitud;
    private double longitud;

    public Noticia() {

    }

    public Noticia(String titulo, String autor, int me_gustas, String detalle, Drawable imagen, Drawable icono, double latitud, double longitud) {
        this.titulo = titulo;
        this.autor = autor;
        this.me_gustas = me_gustas;
        this.detalle = detalle;
        this.imagen = imagen;
        Icono = icono;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getMe_gustas() {
        return me_gustas;
    }

    public void setMe_gustas(int me_gustas) {
        this.me_gustas = me_gustas;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Drawable getImagen() {
        return imagen;
    }

    public void setImagen(Drawable imagen) {
        this.imagen = imagen;
    }

    public Drawable getIcono() {
        return Icono;
    }

    public void setIcono(Drawable icono) {
        Icono = icono;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
}
