package com.davidmorales.petagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class ListadoMascotas extends AppCompatActivity implements iRecyclerViewFragmentView{

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    Toolbar miActionBar;
    private iRecyclerViewFragmentPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado_mascotas);

        miActionBar = (Toolbar) findViewById(R.id.miActionBar1);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        presenter = new RecyclerViewFragmentPresenter(this,this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.mContacto:
                Intent intent = new Intent(this, ActivityContacto.class);
                startActivity(intent);
                break;

            case R.id.mAbout:
                Intent intent1 = new Intent(this, ActivityAbout.class);
                startActivity(intent1);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}
