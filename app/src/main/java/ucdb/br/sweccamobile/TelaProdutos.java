package ucdb.br.sweccamobile;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class TelaProdutos extends AppCompatActivity {
    public static final int REQUEST_CODE = 0;
    private TextView txtResult;

    Button botaoBuscaproduto, botaoEscaneiaCodigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Activity activity = this;
        setContentView(R.layout.activity_tela_produtos);
        getSupportActionBar().setTitle("Produtos");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtResult = (TextView) findViewById(R.id.txtNomeProduto);

        botaoBuscaproduto = (Button) findViewById(R.id.btnBuscaProduto);
        botaoEscaneiaCodigo = (Button) findViewById(R.id.btnScanea);

        botaoBuscaproduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abreProdutos = new Intent(TelaProdutos.this, CarteiraDeProdutos.class);
                startActivity(abreProdutos);
            }

            public void OnClick(View v) {

            }
        });

        botaoEscaneiaCodigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                integrator.setPrompt("Escaneando");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();
            }

            public void OnClick(View v) {

            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "Cancelando Escaneamento", Toast.LENGTH_LONG).show();
            } else {
                //para testar!!
                Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
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
