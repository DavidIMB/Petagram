package com.davidmorales.petagram;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.Fragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar miActionBar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();

        if(miActionBar!= null) {

            setSupportActionBar(miActionBar);

        }

    }

    private ArrayList<Fragment> agregarFragments(){

        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    public void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_house_dog);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_dog);
    }

    public void irSegundaActividad (View v){
        Intent intent = new Intent(this, ListadoMascotas.class);
        startActivity(intent);
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
}
