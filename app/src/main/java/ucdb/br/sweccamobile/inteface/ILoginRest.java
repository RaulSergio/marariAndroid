package ucdb.br.sweccamobile.inteface;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;
import ucdb.br.sweccamobile.model.Usuario;

/**
 * Created by drago on 01/10/2017.
 */

public interface ILoginRest {

    @FormUrlEncoded
    @POST("/login/")
    Call<Usuario> login(@Field("email") String email, @Field("senha") String senha);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.19.172:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}
