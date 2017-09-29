package br.com.carloswgama.sqlite.DAO;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.com.carloswgama.sqlite.Usuario;

public abstract class Banco extends SQLiteOpenHelper {

    protected String tabela;

    public Banco(Context c) {
        super(c, "app_teste", null, 1);
    }

    protected void update(ContentValues valores, int id) {
        SQLiteDatabase db = getWritableDatabase();
        String[] whereValores = {String.valueOf(id)};
        db.update(tabela, valores, "id = ?", whereValores);
    }

    public void delete(int id) {
        SQLiteDatabase db = getWritableDatabase();
        String valores[] = {String.valueOf(id)};
        db.delete(tabela, "id = ?", valores);
        db.close();
    }

    public void create(ContentValues valores) {
        SQLiteDatabase db = getWritableDatabase();
        db.insert(tabela, null, valores);
        db.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE usuarios (" +
                "id integer primary key autoincrement," +
                "nome varchar" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
