package ucdb.br.sweccamobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ucdb.br.sweccamobile.inteface.IClientesRest;
import ucdb.br.sweccamobile.model.Cliente;

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

        nomeUser = (TextView) findViewById(R.id.txtUser);
        nomeUser.setText(nomeUsuario);
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
        });

        botaoPedidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IClientesRest clientesRest = IClientesRest.retrofit.create(IClientesRest.class);
                // Código para usar retrofit chamando 1 resposta

//                final Call<UsuarioGitHub> call = githubUser.getUsuario("raulsergio");
//                call.enqueue(new Callback<UsuarioGitHub>() {
//                    @Override
//                    public void onResponse(Call<UsuarioGitHub> call, Response<UsuarioGitHub> response) {
//                        int code = response.code();
//                        if (code == 200) {
//                            UsuarioGitHub usuarioGitHub = response.body();
//                            Toast.makeText(getBaseContext(), "Nome do usuário: " + usuarioGitHub.name, Toast.LENGTH_LONG).show();
//                        } else {
//                            Toast.makeText(getBaseContext(), "Falha: " + String.valueOf(code), Toast.LENGTH_LONG).show();
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<UsuarioGitHub> call, Throwable t) {
//                        Toast.makeText(getBaseContext(), t.getMessage(), Toast.LENGTH_LONG).show();
//
//                    }
                final Call<List<Cliente>> call = clientesRest.getClientes();
                call.enqueue(new Callback<List<Cliente>>() {
                    @Override
                    public void onResponse(Call<List<Cliente>> call, Response<List<Cliente>> response) {
                        List<Cliente> listaClientes = response.body();
                        for (Cliente cliente : listaClientes) {
                            Log.d("TelaInicial", cliente.getNomeCliente());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Cliente>> call, Throwable t) {
                    }


//                Intent abrePedidos = new Intent(TelaInicial.this, TelaPedidos.class);
//                startActivity(abrePedidos);

                });


                // botaoAtualiza ???

                botaoAjuda.setOnClickListener(new View.OnClickListener()

                {
                    @Override
                    public void onClick(View v) {
                        Intent abreAjuda = new Intent(TelaInicial.this, TelaAjuda.class);
                        startActivity(abreAjuda);
                    }

                });
            }
        });
    }
}


