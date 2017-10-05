package ucdb.br.sweccamobile;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ucdb.br.sweccamobile.inteface.ILoginRest;
import ucdb.br.sweccamobile.model.Usuario;

public class TelaLogin extends AppCompatActivity {

    EditText txtEmail, txtSenha;
    Button botaoAcessar, botaoRegistrar;

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
                ILoginRest loginRest = ILoginRest.retrofit.create(ILoginRest.class);
                final Call<Usuario> call = loginRest.login(txtEmail.getText().toString(), txtSenha.getText().toString());

                if (txtEmail==null || txtSenha==null) {
                    Toast.makeText(getApplicationContext(), "Nenhum campo pode estar vazio!", Toast.LENGTH_LONG).show();
                } else {
                    call.enqueue(new Callback<Usuario>() {
                        @Override
                        public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                            int code = response.code();
                            if (code == 200) {
                                Intent abreInicio = new Intent(TelaLogin.this, TelaInicial.class);
                                abreInicio.putExtra("nome", response.body().getNome());
                                startActivity(abreInicio);
                            } else {
                                Toast.makeText(getApplicationContext(), "Usuario ou senha incorretos!", Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Usuario> call, Throwable t) {

                        }
                    });
                }
            }

        });

        botaoRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abreCadastro = new Intent(TelaLogin.this, TelaCadastroVendedor.class);
                startActivity(abreCadastro);
            }

            public void OnClick(View v) {

            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
