package ucdb.br.sweccamobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;

import ucdb.br.sweccamobile.model.Produto;

/**
 * Created by drago on 27/08/2017.
 */

public class ProdutoAdapter extends ArrayAdapter<Produto> {

    private final Context context;
    private final ArrayList<Produto> elementos;
    public double estProd, valorProd;

    public ProdutoAdapter(Context context, ArrayList<Produto> elementos) {
        super (context, R.layout.linha_list_produto, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView  = inflater.inflate(R.layout.linha_list_produto, parent, false);

        TextView txtnomeProduto = (TextView) rowView.findViewById(R.id.txtLinhaProduto1);
        TextView txtcodigoProduto = (TextView) rowView.findViewById(R.id.txtLinhaProduto2);
        TextView txtEstoqueProduto = (TextView) rowView.findViewById(R.id.txtLinhaProduto3);
        TextView nomeProduto = (TextView) rowView.findViewById(R.id.txtNomeProduto);
        TextView codigoProduto = (TextView) rowView.findViewById(R.id.txtCodigoProduto);
        TextView estoqueProduto = (TextView) rowView.findViewById(R.id.txtEstoque);
        TextView txtvalorProduto = (TextView) rowView.findViewById(R.id.txtValor);
        TextView valorProduto = (TextView) rowView.findViewById(R.id.txtPreco);

        nomeProduto.setText(elementos.get(position).getNomeProduto());
        codigoProduto.setText(elementos.get(position).getCodigoProduto());
        estProd = elementos.get(position).getEstoqueProduto();
        String stringDouble = Double.toString(estProd);
        estoqueProduto.setText(stringDouble);
        valorProd = elementos.get(position).getValorProduto();
        NumberFormat formato = NumberFormat.getInstance();
        formato.setMaximumFractionDigits(2);
        formato.setMinimumFractionDigits(2);
        String stringDouble2 = formato.format(valorProd);
        valorProduto.setText(stringDouble2);

        return rowView;
    }
}
