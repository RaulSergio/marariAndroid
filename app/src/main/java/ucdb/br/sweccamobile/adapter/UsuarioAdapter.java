package ucdb.br.sweccamobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ucdb.br.sweccamobile.R;
import ucdb.br.sweccamobile.model.Usuario;

/**
 * Created by drago on 05/10/2017.
 */

public class UsuarioAdapter extends ArrayAdapter<Usuario> {
    private final Context context;
    private final List<Usuario> usuarios;

    public UsuarioAdapter(Context context, ArrayList<Usuario> usuarios){
        super(context, R.layout.linha_list_usuario,usuarios);
        this.context = context;
        this.usuarios = usuarios;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater)context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.linha_list_usuario, parent, false);

        TextView usuario = (TextView)rowView.findViewById(R.id.txtNomeUsuario);
        TextView id = (TextView)rowView.findViewById(R.id.txtIdUsuario);
        TextView perfil = (TextView)rowView.findViewById(R.id.txtPerfilUsuario);

        usuario.setText(usuarios.get(position).getNome());
        id.setText(usuarios.get(position).getId().toString());
        perfil.setText(usuarios.get(position).getPerfil().getDescricao());

        return rowView;

    }

}
