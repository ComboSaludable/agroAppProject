package com.cdp.Agro.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 4;
    private static final String DATABASE_NOMBRE = "Agro.db";
    public static final String TABLE_CONTACTOS = "t_contactos";
    public static String TABLE_PERSONA = "t_persona";
    public static String TABLE_PEDIDO = "t_pedido";
    public static String TABLE_PRODUCTO = "t_producto";
    public static String TABLE_USUARIO = "t_usuario";
    public static String TABLE_CALIFICACION = "t_calificacion";


    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_CONTACTOS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "telefono TEXT NOT NULL," +
                "correo_electronico TEXT)");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_PERSONA + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombres TEXT NOT NULL," +
                "apellidos TEXT NOT NULL," +
                "fecha_nacimiento DATE NOT NULL," +
                "celular TEXT NOT NULL," +
                "identificacion TEXT NOT NULL," +
                "ubicacion TEXT NOT NULL)");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_USUARIO + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "id_persona INTEGER NOT NULL," +
                "email TEXT NOT NULL," +
                "usuario TEXT NOT NULL," +
                "clave TEXT NOT NULL," +
                "id_rol INTEGER NOT NULL," +
                "FOREIGN KEY(id_persona) REFERENCES TABLE_PERSONA (id))");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_CALIFICACION + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "id_persona_calificadora INTEGER NOT NULL," +
                "id_persona_calificada INTEGER NOT NULL," +
                "valor INTEGER NOT NULL," +
                "FOREIGN KEY(id_persona_calificadora) REFERENCES TABLE_USUARIO (id)," +
                "FOREIGN KEY(id_persona_calificada) REFERENCES TABLE_USUARIO (id))");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_PRODUCTO + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "id_vendedor INTEGER NOT NULL," +
                "nombre TEXT NOT NULL," +
                "categoria TEXT NOT NULL," +
                "precio REAL NOT NULL," +
                "descripcion TEXT NOT NULL," +
                "stock INTEGER NOT NULL," +
                "disponibilidad INTEGER NOT NULL," +
                "FOREIGN KEY(id_vendedor) REFERENCES TABLE_USUARIO (id))");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_PEDIDO + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "metodo_pago TEXT NOT NULL," +
                "valor_pagar REAL NOT NULL," +
                "id_comprador INTEGER NOT NULL," +
                "id_vendedor INTEGER NOT NULL," +
                "fecha DATE NOT NULL," +
                "productos TEXT NOT NULL," +
                "FOREIGN KEY(id_comprador) REFERENCES TABLE_USUARIO (id)," +
                "FOREIGN KEY(id_vendedor) REFERENCES TABLE_USUARIO (id))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_CONTACTOS);
        sqLiteDatabase.execSQL("DROP TABLE "+TABLE_PERSONA);
        sqLiteDatabase.execSQL("DROP TABLE "+TABLE_USUARIO);
        sqLiteDatabase.execSQL("DROP TABLE "+TABLE_CALIFICACION);
        sqLiteDatabase.execSQL("DROP TABLE "+TABLE_PRODUCTO);
        sqLiteDatabase.execSQL("DROP TABLE "+TABLE_PEDIDO);
        onCreate(sqLiteDatabase);

    }
}
