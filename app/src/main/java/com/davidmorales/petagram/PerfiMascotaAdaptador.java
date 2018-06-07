package com.davidmorales.petagram;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PerfiMascotaAdaptador extends  RecyclerView.Adapter<PerfiMascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;

    public PerfiMascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public PerfiMascotaAdaptador.MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil, parent, false);
        return new PerfiMascotaAdaptador.MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFotoCV.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvCalificacionCV.setText(String.valueOf(mascota.getCalificacion()));

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFotoCV;
        private ImageView imgHuesoAmarilloCV;
        private TextView tvCalificacionCV;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFotoCV           = (ImageView) itemView.findViewById(R.id.imgFotoPerfil);
            imgHuesoAmarilloCV  = (ImageView) itemView.findViewById(R.id.imgHuesoAmarilloPerfil);
            tvCalificacionCV    = (TextView) itemView.findViewById(R.id.tvCalificacionPerfil);
        }
    }
}
