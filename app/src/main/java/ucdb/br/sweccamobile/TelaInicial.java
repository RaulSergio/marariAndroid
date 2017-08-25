package ucdb.br.sweccamobile;

import android.content.Intent;
import android.support.annotation.IntDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.R.attr.button;

public class TelaInicial extends AppCompatActivity {

    TextView nomeUser, idUser;
    String nomeUsuario, idUsuario;
    Button botaoClientes, botaoProdutos, botaoPedidos, botaoAtualiza, botaoAjuda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
        getSupportActionBar().setTitle("Home");


        nomeUsuario = getIntent().getExtras().getString("nome");
        idUsuario = getIntent().getExtras().getString("id");

        nomeUser = (TextView)findViewById(R.id.txtUser);
        idUser = (TextView)findViewById(R.id.txtId);
        nomeUser.setText(nomeUsuario);
        idUser.setText(idUsuario);
        botaoClientes = (Button) findViewById(R.id.btnClientes);
        botaoProdutos = (Button) findViewById(R.id.btnProdutos);
        botaoPedidos = (Button) findViewById(R.id.btnPedido);
        botaoAtualiza = (Button) findViewById(R.id.btnAtualiza);
        botaoAjuda = (Button) findViewById(R.id.btnAjuda);

        botaoClientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abreClientes = new Intent(TelaInicial.this, TelaClientes.class);
                startActivity(abreClientes);
            }

            public void OnClick(View v) {

            }
        });

        botaoProdutos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abreProdutos = new Intent(TelaInicial.this, TelaProdutos.class);
                startActivity(abreProdutos);
            }

            public void OnClick(View v) {

            }
        });

        botaoPedidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abrePedidos = new Intent(TelaInicial.this, TelaPedidos.class);
                startActivity(abrePedidos);
            }

            public void OnClick(View v) {

            }
        });

        // botaoAtualiza ???

        botaoAjuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abreAjuda = new Intent(TelaInicial.this, TelaAjuda.class);
                startActivity(abreAjuda);
            }

            public void OnClick(View v) {

            }
        });



    }
}
