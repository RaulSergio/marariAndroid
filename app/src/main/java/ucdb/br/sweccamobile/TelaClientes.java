package ucdb.br.sweccamobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TelaClientes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_clientes);
        getSupportActionBar().setTitle("Carteira de Clientes");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
