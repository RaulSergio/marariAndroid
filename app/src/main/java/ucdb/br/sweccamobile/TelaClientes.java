package ucdb.br.sweccamobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class TelaClientes extends AppCompatActivity {

    Button botaoBuscaCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_clientes);
        getSupportActionBar().setTitle("Carteira de Clientes");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        botaoBuscaCliente = (Button) findViewById(R.id.btnBuscaCliente);

        botaoBuscaCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abreClientes = new Intent(TelaClientes.this, CarteiraDeClientes.class);
                startActivity(abreClientes);
            }

            public void OnClick(View v) {

            }
        });
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
