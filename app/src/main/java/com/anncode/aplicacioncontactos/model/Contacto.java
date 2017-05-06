package com.anncode.aplicacioncontactos.model;

/**
 * Created by anahisalgado on 19/04/16.
 */
public class Contacto {

    private int id;
    private String foto;
    private int likes = 0;

    public Contacto(int id, String foto, int likes) {
        this.id = id;
        this.foto = foto;
        this.likes = likes;
    }

    public Contacto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
