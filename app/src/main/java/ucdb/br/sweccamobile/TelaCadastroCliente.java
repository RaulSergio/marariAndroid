package ucdb.br.sweccamobile;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TelaCadastroCliente extends AppCompatActivity {

    EditText txtNome, txtTelefone, txtCpfCnpj, txtEmail, txtEndereco, txtNumero, txtCidade, txtObs;
    Button btnCadastrar;

    String url = "";
    String parametros = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro_cliente);
        getSupportActionBar().setTitle("Cadastro de clientes");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtNome = (EditText) findViewById(R.id.edtTxtNomeCadastroCliente);
        txtTelefone = (EditText) findViewById(R.id.edtTxtTelefoneCadastroCliente);
        txtCpfCnpj = (EditText) findViewById(R.id.edtTxtCpfCnpjCadastroCliente);
        txtEmail = (EditText) findViewById(R.id.edtTxtEmailCadastroCliente);
        txtEndereco = (EditText) findViewById(R.id.edtTxtEnderecoCadastroCliente);
        txtNumero = (EditText) findViewById(R.id.edtTxtNumeroCadastroCliente);
        txtCidade = (EditText) findViewById(R.id.edtTxtCidadeCadastroCliente);
        txtObs = (EditText) findViewById(R.id.edtTxtObsCadastro);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrarCliente);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConnectivityManager connectivityManager = (ConnectivityManager)
                        getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

                if (networkInfo != null && networkInfo.isConnected()) {

                    String nome = txtNome.getText().toString();
                    String telefone = txtTelefone.getText().toString();
                    String cpfCnpj = txtCpfCnpj.getText().toString();
                    String email = txtEmail.getText().toString();
                    String endereco = txtEmail.getText().toString();
                    String numero = txtNumero.getText().toString();
                    String cidade = txtCidade.getText().toString();
                    String obs = txtObs.getText().toString();


                    if (nome.isEmpty() || telefone.isEmpty() || cpfCnpj.isEmpty() || email.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Alguns campos são obrigatórios!", Toast.LENGTH_LONG).show();
                    } else {
                        //criar a classe de cadastro de clientes
                        url = "http://192.168.1.8:80/login/cadastroCliente.php";

                        parametros = "nome=" + nome + "&telefone=" + telefone + "&cpfCnpj=" + cpfCnpj + "&email=" + email +
                                "&endereco=" + endereco + "&numero=" + numero + "&cidade=" + cidade + "&obs=" + obs;

                        new TelaCadastroCliente.SolicitaDados().execute(url);
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "Nenhuma conexão foi detectada!", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private class SolicitaDados extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            return Conexao.postDados(urls[0], parametros);
        }

        @Override
        protected void onPostExecute(String resultado) {
            //criar condicao na classe de cadastro de clientes
            if (resultado.contains("cpf/cnpj_erro")) {
                Toast.makeText(getApplicationContext(), "Já existe um cliente cadastrado para este CPF/CNPJ!", Toast.LENGTH_LONG).show();

            } else if (resultado.contains("registro_ok")) {
                Toast.makeText(getApplicationContext(), "Cliente cadastrado com sucesso!", Toast.LENGTH_LONG).show();
                Intent abreClientes = new Intent(TelaCadastroCliente.this, TelaClientes.class);
                startActivity(abreClientes);
            } else {
                Toast.makeText(getApplicationContext(), "Ocorreu um erro!", Toast.LENGTH_LONG).show();
            }
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
