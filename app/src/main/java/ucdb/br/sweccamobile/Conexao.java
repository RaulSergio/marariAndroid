package ucdb.br.sweccamobile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

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


    /*URL url;
        HttpURLConnection connection = null;

        try {
            url = new URL(urlUsuario);
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Lenght", "" + Integer.toString(parametroUsuario.getBytes().length));
            connection.setRequestProperty("Content-Language", "pt-BR");

            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(connection.getOutputStream(),"UTF-8");
            outputStreamWriter.write(parametroUsuario);
            outputStreamWriter.flush();

            InputStream inputStream = connection.getInputStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            String linha;
            StringBuffer resposta = new StringBuffer();

            while ((linha = bufferedReader.readLine()) != null) {
                resposta.append(linha);
                resposta.append('\r');
            }
            bufferedReader.close();

            return resposta.toString();

        } catch (Exception erro) {
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }*/