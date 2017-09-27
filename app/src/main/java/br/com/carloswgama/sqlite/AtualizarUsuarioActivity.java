package br.com.carloswgama.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AtualizarUsuarioActivity extends AppCompatActivity {

    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar_usuario);

        EditText campoNome = (EditText) findViewById(R.id.atualizar_et_nome);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int id = extras.getInt("usuarioID");
            String nome = extras.getString("usuarioNome");
            usuario = new Usuario(id, nome);
            if (usuario != null)
                campoNome.setText(usuario.getNome());
        }
    }

    public void atualizarNome(View v) {
        EditText campoNome = (EditText) findViewById(R.id.atualizar_et_nome);
        String nome = campoNome.getText().toString();

        if (!nome.equals("")) {
            Toast.makeText(this, "Usuário Atualizado",Toast.LENGTH_SHORT)
                    .show();
        }
    }

    public void excluirUsuario(View v) {
        Toast.makeText(this, "Usuário excluído",Toast.LENGTH_SHORT)
                .show();
        finish();
    }
}
