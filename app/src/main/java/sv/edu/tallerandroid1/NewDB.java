package sv.edu.tallerandroid1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class NewDB extends SQLiteOpenHelper {
    public NewDB(Context context) {
        super(context, "Inicio.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase dsDB) {
        dsDB.execSQL("create Table registro(nombreusuario Text primary key, contrasena Text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase dsDB, int oldVersion, int newVersion) {
        dsDB.execSQL("drop Table if exists registro");
    }

    public Boolean insertarDatos(String nombreusuario,String contrasena){
        SQLiteDatabase dsDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nombreusuario", nombreusuario);
        contentValues.put("contrasena", contrasena);
        long result = dsDB.insert("registro", null,contentValues);

        if(result == -1){
            return  false;
        }else {
            return true;
        }
    }

    public Boolean verifyNombreUsuario(String nombreusuario){
        SQLiteDatabase dsDB = this.getWritableDatabase();
        Cursor cursor = dsDB.rawQuery("select * from registro where nombreusuario = ?",new String[] {nombreusuario});

        if(cursor.getCount()>0){
            return true;
        }else{
            return false;
        }

    }

    public Boolean verifyContrauser(String nombreusuario,String contrasena){
        SQLiteDatabase dsDB = this.getWritableDatabase();
        Cursor cursor = dsDB.rawQuery("select * from registro where nombreusuario = ? and contrasena =?",new String[]{nombreusuario,contrasena});

        if(cursor.getCount()>0){
            return true;
        }else{
            return false;
        }
    }


}
