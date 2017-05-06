package com.anncode.aplicacioncontactos.RestInstagram;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Rafael p on 5/5/2017.
 */

public interface Endpoint {

    @GET(ContantesConsultarInstagram.URLCONSULTA)
    Call<RespuestaObjetoInstagram> consultarFotosRecientes();
}
