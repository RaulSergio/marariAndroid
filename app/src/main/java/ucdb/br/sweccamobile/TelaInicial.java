package ucdb.br.sweccamobile;

import android.content.Intent;
import android.support.annotation.IntDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TelaInicial extends AppCompatActivity {

    TextView nomeUser, idUser;
    String nomeUsuario, idUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
        getSupportActionBar().setTitle("Home");

        nomeUser = (TextView)findViewById(R.id.txtUser);
        idUser = (TextView)findViewById(R.id.txtId);

        nomeUsuario = getIntent().getExtras().getString("nome");
        idUsuario = getIntent().getExtras().getString("id");

        nomeUser.setText(nomeUsuario);
        idUser.setText(idUsuario);

    }
}
