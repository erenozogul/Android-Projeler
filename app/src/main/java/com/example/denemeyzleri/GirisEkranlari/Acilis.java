package com.example.denemeyzleri.GirisEkranlari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.denemeyzleri.Main2Activity;
import com.example.denemeyzleri.Main3Activitykayit;
import com.example.denemeyzleri.MainActivity;
import com.example.denemeyzleri.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Acilis extends AppCompatActivity {

    private Button btnWelcomeLogin , btnWelcomeRegister;

    public void init(){
        btnWelcomeLogin = (Button) findViewById(R.id.btnWlcomeLogin);
        btnWelcomeRegister = (Button) findViewById(R.id.btnWelcomeRegister);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acilis);
        init();
        btnWelcomeLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLogin = new Intent(Acilis.this, Main2Activity.class);
                startActivity(intentLogin);
            }
        });
        btnWelcomeRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRegister = new Intent(Acilis.this, Main3Activitykayit.class);
                startActivity(intentRegister);
            }
        });
    }
}