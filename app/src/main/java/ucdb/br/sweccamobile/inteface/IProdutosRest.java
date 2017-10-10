package ucdb.br.sweccamobile.inteface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import ucdb.br.sweccamobile.model.Produto;

/**
 * Created by drago on 04/10/2017.
 */

public interface IProdutosRest {

    @GET("produto/todos")
    Call<List<Produto>> getProdutos();

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.1.2:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
