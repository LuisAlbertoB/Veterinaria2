package com.upchiapas.models;

public class Consulta extends Servicios {
    private int folio;

    private String especie;

    private byte diaActual;
    private byte mesActual;
    private long añoActual;

    private String diagnostico;
    private String Tratamiento;


    public Consulta(String nombre, float subTotal, int cantiad) {
        super(nombre, subTotal, cantiad);
    }

    public int getFolio() {
        return folio;
    }

    public byte getDia() {
        return diaActual;
    }

    public byte getMes() {
        return mesActual;
    }

    public long getAño() {
        return añoActual;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public String getTratamiento() {
        return Tratamiento;
    }


    public void setFolio(int folio) {
        this.folio = folio;
    }

    public void setDia(byte diaNacimientoAnimal) {
        this.diaActual = diaNacimientoAnimal;
    }

    public void setMes(byte mesNacimintoAnimal) {
        this.mesActual = mesNacimintoAnimal;
    }

    public void setAño(long añoNacimientoAnimal) {
        this.añoActual = añoNacimientoAnimal;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public void setTratamiento(String tratamiento) {
        Tratamiento = tratamiento;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
}
