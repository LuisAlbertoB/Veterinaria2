package com.upchiapas.models;

public class Servicios {
    protected String nombre;
    protected float subTotal;
    protected int cantidad;

    public Servicios(String nombre, float subTotal, int cantiad) {
    }

    public String getNombre() {
        return nombre;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
