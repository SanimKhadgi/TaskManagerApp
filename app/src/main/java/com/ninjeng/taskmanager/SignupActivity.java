package com.ninjeng.taskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.ninjeng.taskmanager.RetrofitClinet.baseUrl;

public class SignupActivity extends AppCompatActivity {
    EditText etfirstname, etlastname,etusername,etpassword;
    ImageView imgProfile;
    Button btnsignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        etfirstname=findViewById(R.id.firstname);
        etlastname=findViewById(R.id.lastname);
        etusername=findViewById(R.id.Username);
        etpassword=findViewById(R.id.Password);
        btnsignup=findViewById(R.id.btnSingup);
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstname = etfirstname.getText().toString();
                String lastname = etlastname.getText().toString();
                String username = etusername.getText().toString();
                String password = etpassword.getText().toString();
                User user = new User(firstname,lastname,username,password);
                Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
                Api api = retrofit.create(Api.class);
                Call<Void> userCall = api.addEmployee(user);
                userCall.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Toast.makeText(SignupActivity.this, "User created Sucessfully", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(SignupActivity.this, "Error: "+ t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
    }
}
