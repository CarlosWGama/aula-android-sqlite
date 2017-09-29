package br.com.carloswgama.sqlite;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.carloswgama.sqlite.DAO.UsuarioDAO;
import br.com.carloswgama.sqlite.util.UsuarioAdapter;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private UsuarioDAO usuarioDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuarioDAO = new UsuarioDAO(this);

        ListView lista = (ListView) findViewById(R.id.ls_usuarios);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, AtualizarUsuarioActivity.class);
                intent.putExtra("usuarioID", usuarios.get(position).getId());
                //intent.putExtra("usuarioNome", usuarios.get(position).getNome());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizarLista();
    }

    public void adicionar(View v) {
        EditText campoInput = (EditText) findViewById(R.id.et_usuario);
        String texto = campoInput.getText().toString();
        if (!texto.equals("")) {
            usuarioDAO.create(new Usuario(texto));
            atualizarLista();
        }
        campoInput.setText("");
    }

    private void atualizarLista() {
        usuarios = usuarioDAO.getAll();
        ListView lista = (ListView) findViewById(R.id.ls_usuarios);

        UsuarioAdapter adaptador = new UsuarioAdapter(this, usuarios);
        lista.setAdapter(adaptador);

    }
}
