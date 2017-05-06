package com.anncode.aplicacioncontactos.RestInstagram;

import com.anncode.aplicacioncontactos.model.Contacto;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Rafael p on 5/5/2017.
 */

public class AdaptadorDeserializadorGson implements JsonDeserializer<RespuestaObjetoInstagram>{

    @Override
    public RespuestaObjetoInstagram deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson=new Gson();
        RespuestaObjetoInstagram respuestaObjetoInstagram=gson.fromJson(json,RespuestaObjetoInstagram.class);
        JsonArray contactoData=json.getAsJsonObject().getAsJsonArray("data");
        respuestaObjetoInstagram.setContactos(deserialiador(contactoData));
        return respuestaObjetoInstagram;
    }
    public ArrayList<Contacto>deserialiador(JsonArray jsonArray){
        ArrayList<Contacto> contactos=new ArrayList<>();
        for (int i=0;i<jsonArray.size();i++){
            Contacto contactoActual=new Contacto();
            JsonObject jsonObjectData=jsonArray.get(i).getAsJsonObject();
            JsonObject jsonObjectUsuario=jsonObjectData.getAsJsonObject("user");
            JsonObject jsonObjectLikes=jsonObjectData.getAsJsonObject("likes");
            JsonObject jsonObjectURlImagen=jsonObjectData.getAsJsonObject("images");
            JsonObject jsonObjectURLImagenResolucion=jsonObjectURlImagen.getAsJsonObject("standard_resolution");
            contactoActual.setId(jsonObjectUsuario.get("id").getAsInt());
            contactoActual.setLikes(jsonObjectLikes.get("count").getAsInt());
            contactoActual.setFoto(jsonObjectURLImagenResolucion.get("url").getAsString());
            contactos.add(contactoActual);
        }
        return contactos;
    }
}
