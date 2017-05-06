package com.anncode.aplicacioncontactos.presentador;

import com.anncode.aplicacioncontactos.RestInstagram.RespuestaObjetoInstagram;

import retrofit2.Retrofit;

/**
 * Created by anahisalgado on 21/04/16.
 */
public interface IRecylerViewFragmentPresenter {

    public void obtenerContactos();

    public void obtenerFotosRecienteInstagram();

    public void mostrarContactosRV();
}
