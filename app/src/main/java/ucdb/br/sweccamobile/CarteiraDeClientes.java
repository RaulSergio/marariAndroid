package ucdb.br.sweccamobile;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class CarteiraDeClientes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carteira_de_clientes);

        ListView lista = (ListView)findViewById(R.id.listClientes);
        ArrayAdapter adapter = new ClienteAdapter(this, adicionarClientes());
        lista.setAdapter(adapter);


    }

//    public AdapterView.OnItemClickListener chamaAtividade() {
//        return (new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> av, View v, int position, long id) {
//                Intent it = new Intent(getBaseContext(), DetalhesCliente.class);
//                startActivity(it);
//            }
//        });
//    }

    private ArrayList<Cliente> adicionarClientes() {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        Cliente c = new Cliente("RAUL SERGIO NUNES DE SOUZA", "67 9 9127 8664", "dragolaymann@gmail.com");
        clientes.add(c);
        c = new Cliente("MATHEUS VILVERT", "67 9 9300 7820", "matheusvilvert@gmail.com");
        clientes.add(c);
        c = new Cliente("RINALDO ARAKAKI ROCHA", "67 9 9926 9629", "dinhoarakaki@gmail.com");
        clientes.add(c);

        return (clientes);

    }
}

