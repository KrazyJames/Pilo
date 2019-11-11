package mx.itson.hackathon.pilo.interfaces;

import mx.itson.hackathon.pilo.entities.Usuario;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserAPI {

    @POST("login")
    Call<Usuario> login(@Body Usuario usuario);

    @POST("signup")
    Call<Usuario> signup(@Body Usuario usuario);
}
