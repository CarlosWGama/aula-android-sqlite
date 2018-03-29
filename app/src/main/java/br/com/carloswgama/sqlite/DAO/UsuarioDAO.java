package br.com.carloswgama.sqlite.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import br.com.carloswgama.sqlite.Usuario;

public class UsuarioDAO extends Banco {

    public UsuarioDAO(Context c) {
        super(c);
    }


    /* Busca um Usuário */
    public Usuario get(int id) {
        SQLiteDatabase db = getReadableDatabase();

        String vWhere[] = {String.valueOf(id)};
        Cursor c = db.rawQuery("SELECT nome FROM usuarios WHERE id = ?", vWhere);

        //Não deu erro e encontrou algo
        if (c != null && c.moveToFirst()) {
            String nome = c.getString(0);
            return new Usuario(id, nome);
        }

        return null;
    }

    /* Busca todos Usuário */
    public ArrayList<Usuario> getAll() {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

        SQLiteDatabase db = getReadableDatabase();

        Cursor c = db.rawQuery("SELECT id, nome FROM usuarios", null);

        //Não deu erro e encontrou algo
        if (c != null && c.moveToFirst()) {

            do {
                int id = c.getInt(0);
                String nome = c.getString(1);
                usuarios.add(new Usuario(id, nome));
            } while(c.moveToNext());
        }

        return usuarios;
    }

    /* Cria um Usuário */
    public void create(Usuario usuario) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO usuarios (nome) VALUES ('"+usuario.getNome()+"')");
        db.close();
    }

    /* Atualiza um Usuário */
    public void update(Usuario usuario) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE usuarios SET nome = '"+usuario.getNome()+"' " +
                "WHERE id = '"+usuario.getId()+"'");
        db.close();
    }

    /* Deleta um Usuário */
    public void delete(Usuario usuario) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM usuarios WHERE id = '"+usuario.getId()+"'");
        db.close();
    }
}
