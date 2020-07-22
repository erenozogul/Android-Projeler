package com.example.denemeyzleri;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Main2Activity extends AppCompatActivity {

    private androidx.appcompat.widget.Toolbar actionbarLogin;
    private EditText txtParola,txtEmail;
    private FirebaseAuth auth;
    private FirebaseUser currentUser;
    private Button GirisYap,sifresizgir;

    public void init()
    {
        actionbarLogin = (Toolbar)findViewById(R.id.actionbarLogin);
        setSupportActionBar(actionbarLogin);
        getSupportActionBar().setTitle("Hesabınızla Giriş Yapınız");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        auth = FirebaseAuth.getInstance();
        currentUser = auth.getCurrentUser();

        GirisYap =(Button)findViewById(R.id.btnLogin);
        txtParola = (EditText) findViewById(R.id.txtPasswordLogin);
        txtEmail = (EditText) findViewById(R.id.txtEmailLogin);
        sifresizgir = (Button)findViewById(R.id.btnLoginsizgiris);

        GirisYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
    }
    private void loginUser() {
        String parola = txtParola.getText().toString();
        String email = txtEmail.getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Email Adresinizi Giriniz!!!", Toast.LENGTH_LONG).show();
        }else if (TextUtils.isEmpty(parola)){
            Toast.makeText(this,"Parolanızı Giriniz!!!", Toast.LENGTH_LONG).show();
        }else {
            auth.signInWithEmailAndPassword(email,parola).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(Main2Activity.this,"Hesabınıza Başarılı Bir Şekilde Giriş Yaptınız",Toast.LENGTH_LONG).show();
                        Intent intentKayit = new Intent(Main2Activity.this, MainActivity.class);
                        startActivity(intentKayit);
                        finish();
                    }else {
                        Toast.makeText(Main2Activity.this,"Giriş Başarısız !!!",Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
        sifresizgir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLogin = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intentLogin);
            }
        });
    }
}
