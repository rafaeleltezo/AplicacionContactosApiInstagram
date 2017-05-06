package com.anncode.aplicacioncontactos.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.anncode.aplicacioncontactos.model.ConstructorContactos;
import com.anncode.aplicacioncontactos.model.Contacto;
import com.anncode.aplicacioncontactos.DetalleContacto;
import com.anncode.recyclerviewfragments.R;


import java.util.ArrayList;

/**
 * Created by anahisalgado on 19/04/16.
 */
public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder>{

    ArrayList<Contacto> contactos;
    Activity activity;

    public ContactoAdaptador(ArrayList<Contacto> contactos, Activity activity) {
        this.contactos= contactos;
        this.activity = activity;
    }

    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto, parent, false);

        return new ContactoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ContactoViewHolder contactoViewHolder, int position) {
        final Contacto contacto = contactos.get(position);
        //contactoViewHolder.imgFoto.setImageResource(contacto.getFoto());
        contactoViewHolder.tvLikes.setText(String.valueOf(contacto.getLikes()) + " " + activity.getString(R.string.likes));
        
        contactoViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(activity, contacto.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, DetalleContacto.class);
                intent.putExtra("foto", contacto.getFoto());
                intent.putExtra("likes",contacto.getLikes());
                activity.startActivity(intent);

            }
        });



    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView tvLikes;

        public ContactoViewHolder(View itemView) {
            super(itemView);

            imgFoto     = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvLikes     = (TextView) itemView.findViewById(R.id.tvLikes);

        }
    }
}
