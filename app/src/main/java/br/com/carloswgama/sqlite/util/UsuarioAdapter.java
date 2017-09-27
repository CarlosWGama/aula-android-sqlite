package br.com.carloswgama.sqlite.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.carloswgama.sqlite.R;
import br.com.carloswgama.sqlite.Usuario;


public class UsuarioAdapter extends ArrayAdapter {

    private Context context;
    private ArrayList<Usuario> usuarios;

    public UsuarioAdapter(Context context, ArrayList<Usuario> usuarios) {
        super(context, 0, usuarios);
        this.context = context;
        this.usuarios = usuarios;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.listview_usuarios, parent, false);
        } else {
            v = convertView;
        }

        TextView id = (TextView) v.findViewById(R.id.ls_et_id);
        TextView nome = (TextView) v.findViewById(R.id.ls_et_nome);

        id.setText(String.valueOf(usuarios.get(position).getId()));
        nome.setText(usuarios.get(position).getNome());

        return v;
    }
}
