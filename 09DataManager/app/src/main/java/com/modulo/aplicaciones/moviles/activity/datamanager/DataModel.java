package com.modulo.aplicaciones.moviles.activity.datamanager;

public class DataModel {
    private String nombre;
    private String mail;
    private int pk;

    public DataModel(){
    }

    public DataModel( String mail, String nombre){
        this.nombre= nombre;
        this.mail = mail;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public DataModel(int pk, String mail, String nombre) {
        this.nombre = nombre;
        this.mail = mail;
        this.pk = pk;
    }

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }
}
