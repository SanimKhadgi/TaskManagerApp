package com.ninjeng.taskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText etpass,etuser;
    Button btnlogin,btnCreateNewUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etpass = findViewById(R.id.passwordLogin);
        etuser=findViewById(R.id.usernameLogin);
        btnlogin= findViewById(R.id.btnlogin);
        btnCreateNewUser= findViewById(R.id.btncreaeteNewUser);
        btnCreateNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SignupActivity.class);
                startActivity(intent);

            }
        });
    }
}
