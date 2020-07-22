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

import com.example.denemeyzleri.GirisEkranlari.Acilis;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Main3Activitykayit extends AppCompatActivity {

    private androidx.appcompat.widget.Toolbar actionbarLogin;
    private EditText txtKullaniciAdi,txtParola,txtEmail;
    private Button btnKayit;
    private FirebaseAuth auth;

    public void init() {
        actionbarLogin = (Toolbar) findViewById(R.id.actionbarRegister);
        setSupportActionBar(actionbarLogin);
        getSupportActionBar().setTitle("Yeni Kullanıcı Kaydı");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        auth = FirebaseAuth.getInstance();

        txtKullaniciAdi = (EditText) findViewById(R.id.txtUserNameRegister);
        txtParola = (EditText) findViewById(R.id.txtPasswordRegister);
        txtEmail = (EditText) findViewById(R.id.txtEmailRegister);
        btnKayit = (Button) findViewById(R.id.btnRegister);

        btnKayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewAccount();
            }
        });
    }
    private void createNewAccount() {
        String username = txtKullaniciAdi.getText().toString();
        String parola = txtParola.getText().toString();
        String email = txtEmail.getText().toString();

        if (TextUtils.isEmpty(username)) {
            Toast.makeText(this, "Kullanıcı Adı Giriniz!!!", Toast.LENGTH_LONG).show();
        }else if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Email Adresinizi Giriniz!!!", Toast.LENGTH_LONG).show();
        }else if (TextUtils.isEmpty(parola)){
        Toast.makeText(this,"Parolanızı Giriniz!!!", Toast.LENGTH_LONG).show();
        }else {
            auth.createUserWithEmailAndPassword(email,parola).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(Main3Activitykayit.this,"Hesabınız Başarılı Bir Şekilde Oluşturuldu",Toast.LENGTH_LONG).show();
                        Intent intentKayit = new Intent(Main3Activitykayit.this, Main2Activity.class);
                        startActivity(intentKayit);
                        finish();
                    }else {
                        Toast.makeText(Main3Activitykayit.this,"Bir Hata Oluştu !!!",Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3_activitykayit);
        init();
    }
}

