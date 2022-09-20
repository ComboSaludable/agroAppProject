package com.cdp.Agro.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.util.Date;

public class DbPersona extends DbHelper {

    Context context;

    public DbPersona(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarPersona(String nombres, String apellidos, Date fecha_nacimiento, String celular,
                                String identificacion, String ubicacion) {
       long id=0;

        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombres", nombres);
            values.put("apellidos", apellidos);
            values.put("fecha_nacimiento", String.valueOf(fecha_nacimiento));
            values.put("identificacion", identificacion);
            values.put("celular", celular);
            values.put("ubicacion", ubicacion);

            id = db.insert(TABLE_PERSONA, null, values);

        } catch (Exception ex) {
            ex.toString();
        }

        return id;
    }


}
