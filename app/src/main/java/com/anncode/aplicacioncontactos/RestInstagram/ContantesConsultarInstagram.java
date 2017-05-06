package com.anncode.aplicacioncontactos.RestInstagram;

/**
 * Created by Rafael p on 5/5/2017.
 */

public class ContantesConsultarInstagram {
    public static final String URL="https://api.instagram.com/";
    public static final String VERSION="v1";
    public static final String URLBASE="https://api.instagram.com/"+VERSION;
    public static final String CONSULTA="/users/self/media/recent/?access_token=";
    public static final String TOKEN="1041594776.a671e79.260048636a4746c88b6382d53576aec1";
    public static final String URLCONSULTA=URLBASE+CONSULTA+TOKEN;
}
