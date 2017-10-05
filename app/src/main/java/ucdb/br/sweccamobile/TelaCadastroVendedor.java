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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ucdb.br.sweccamobile.inteface.IUsuariosRest;
import ucdb.br.sweccamobile.model.Usuario;

public class TelaCadastroVendedor extends AppCompatActivity {

    EditText txtNome, txtEmail, txtSenha, txtConfirmaSenha;
    Button btnRegistrar, btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro_vendedor);
        getSupportActionBar().setTitle("Cadastrar Novo Usuário");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
                final Usuario usuario = new Usuario();
                usuario.setNome(txtNome.getText().toString());
                usuario.setEmail(txtEmail.getText().toString());
                usuario.setSenha(txtSenha.getText().toString());
                String confirmaSenha = txtConfirmaSenha.getText().toString();

                IUsuariosRest usuariosRest = IUsuariosRest.retrofit.create(IUsuariosRest.class);
                final Call<Usuario> call = usuariosRest.cadastraUsuario(usuario);

                if (usuario.getNome().isEmpty() || usuario.getEmail().isEmpty() || usuario.getSenha().isEmpty() || confirmaSenha.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Nenhum campo pode estar vazio!", Toast.LENGTH_LONG).show();
                } else {

                    if (usuario.getSenha().equals(confirmaSenha)) {
                        call.enqueue(new Callback<Usuario>() {
                            @Override
                            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                                int code = response.code();
                                if (code == 200) {
                                    Toast.makeText(getBaseContext(), "Usuário: " +usuario.getNome()+" cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(getBaseContext(), "Erro:"+String.valueOf(code), Toast.LENGTH_SHORT).show();

                                }
                            }

                            @Override
                            public void onFailure(Call<Usuario> call, Throwable t) {
                                Toast.makeText(getBaseContext(), "Não foi possível fazer a conexão", Toast.LENGTH_SHORT).show();
                            }
                        });

                    } else {
                        Toast.makeText(getApplicationContext(), "As senhas não conferem!", Toast.LENGTH_LONG).show();
                    }

                }
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
