package ucdb.br.sweccamobile.inteface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import ucdb.br.sweccamobile.model.Usuario;

/**
 * Created by drago on 03/10/2017.
 */

public interface IUsuariosRest {
    @GET("usuarios/todos")
    Call<List<Usuario>> getUsuarios();

    @POST("usuarios/salvar")
    Call<Usuario> cadastraUsuario(@Body Usuario usuario);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.19.172:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
