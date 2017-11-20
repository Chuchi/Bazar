package com.sincro.allup;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {


    Button BTN101,BTN102,BTN104 ;

    Handler pop = new Handler();

///// esto es una prueba de carga
    ImageView BTTERM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

           BTN101 = (Button) findViewById(R.id.BTN101);
           BTN102 = (Button) findViewById(R.id.BTN102);
           BTN104 = (Button) findViewById(R.id.BTN104);
           BTN101.setOnClickListener(this);
           BTN104.setOnClickListener(this);
          BTN102.setOnClickListener(this);
         //  BTN103.setOnClickListener(this);

    }


    @Override
    public void onClick(View botoncito) {

        switch (botoncito.getId()) {

            case R.id.BTN101:
                startActivity(new Intent(MainActivity.this, reporte.class));

                break;

            case R.id.BTN102:
                startActivity(new Intent(MainActivity.this, Historicos.class));

                break;

            case R.id.BTN104:
                finish();

                break;

        }
    }
}
