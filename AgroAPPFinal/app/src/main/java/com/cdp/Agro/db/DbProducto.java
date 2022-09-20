package com.cdp.Agro.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;


import com.cdp.Agro.entidades.Producto;

import java.util.ArrayList;

public class DbProducto extends DbHelper{
    Context context;

    public DbProducto(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarProducto(int id_vendedor, String nombre, String categoria, Double precio,
                                String descripcion, int stock, String disponibilidad) {

        long id = 0;

        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("id_vendedor", id_vendedor);
            values.put("nombre", nombre);
            values.put("categoria", categoria);
            values.put("precio", precio);
            values.put("descripcion", descripcion);
            values.put("stock", stock);
            values.put("disponibilidad", disponibilidad);

            id = db.insert(TABLE_PRODUCTO, null, values);

        } catch (Exception ex) {
            ex.toString();
        }

        return id;
    }

    public ArrayList<Producto> mostrarProductos(){

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();


        ArrayList<Producto> listaProductos = new ArrayList<>();
        Producto producto = null;
        Cursor cursorProducto = null;

        cursorProducto = db.rawQuery(" SELECT * FROM " + TABLE_PRODUCTO,null);

        if (cursorProducto.moveToFirst()){
            do{
                producto = new Producto();
                producto.setId(cursorProducto.getInt(0));
                producto.setNombre(cursorProducto.getString(2));
                producto.setCategoria(cursorProducto.getString(3));
                producto.setPrecio(cursorProducto.getString(4));
                producto.setDescripcion(cursorProducto.getString(5));
                producto.setStock (cursorProducto.getString(6));
                producto.setDisponibilidad (cursorProducto.getString(7));

                listaProductos.add(producto);
            } while (cursorProducto.moveToNext());
        }

        cursorProducto.close();

        return listaProductos;

    }




    private boolean getBoolean(int columnIndex) {


        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor cursorProducto = null;

        cursorProducto = db.rawQuery(" SELECT * FROM " + TABLE_PRODUCTO,null);

        if (cursorProducto.isNull(columnIndex) || cursorProducto.getShort(columnIndex) == 0) {
            return false;
        } else {
            return true;
        }
    }


    public Producto verProducto(int id){

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();


        Producto producto = null;
        Cursor cursorProducto;

        cursorProducto = db.rawQuery(" SELECT * FROM " + TABLE_PRODUCTO + " WHERE id = " + id + " LIMIT 1 " ,null);

        if (cursorProducto.moveToFirst()){

                producto = new Producto();
                producto.setId(cursorProducto.getInt(0));
                producto.setNombre(cursorProducto.getString(2));
                producto.setCategoria(cursorProducto.getString(3));
                producto.setPrecio(cursorProducto.getString(4));
                producto.setDescripcion(cursorProducto.getString(5));
                producto.setStock(cursorProducto.getString(6));
                producto.setDisponibilidad (cursorProducto.getString(7));


        }

        cursorProducto.close();

        return producto;

    }



    public Boolean editarProducto(int id_vendedor, String nombre, String categoria, String precio,
                                 String descripcion) {

        Boolean correcto = false;


            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

           try {

               db.execSQL(" UPDATE " + TABLE_PRODUCTO + " SET nombre = '"+nombre+"', categoria = +'"+categoria+"', precio = '"+precio+"', " +
                       " descripcion = '"+descripcion+"' WHERE id = '" +id_vendedor+"' ");
                correcto = true;
           }catch (Exception ex){
               ex.toString();
               correcto = false;
           } finally {
               db.close();
           }


        return correcto;
    }



}
