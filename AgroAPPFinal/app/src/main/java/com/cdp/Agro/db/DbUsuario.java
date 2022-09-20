package com.cdp.Agro.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbUsuario extends DbHelper{
    Context context;

    public DbUsuario(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarUsuario(int id_persona, String email, String usuario, String clave,
                                int id_rol) {
        long id=0;

        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("id_persona", id_persona);
            values.put("email", email);
            values.put("usuario", usuario);
            values.put("clave", clave);
            values.put("id_rol", id_rol);

            id = db.insert(TABLE_USUARIO, null, values);

        } catch (Exception ex) {
            ex.toString();
        }

        return id;
    }
}
