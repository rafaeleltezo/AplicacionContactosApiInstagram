package com.anncode.aplicacioncontactos.presentador;

import android.content.Context;
import android.widget.Toast;

import com.anncode.aplicacioncontactos.RestInstagram.ContantesConsultarInstagram;
import com.anncode.aplicacioncontactos.RestInstagram.Endpoind.AdaptadorRestApi;
import com.anncode.aplicacioncontactos.RestInstagram.Endpoint;
import com.anncode.aplicacioncontactos.RestInstagram.RespuestaObjetoInstagram;
import com.anncode.aplicacioncontactos.model.ConstructorContactos;
import com.anncode.aplicacioncontactos.model.Contacto;
import com.anncode.aplicacioncontactos.vista.fragment.IRecyclerViewFragmentView;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by anahisalgado on 21/04/16.
 */
public class RecyclerViewFragmentPresenter implements IRecylerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorContactos constructorContactos;
    private ArrayList<Contacto> contactos;

    public  RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerFotosRecienteInstagram();
        //obtenerContactos();
    }

    @Override
    public void obtenerContactos() {
        constructorContactos = new ConstructorContactos(context);
        contactos = constructorContactos.obtenerDatos();
        mostrarContactosRV();
    }

    @Override
    public void obtenerFotosRecienteInstagram() {
        AdaptadorRestApi adaptadorRestApi=new AdaptadorRestApi();
        Endpoint endpoint=adaptadorRestApi.ConexionRestApi();
        Call<RespuestaObjetoInstagram> respuestaObjetoInstagramCall=endpoint.consultarFotosRecientes();
        respuestaObjetoInstagramCall.enqueue(new Callback<RespuestaObjetoInstagram>() {
            @Override
            public void onResponse(Call<RespuestaObjetoInstagram> call, Response<RespuestaObjetoInstagram> response) {
                Toast.makeText(context,"Conexion Exitosa ",Toast.LENGTH_SHORT).show();
                RespuestaObjetoInstagram respuestaObjetoInstagram=response.body();
                contactos=respuestaObjetoInstagram.getContactos();

            }

            @Override
            public void onFailure(Call<RespuestaObjetoInstagram> call, Throwable t) {
                Toast.makeText(context, "Fallo La conexion con el servidor de instagram", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void mostrarContactosRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(contactos));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
