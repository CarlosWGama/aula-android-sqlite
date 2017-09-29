package br.com.carloswgama.sqlite.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import br.com.carloswgama.sqlite.Usuario;

public class UsuarioDAO extends Banco {

    public UsuarioDAO(Context c) {
        super(c);
        tabela = "usuarios";
    }

    public Usuario get(int id) {
        Usuario usuario = null;

        SQLiteDatabase db = getReadableDatabase();
        String valores[] = {String.valueOf(id)};
        Cursor c = db.rawQuery("SELECT nome FROM usuarios" +
                " WHERE id = ?", valores);

        if (c != null && c.moveToFirst()) {
            String nome = c.getString(0);
            usuario = new Usuario(id, nome);
        }

        db.close();

        return usuario;
    }


    public ArrayList<Usuario> getAll() {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

        SQLiteDatabase db = getReadableDatabase();
        String valores[] = {};
        Cursor c = db.rawQuery("SELECT id, nome FROM usuarios", valores);

        if (c != null && c.moveToFirst()) {

            do {
                int id = c.getInt(0);
                String nome = c.getString(1);
                Usuario usuario = new Usuario(id, nome);
                usuarios.add(usuario);
            } while (c.moveToNext());
        }
        db.close();
        return usuarios;
    }

    public void create(Usuario usuario) {
        ContentValues valores = new ContentValues();
        valores.put("nome", usuario.getNome());
        create(valores);
    }

    public void update(Usuario usuario) {
        //String valores[] = {usuario.getNome(), String.valueOf(usuario.getId())};
        //db.execSQL("UPDATE usuarios SET nome = ? WHERE id = ?", valores);
        ContentValues valores = new ContentValues();
        valores.put("nome", usuario.getNome());
        update(valores, usuario.getId());
    }

}
