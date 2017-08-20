package ucdb.br.sweccamobile;


import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by drago on 19/08/2017.
 */

public class Conexao {

    public static String postDados(String urlUsuario, String parametroUsuario) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request.Builder builder = new Request.Builder();

        builder.url(urlUsuario);

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded; charset=UTF-8");

        RequestBody body = RequestBody.create(mediaType, parametroUsuario);

        builder.post(body);

        Request request = builder.build();

        try {
            Response response = okHttpClient.newCall(request).execute();

            return response.body().string();
        } catch (Exception erro) {
            return null;
        }

    }
}
