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
import android.widget.Toast;

public class TelaCadastro extends AppCompatActivity {

    EditText txtNome, txtEmail, txtSenha, txtConfirmaSenha;
    Button btnRegistrar, btnCancelar;

    String url = "";
    String parametros = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);
        getSupportActionBar().setTitle("Cadastrar Novo Usuário");

        txtNome = (EditText) findViewById(R.id.txtNomeCadastro);
        txtEmail = (EditText) findViewById(R.id.txtEmailCadastro);
        txtSenha = (EditText) findViewById(R.id.txtSenhaCadastro);
        txtConfirmaSenha = (EditText) findViewById(R.id.txtConfirmaSenhaCadastro);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
        btnCancelar = (Button) findViewById(R.id.btnCancelar);

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConnectivityManager connectivityManager = (ConnectivityManager)
                        getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

                if (networkInfo != null && networkInfo.isConnected()) {

                    String nome = txtNome.getText().toString();
                    String email = txtEmail.getText().toString();
                    String senha = txtSenha.getText().toString();
                    String confirmaSenha = txtConfirmaSenha.getText().toString();


                    if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || confirmaSenha.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Nenhum campo pode estar vazio!", Toast.LENGTH_LONG).show();
                    } else {

                        if (senha.equals(confirmaSenha)) {
                            url = "http://192.168.1.6:80/login/registrar.php";

                            parametros = "nome=" + nome + "&email=" + email + "&senha=" + senha + "&confirmaSenha=" + confirmaSenha;

                            new TelaCadastro.SolicitaDados().execute(url);
                        } else {
                            Toast.makeText(getApplicationContext(), "As senhas não conferem!", Toast.LENGTH_LONG).show();
                        }
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
            txtNome.setText(resultado);
            if (resultado.contains("email_erro")) {
                Toast.makeText(getApplicationContext(), "Já existe um usuário cadastrado para este e-mail!", Toast.LENGTH_LONG).show();

            } else if (resultado.contains("registro_ok")) {
                Toast.makeText(getApplicationContext(), "Registro concluído com sucesso!", Toast.LENGTH_LONG).show();
                Intent abreLogin = new Intent(TelaCadastro.this, TelaLogin.class);
                startActivity(abreLogin);
            } else {
                Toast.makeText(getApplicationContext(), "Ocorreu um erro!", Toast.LENGTH_LONG).show();
            }
        }
    }

}
