package com.davidmorales.petagram;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davidmorales.petagram.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas1);
        int numberOfColumns = 3;
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        listaMascotas.setLayoutManager(glm);


        inicializarListaMascotas();
        inicializarAdaptador();


        return v;
    }

    public void inicializarAdaptador(){
        PerfiMascotaAdaptador adaptador = new PerfiMascotaAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.fotohusky,"@string/imgPerfil"));
        mascotas.add(new Mascota(R.drawable.fotohusky,"@string/imgPerfil"));
        mascotas.add(new Mascota(R.drawable.fotohusky,"@string/imgPerfil"));
        mascotas.add(new Mascota(R.drawable.fotohusky,"@string/imgPerfil"));
        mascotas.add(new Mascota(R.drawable.fotohusky,"@string/imgPerfil"));
        mascotas.add(new Mascota(R.drawable.fotohusky,"@string/imgPerfil"));
        mascotas.add(new Mascota(R.drawable.fotohusky,"@string/imgPerfil"));
        mascotas.add(new Mascota(R.drawable.fotohusky,"@string/imgPerfil"));
        mascotas.add(new Mascota(R.drawable.fotohusky,"@string/imgPerfil"));

    }
}
