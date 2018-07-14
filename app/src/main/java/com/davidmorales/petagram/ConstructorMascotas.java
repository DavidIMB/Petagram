package com.davidmorales.petagram;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

public class ConstructorMascotas {

    private static final int LIKE = 1;
    private Context context;

    public ConstructorMascotas(Context context){
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){
        /*ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.perro_1,"Perro 1"));
        mascotas.add(new Mascota(R.drawable.perro_2,"Perro 2"));
        mascotas.add(new Mascota(R.drawable.perro_3,"Perro 3"));
        mascotas.add(new Mascota(R.drawable.perro_4,"Perro 4"));
        mascotas.add(new Mascota(R.drawable.perro_5,"Perro 5"));
        return mascotas; */

        BaseDatos db = new BaseDatos(context);
        insertarMascotas(db);
        return db.obtenerTodasLasMascotas();
    }

    public void insertarMascotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Perro 1");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOtO, R.drawable.perro_1);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Perro 2");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOtO, R.drawable.perro_2);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Perro 3");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOtO, R.drawable.perro_3);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Perro 4");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOtO, R.drawable.perro_4);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Perro 5");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOtO, R.drawable.perro_5);

        db.insertarMascota(contentValues);
    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_NUMERO_LIKES, LIKE);
        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return  db.obtenerLikesMascota(mascota);
    }
}
