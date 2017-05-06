package com.anncode.aplicacioncontactos.RestInstagram;

import com.anncode.aplicacioncontactos.model.Contacto;

import java.util.ArrayList;

/**
 * Created by Rafael p on 5/5/2017.
 */

public class RespuestaObjetoInstagram {
    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }

    ArrayList<Contacto> contactos;
}
