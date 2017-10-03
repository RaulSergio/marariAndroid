package ucdb.br.sweccamobile.inteface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import ucdb.br.sweccamobile.model.Cliente;

/**
 * Created by drago on 02/10/2017.
 */

public interface IClientesRest {

    @GET("clientes/todos")
    Call<List<Cliente>> getClientes();

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.1.13/marari/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
