package ucdb.br.sweccamobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TelaAjuda extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_ajuda);
        getSupportActionBar().setTitle("Ajuda e suporte");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
