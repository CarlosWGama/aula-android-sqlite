package br.com.carloswgama.sqlite.DAO;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public abstract class Banco {

    private Context context;

    public Banco(Context c) {
        this.context = c;

        SQLiteDatabase db = openConnection();
        db.execSQL("CREATE TABLE IF NOT EXISTS usuarios (" +
                "id integer primary key autoincrement," +
                "nome varchar" +
                ")");
        db.close();
    }

    public SQLiteDatabase openConnection() {
        return this.context.openOrCreateDatabase(
                "app", Context.MODE_PRIVATE, null);
    }
}
