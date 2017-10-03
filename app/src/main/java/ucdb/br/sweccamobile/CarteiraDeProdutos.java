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

import ucdb.br.sweccamobile.model.Produto;

public class CarteiraDeProdutos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carteira_de_produtos);
        getSupportActionBar().setTitle("Carteira de produtos");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListView lista = (ListView) findViewById(R.id.listProdutos);
        ArrayAdapter adapter = new ProdutoAdapter(this, adicionarProdutos());
        lista.setAdapter(adapter);


    }

    public AdapterView.OnItemClickListener chamaDetalhes() {
        return (new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> av, View v, int position, long id) {
                Intent it = new Intent(getBaseContext(), DetalhesProduto.class);
                startActivity(it);
            }
        });
    }

    private ArrayList<Produto> adicionarProdutos() {
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        Produto p = new Produto("ACHOCOLATADO ITALAC 1X03 200ML", "SW-001", 67, 2.69);
        produtos.add(p);
        p = new Produto("ACUCAR CRISTAL ESTRELA 2KG 1X10", "SW-003", 43, 59.90);
        produtos.add(p);
        p = new Produto("CERV BUDWEISER LAGER LONG NECK 343ML CX06", "SW-006", 134, 20.94);
        produtos.add(p);
        p = new Produto("ACHOCOLATADO PRONTO MOCOCA 1X03 200ML", "SW-002", 22, 2.97);
        produtos.add(p);
        p = new Produto("ACUCAR CRISTAL ESTRELA 5KG 1X06", "SW-004", 28, 84.90);
        produtos.add(p);
        p = new Produto("AGUA MINERAL COM GAS SABORAKI 500ML 1X12", "SW-005", 342, 11.88);
        produtos.add(p);

        Collections.sort (produtos, new Comparator() {
            public int compare(Object o1, Object o2) {
                Produto c1 = (Produto) o1;
                Produto c2 = (Produto) o2;
                return c1.getNomeProduto().compareToIgnoreCase(c2.getNomeProduto());
            }
        });

        return (produtos);

    }

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

