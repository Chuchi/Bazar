package com.sincro.allup;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class Iniciamox extends AppCompatActivity implements View.OnClickListener {


    Button BTNX1;
    EditText ETX1,ETX2;

    SharedPreferences amadas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iniciamox);
        BTNX1 = (Button) findViewById(R.id.BTNX1);
        ETX1 = (EditText) findViewById(R.id.ETX1);
        ETX2 = (EditText) findViewById(R.id.ETX2);


        String camino = "Verno/Roboto-Light.ttf";


        Typeface TF = Typeface.createFromAsset(getAssets(), camino);


        ETX1.setTypeface(TF);
        ETX2.setTypeface(TF);
        BTNX1.setOnClickListener(this);
        ETX1.requestFocus();

    }

    @Override
    public void onClick(View view) {

        BTNX1.setVisibility(View.INVISIBLE);

        if((ETX1.getText().toString().equals("baruni") && ETX2.getText().toString().equals("baruni1")) || (ETX1.getText().toString().equals("rapaza") && ETX2.getText().toString().equals("rapaza1"))  || (ETX1.getText().toString().equals("ggarcia") && ETX2.getText().toString().equals("ggarcia1"))  || (ETX1.getText().toString().equals("marenas") && ETX2.getText().toString().equals("marenas1")) || (ETX1.getText().toString().equals("cocox") && ETX2.getText().toString().equals("cocox1")) ){
            Toast.makeText(Iniciamox.this, "Bienvenido. Login Correcto", Toast.LENGTH_LONG).show();
            Iniciamox.this.finish();

            amadas= PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editorial = amadas.edit();
            editorial.putString(getResources().getString(R.string.Usuar),ETX1.getText().toString());
            Random javier;
            javier=new Random();

            editorial.putInt("Contador", javier.nextInt(100));
            editorial.apply();
        }else{
            Toast.makeText(Iniciamox.this, "Login Incorrecto. Favor, Salir de la Aplicacion e intentarlo de nuevo", Toast.LENGTH_LONG).show();
            Iniciamox.this.finish();

        }
    }












}