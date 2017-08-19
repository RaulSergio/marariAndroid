package ucdb.br.sweccamobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TelaLogin extends AppCompatActivity {

    EditText txtEmail, txtSenha;
    Button btnAcessar, btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
        getSupportActionBar().setTitle("Área de Acesso");

        txtEmail = (EditText) findViewById(R.id.edtTxtEmail);
        txtSenha = (EditText) findViewById(R.id.edtTxtSenha);
        btnAcessar = (Button) findViewById(R.id.btnAcessar);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abreCadastro = new Intent(TelaLogin.this, TelaCadastro.class);
                startActivity(abreCadastro);
            }

            public void OnClick(View v) {

            }
        });


    }
}
