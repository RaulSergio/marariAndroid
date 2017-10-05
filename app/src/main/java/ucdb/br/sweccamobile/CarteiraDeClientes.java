package ucdb.br.sweccamobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import ucdb.br.sweccamobile.model.Cliente;

public class CarteiraDeClientes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carteira_de_clientes);
        getSupportActionBar().setTitle("Carteira de clientes");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        ListView lista = (ListView) findViewById(R.id.listClientes);
//        ArrayAdapter adapter = new ClienteAdapter(this, adicionarClientes());
//        lista.setAdapter(adapter);


    }

    public AdapterView.OnItemClickListener chamaDetalhes() {
        return (new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> av, View v, int position, long id) {
                Intent it = new Intent(getBaseContext(), DetalhesCliente.class);
                startActivity(it);
            }
        });
    }

//    private ArrayList<Cliente> adicionarClientes() {
//        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
//        Cliente c = new Cliente("RAUL SERGIO NUNES DE SOUZA", "67 9 9127 8664", "dragolaymann@gmail.com");
//        clientes.add(c);
//        c = new Cliente("MATHEUS VILVERT", "67 9 9300 7820", "matheusvilvert@gmail.com");
//        clientes.add(c);
//        c = new Cliente("RINALDO ARAKAKI ROCHA", "67 9 9926 9629", "dinhoarakaki@gmail.com");
//        clientes.add(c);
//        c = new Cliente("GIANCARLO ESPINOSA", "67 9 1234 5678", "gispinosa@gmail.com");
//        clientes.add(c);
//        c = new Cliente("JHONATAN GREY", "67 9 8765 4321", "jgrey@gmail.com");
//        clientes.add(c);
//        c = new Cliente("ALEX MONTGOMERY", "67 9 2234 8876", "amonty@gmail.com");
//        clientes.add(c);
//        c = new Cliente("GEBBER WARTZOLIT", "67 9 1236 4356", "gwaw@gmail.com");
//        clientes.add(c);
//        c = new Cliente("KAREV SWISS", "67 9 1534 7907", "swiss_krev@gmail.com");
//        clientes.add(c);
//        c = new Cliente("LAVSDALA MATCHIENKO", "67 9 1233 9987", "motherrussia@gmail.com");
//        clientes.add(c);
//        c = new Cliente("NULL POINTER EXCEPTION", "67 9 2134 8765", "npexc@gmail.com");
//        clientes.add(c);
//
//
//        Collections.sort (clientes, new Comparator() {
//            public int compare(Object o1, Object o2) {
//                Cliente c1 = (Cliente) o1;
//                Cliente c2 = (Cliente) o2;
//                return c1.getNomeCliente().compareToIgnoreCase(c2.getNomeCliente());
//            }
//        });
//
//        return (clientes);
//
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}

