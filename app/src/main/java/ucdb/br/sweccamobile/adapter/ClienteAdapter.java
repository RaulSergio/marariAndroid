package ucdb.br.sweccamobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.ArrayList;

import ucdb.br.sweccamobile.R;
import ucdb.br.sweccamobile.model.Cliente;

/**
 * Created by drago on 26/08/2017.
 */

public class ClienteAdapter extends ArrayAdapter<Cliente> {

    private final Context context;
    private final ArrayList<Cliente> elementos;

    public ClienteAdapter(Context context, ArrayList<Cliente> elementos) {
        super (context, R.layout.linha_list_cliente, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView  = inflater.inflate(R.layout.linha_list_cliente, parent, false);

        TextView nomeCliente = (TextView) rowView.findViewById(R.id.txtLinhaCliente1);
        TextView telefoneCliente = (TextView) rowView.findViewById(R.id.txtLinhaCliente2);
        TextView emailCliente = (TextView) rowView.findViewById(R.id.txtLinhaCliente3);

        nomeCliente.setText(elementos.get(position).getNomeCliente());
        telefoneCliente.setText(elementos.get(position).getTelefoneCliente());
        emailCliente.setText(elementos.get(position).getEmailCliente());

        return rowView;
    }
}
