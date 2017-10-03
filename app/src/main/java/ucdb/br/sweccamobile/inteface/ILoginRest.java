package ucdb.br.sweccamobile.inteface;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Path;
import ucdb.br.sweccamobile.model.Usuario;

/**
 * Created by drago on 01/10/2017.
 */

public interface ILoginRest {

    @POST("/login")
    Call<Usuario> login(@Path("email") String email, @Path("senha") String senha);

}
