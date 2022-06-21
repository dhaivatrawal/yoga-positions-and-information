package com.zedr.dhaivat.yogapedia;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class splash extends AppCompatActivity {
    Context ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.zedr.dhaivat.yogapedia.R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                Intent i = new Intent(ctx,MainActivity.class);
                startActivity(i);
                finish();
            }
        },2000);

    }
}
