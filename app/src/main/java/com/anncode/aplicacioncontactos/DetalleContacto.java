package com.anncode.aplicacioncontactos;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.anncode.recyclerviewfragments.R;

/**
 * Created by anahisalgado on 19/04/16.
 */
public class DetalleContacto extends AppCompatActivity {
    private static final String KEY_EXTRA_URL = "url";
    private static final String KEY_EXTRA_LIKE = "like";
    private ImageView imagenPerfil;
    private TextView likes;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        Bundle extras = getIntent().getExtras();
        String foto = extras.getString("foto");
        String likes = extras.getString("likes");


        imagenPerfil=(ImageView)findViewById(R.id.imgFoto);
        this.likes=(TextView)findViewById(R.id.tvLikes);

        this.likes.setText(likes);


    }

}
