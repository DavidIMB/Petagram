package com.davidmorales.petagram;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MascotaAdaptador extends  RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFotoCV.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.tvCalificacionCV.setText(String.valueOf(mascota.getCalificacion()));

        MascotaViewHolder.imgHuesoBlancoCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mascota.setCalificacion(mascota.getCalificacion()+1);
                Toast.makeText(activity, "Diste like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
                mascotaViewHolder.tvCalificacionCV.setText(String.valueOf(mascota.getCalificacion()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends ViewHolder {

        private ImageView imgFotoCV;
        private static ImageView imgHuesoBlancoCV;
        private ImageView imgHuesoAmarilloCV;
        private TextView tvNombreCV;
        private TextView tvCalificacionCV;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFotoCV           = (ImageView) itemView.findViewById(R.id.imgFoto);
            imgHuesoBlancoCV    = (ImageView) itemView.findViewById(R.id.imgHuesoBlanco);
            imgHuesoAmarilloCV  = (ImageView) itemView.findViewById(R.id.imgHuesoAmarillo);
            tvNombreCV          = (TextView) itemView.findViewById(R.id.tvNombre);
            tvCalificacionCV    = (TextView) itemView.findViewById(R.id.tvCalificacion);
        }
    }
}
