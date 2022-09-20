package com.cdp.Agro.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.cdp.Agro.entidades.Pedido;

import java.util.ArrayList;
import java.util.Date;

public class DbPedido extends DbHelper {
    Context context;

    public DbPedido(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarPedido(String metodo_pago, Double valor_pagar, int id_comprador, int id_vendedor,
                               Date fecha, String lista_productos) {

        long id = 0;

        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("id_vendedor", id_vendedor);
            values.put("metodo_pago", metodo_pago);
            values.put("valor_pagar", valor_pagar);
            values.put("id_comprador", id_comprador);
            values.put("fecha", String.valueOf(fecha));
            values.put("lista_productos", lista_productos);

            id = db.insert(TABLE_PEDIDO, null, values);

        } catch (Exception ex) {
            ex.toString();
        }

        return id;
    }


    public ArrayList<Pedido> mostrarPedido(){

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();


        ArrayList<Pedido> listaPedido = new ArrayList<>();
        Pedido pedido = null;
        Cursor cursorPedido = null;

        cursorPedido = db.rawQuery(" SELECT * FROM " + TABLE_PEDIDO,null);

        if (cursorPedido.moveToFirst()){
            do{
                pedido = new Pedido();
                pedido.setId(cursorPedido.getLong(0));
                pedido.setMetodoPagos(cursorPedido.getString(1));
                pedido.setValorPagar(cursorPedido.getInt(2));
                pedido.setFechaRegistro(new Date(cursorPedido.getString(5)));
                pedido.setProductos2 (cursorPedido.getString(6));
                listaPedido.add(pedido);
            } while (cursorPedido.moveToNext());
        }

        cursorPedido.close();

        return listaPedido;

    }

}
