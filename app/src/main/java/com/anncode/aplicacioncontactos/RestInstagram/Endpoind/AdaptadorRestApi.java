package com.anncode.aplicacioncontactos.RestInstagram.Endpoind;

import com.anncode.aplicacioncontactos.RestInstagram.ContantesConsultarInstagram;
import com.anncode.aplicacioncontactos.RestInstagram.Endpoint;
import com.anncode.aplicacioncontactos.RestInstagram.RespuestaObjetoInstagram;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rafael p on 5/5/2017.
 */

public class AdaptadorRestApi {

    public Endpoint ConexionRestApi(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(ContantesConsultarInstagram.URLBASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(Endpoint.class);
    }
}
