package ucdb.br.sweccamobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ucdb.br.sweccamobile.adapter.UsuarioAdapter;
import ucdb.br.sweccamobile.inteface.IUsuariosRest;
import ucdb.br.sweccamobile.model.Usuario;

import static ucdb.br.sweccamobile.R.id.listaUsuarios;

public class ListaDeUsuarios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_usuarios);

        final ListView lista = (ListView) findViewById(listaUsuarios);
        IUsuariosRest usuariosRest = IUsuariosRest.retrofit
                .create(IUsuariosRest.class);

        final Call<List<Usuario>> call = usuariosRest.getUsuarios();
        call.enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                final List<Usuario> listaUsuarios = response.body();
                if (listaUsuarios != null){
                    UsuarioAdapter adapter = new UsuarioAdapter(getBaseContext(), (ArrayList<Usuario>) listaUsuarios);
                    lista.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {
                Toast.makeText(getBaseContext(), "Problema de acesso",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}