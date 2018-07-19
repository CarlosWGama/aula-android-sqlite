package br.com.carloswgama.sqlite.util;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.carloswgama.sqlite.AtualizarUsuarioActivity;
import br.com.carloswgama.sqlite.R;
import br.com.carloswgama.sqlite.Usuario;

public class UsuarioAdapter extends RecyclerView.Adapter {

    /** VIEW HOLDER **/
    public class UsuarioViewHolder extends RecyclerView.ViewHolder {

        private TextView id;
        private TextView nome;

        public UsuarioViewHolder(final View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.rs_et_id);
            nome = itemView.findViewById(R.id.rs_et_nome);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), AtualizarUsuarioActivity.class);
                    intent.putExtra("usuarioID", usuarios.get(getAdapterPosition()).getId());
                    intent.putExtra("usuarioNome", usuarios.get(getAdapterPosition()).getNome());
                    itemView.getContext().startActivity(intent);
                }
            });
        }

        public TextView getId() {
            return id;
        }

        public TextView getNome() {
            return nome;
        }
    }

    private ArrayList<Usuario> usuarios;

    public UsuarioAdapter(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_usuarios, parent, false);
        return new UsuarioViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((UsuarioViewHolder)holder).getNome().setText(usuarios.get(position).getNome());
        ((UsuarioViewHolder)holder).getId().setText(String.valueOf(usuarios.get(position).getId()));
    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }
}
