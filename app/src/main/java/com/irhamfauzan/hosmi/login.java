package com.irhamfauzan.hosmi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void signUp(View view){
        Intent intent = new Intent(getApplicationContext(), registrasi.class);
        startActivity(intent);
    }
}
