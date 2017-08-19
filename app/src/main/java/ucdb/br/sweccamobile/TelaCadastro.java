package ucdb.br.sweccamobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TelaCadastro extends AppCompatActivity {

    EditText txtNome, txtEmail, txtSenha, txtConfirmaSenha;
    Button btnRegistrar, btnCancelar;

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
    }

}
