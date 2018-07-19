package br.com.carloswgama.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

import br.com.carloswgama.sqlite.util.UsuarioAdapter;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private RecyclerView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuarios.add(new Usuario(1, "carlos"));

        //RecyView
        lista = findViewById(R.id.recycleview_usuarios);
        //Layout Manager
        lista.setLayoutManager(new LinearLayoutManager(this));

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
            usuarios.add(new Usuario(usuarios.size()+1, texto));
            atualizarLista();
        }
        campoInput.setText("");
    }

    private void atualizarLista() {
        UsuarioAdapter adapter = new UsuarioAdapter(usuarios);
        lista.setAdapter(adapter);

    }
}
