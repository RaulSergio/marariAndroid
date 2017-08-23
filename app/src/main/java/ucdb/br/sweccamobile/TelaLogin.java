package ucdb.br.sweccamobile;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class TelaLogin extends AppCompatActivity {

    EditText txtEmail, txtSenha;
    Button botaoAcessar, botaoRegistrar;

    String url = "";
    String parametros = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
        getSupportActionBar().setTitle("Área de Acesso");

        txtEmail = (EditText) findViewById(R.id.edtTxtEmail);
        txtSenha = (EditText) findViewById(R.id.edtTxtSenha);
        botaoAcessar = (Button) findViewById(R.id.btnAcessar);
        botaoRegistrar = (Button) findViewById(R.id.btnCadastrar);

        botaoAcessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager connectivityManager = (ConnectivityManager)
                        getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

                if (networkInfo != null && networkInfo.isConnected()) {

                    String email = txtEmail.getText().toString();
                    String senha = txtSenha.getText().toString();


                    if (email.isEmpty() || senha.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Nenhum campo pode estar vazio!", Toast.LENGTH_LONG).show();
                    } else {

                        url = "http://192.168.19.237:80/login/logar.php";

                        parametros = "email=" + email + "&senha=" + senha;

                        new SolicitaDados().execute(url);

                    }

                } else {
                    Toast.makeText(getApplicationContext(), "Nenhuma conexão foi detectada!", Toast.LENGTH_LONG).show();
                }


            }

            public void OnClick(View v) {

            }
        });

        botaoRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abreCadastro = new Intent(TelaLogin.this, TelaCadastro.class);
                startActivity(abreCadastro);
            }

            public void OnClick(View v) {

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
            //txtEmail.setText(resultado);
            String[] dados = resultado.split(",");

            if (resultado.contains("login ok")) {
                Intent abreInicio = new Intent(TelaLogin.this, TelaInicial.class);
                abreInicio.putExtra("id", dados[1]);
                abreInicio.putExtra("nome", dados[2]);
                startActivity(abreInicio);
            } else {
                Toast.makeText(getApplicationContext(), "Usuario ou senha incorretos!", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
