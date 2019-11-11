package mx.itson.hackathon.pilo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import mx.itson.hackathon.pilo.entities.Usuario;
import mx.itson.hackathon.pilo.interfaces.UserAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    Retrofit retrofit;

    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //TODO: btnLogin
        btnLogin = findViewById(R.id.btnLogin);
        retrofit = new Retrofit.Builder()
                .baseUrl("http://10.232.14.60/pilo/public/users/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ClickLogin();
    }

    private void ClickLogin() {
        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(final View view){
                //TODO: Obtener datos
                Usuario u = new Usuario(null, "kj", null, "1234", null);
                UserAPI userAPI = retrofit.create(UserAPI.class);
                Call<Usuario> call = userAPI.login(u);
                call.enqueue(new Callback<Usuario>(){
                    @Override
                    public void onResponse(Call<Usuario> call, Response<Usuario> response){
                        System.out.println(response.code());
                        if (response.code()==200){
                            //TODO: Nuevo Intent
                            //Intent intent = new Intent(view.getContext(), DrawerActivity.class);
                            //startActivityForResult(intent, 0);
                            Toast.makeText(getApplicationContext(), "Login Aceptado", Toast.LENGTH_SHORT).show();
                            TextView xd = findViewById(R.id.xdxdxd);
                            xd.setText(response.message().toString());
                        }else{
                            Toast.makeText(getApplicationContext(), "Credenciales rechazadas", Toast.LENGTH_SHORT).show();

                        }
                    }
                    @Override
                    public void onFailure(Call<Usuario> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error en el servidor", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

    }


}



