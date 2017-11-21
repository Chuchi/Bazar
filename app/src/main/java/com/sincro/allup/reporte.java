package com.sincro.allup;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class reporte extends AppCompatActivity  implements AdapterView.OnItemSelectedListener ,View.OnClickListener{

    private static final int ACTIVITY_SELECT_IMAGE = 1020;
    TextView TXV11, TXV13, TXV14, TXV15, TXV16,TXV17 , TXV20, TXXXX;
    Button BTN22,BTN33;
    EditText EDT1;
    ImageButton BTNCAMERA1 , BTNCAMERA2, BTNCAMERA3 , BTNCAMERA4;
    ImageView BeloAzul;
    ProgressBar progress;
    Spinner SPNN11, SPNN12,SPNN13, SPNN14;
    ArrayAdapter<String> Colores, Estaciones, Secciones , Areas, Nada;
    Intent pez;
    int Toma1 =258;
    int Toma2=365;
    int Arch1 =33;
    int Arch2=35;
    Bitmap bmppp;
    SharedPreferences ansiadas;
    private Handler carlo = new Handler();
    private Handler tomate = new Handler();
    private Uri imaginax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reporta);

        ansiadas = PreferenceManager.getDefaultSharedPreferences(this);


        TXV11 = (TextView) findViewById(R.id.TXV11);
        TXV13 = (TextView) findViewById(R.id.TXV13);
        TXV14 = (TextView) findViewById(R.id.TXV14);
        TXV15 = (TextView) findViewById(R.id.TXV15);
        TXV16 = (TextView) findViewById(R.id.TXV16);
        TXV20 = (TextView) findViewById(R.id.TXV20);
        EDT1 = (EditText) findViewById(R.id.EDT1);
        SPNN11=(Spinner) findViewById(R.id.SPNN11) ;
        SPNN12=(Spinner) findViewById(R.id.SPNN12) ;
        SPNN13=(Spinner) findViewById(R.id.SPNN13) ;
        SPNN14=(Spinner) findViewById(R.id.SPNN14) ;
        BTNCAMERA1=(ImageButton) findViewById(R.id.BTNCAMERA1) ;
        BTNCAMERA2=(ImageButton) findViewById(R.id.BTNCAMERA2) ;
        BTNCAMERA3=(ImageButton) findViewById(R.id.BTNCAMERA3) ;
        BTNCAMERA4=(ImageButton) findViewById(R.id.BTNCAMERA4) ;
        BTN22 = (Button) findViewById(R.id.BTN22);
        BTN33 = (Button) findViewById(R.id.BTN33);
        BeloAzul=(ImageView)findViewById(R.id.BeloAzul);
        progress=(ProgressBar)findViewById(R.id.progress);

        if (ansiadas.getString(getResources().getString(R.string.Usuar), "").equals("baruni")) { TXV11.setText("Benedicto Aruni");}
        if (ansiadas.getString(getResources().getString(R.string.Usuar), "").equals("rapaza")) { TXV11.setText("Ruben Apaza");}
        if (ansiadas.getString(getResources().getString(R.string.Usuar), "").equals("ggarcia")) { TXV11.setText("Guido Garcia");}
        if (ansiadas.getString(getResources().getString(R.string.Usuar), "").equals("marenas")) { TXV11.setText("Miguel Arenas");}

        int contando= ansiadas.getInt("Contador", 58);
        TXV20.setText(String.valueOf(contando));
        contando ++;
        SharedPreferences.Editor editorial = ansiadas.edit();

         editorial.putInt("Contador",contando);
        editorial.apply();


        BTNCAMERA1.setOnClickListener(this);
        BTNCAMERA2.setOnClickListener(this);

        BTN22.setOnClickListener(this);
        BTN33.setOnClickListener(this);

        SPNN11.setOnItemSelectedListener( this);
        SPNN12.setOnItemSelectedListener( this);

        Colores = new ArrayAdapter<String>(this,R.layout.stilotexto,getResources().getStringArray(R.array.ColoresLineas));
        Secciones = new ArrayAdapter<String>(this,R.layout.stilotexto,getResources().getStringArray(R.array.Secciones));
        Areas = new ArrayAdapter<String>(this,R.layout.stilotexto,getResources().getStringArray(R.array.Areas));
        Nada = new ArrayAdapter<String>(this,R.layout.stilotexto,getResources().getStringArray(R.array.Nadita));


        SPNN11.setAdapter(Colores);
        SPNN13.setAdapter(Secciones);
        SPNN14.setAdapter(Areas);

        SPNN12.setAdapter(Nada);
        SPNN11.setSelection(11);
        SPNN13.setSelection(2);
        SPNN14.setSelection(18);

        String wayy = "Verno/Roboto-Light.ttf";
        String mina = "Verno/Roboto-BoldItalic.ttf";

        Typeface TF = Typeface.createFromAsset(getAssets(),wayy);
        Typeface TF2 = Typeface.createFromAsset(getAssets(),mina);

       TXV11.setTypeface(TF);
        TXV20.setTypeface(TF2);
        SPNN11.requestFocus();
/*
        // Check if Android M or higher
        if (android.os.Build.VERSION.SDK_INT >= 23) {   //Android M Or Over
            if (!Settings.canDrawOverlays(this)) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + getPackageName()));
                startActivity(intent);
                return;
            }}
*/
        checkCameraPermission();

        BTNCAMERA3.setAlpha(0.2f);
        BTNCAMERA3.setPadding(30,30,30,30);
        BTNCAMERA4.setAlpha(0.2f);
        BTNCAMERA4.setPadding(30,30,30,30);



    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (adapterView.getId()){
            case R.id.SPNN11:

                int orden = SPNN11.getSelectedItemPosition();

                switch (orden){
                    case 0:
                        Estaciones = new ArrayAdapter<String>(this,R.layout.stilotexto,getResources().getStringArray(R.array.EstacionesRoja));
                       // SPNN12.setVisibility(View.VISIBLE);
                        SPNN12.setAdapter(Estaciones);
                        TXV13.setTextColor(getResources().getColor(R.color.Rojo));


                    break;
                    case 1:
                        Estaciones = new ArrayAdapter<String>(this,R.layout.stilotexto,getResources().getStringArray(R.array.EstacionesVerde));
                        //SPNN12.setVisibility(View.VISIBLE);
                        SPNN12.setAdapter(Estaciones);
                       TXV13.setTextColor(getResources().getColor(R.color.Verde));
                    break;
                    case 2:
                        Estaciones = new ArrayAdapter<String>(this,R.layout.stilotexto,getResources().getStringArray(R.array.EstacionesAzul));
                        //SPNN12.setVisibility(View.VISIBLE);
                        SPNN12.setAdapter(Estaciones);
                        TXV13.setTextColor(getResources().getColor(R.color.Azulon));
                    break;
                    case 3:
                        Estaciones = new ArrayAdapter<String>(this,R.layout.stilotexto,getResources().getStringArray(R.array.EstacionesAmarilla));
                       // SPNN12.setVisibility(View.VISIBLE);
                        SPNN12.setAdapter(Estaciones);
                        TXV13.setTextColor(getResources().getColor(R.color.Amarillo));
                    break;
                    case 4:
                        Estaciones = new ArrayAdapter<String>(this,R.layout.stilotexto,getResources().getStringArray(R.array.EstacionesNaranja));
                       // SPNN12.setVisibility(View.VISIBLE);
                        SPNN12.setAdapter(Estaciones);
                        TXV13.setTextColor(getResources().getColor(R.color.NaranjaNormal));
                    break;
                    case 5:
                        Estaciones = new ArrayAdapter<String>(this,R.layout.stilotexto,getResources().getStringArray(R.array.EstacionesBlanca));
                      //  SPNN12.setVisibility(View.VISIBLE);
                        SPNN12.setAdapter(Estaciones);
                        TXV13.setTextColor(Color.WHITE);

                    break;
                    case 6:
                        Estaciones = new ArrayAdapter<String>(this,R.layout.stilotexto,getResources().getStringArray(R.array.EstacionesCeleste));
                      //  SPNN12.setVisibility(View.VISIBLE);
                        SPNN12.setAdapter(Estaciones);
                        TXV13.setTextColor(getResources().getColor(R.color.Celeste));
                    break;
                    case 7:
                        Estaciones = new ArrayAdapter<String>(this,R.layout.stilotexto,getResources().getStringArray(R.array.EstacionesMorada));
                        //SPNN12.setVisibility(View.VISIBLE);
                        SPNN12.setAdapter(Estaciones);
                        TXV13.setTextColor(getResources().getColor(R.color.Morado));


                    break;
                    case 8:
                        Estaciones = new ArrayAdapter<String>(this,R.layout.stilotexto,getResources().getStringArray(R.array.EstacionesPlateada));
                        //SPNN12.setVisibility(View.VISIBLE);
                        SPNN12.setAdapter(Estaciones);
                        TXV13.setTextColor(Color.WHITE);


                        break;

                    case 9:
                        Estaciones = new ArrayAdapter<String>(this,R.layout.stilotexto,getResources().getStringArray(R.array.EstacionesDorada));
                        //SPNN12.setVisibility(View.VISIBLE);
                        SPNN12.setAdapter(Estaciones);
                        TXV13.setTextColor(Color.WHITE);


                        break;

                    case 10:
                        Estaciones = new ArrayAdapter<String>(this,R.layout.stilotexto,getResources().getStringArray(R.array.EstacionesCafe));
                        //SPNN12.setVisibility(View.VISIBLE);
                        SPNN12.setAdapter(Estaciones);
                        TXV13.setTextColor(Color.WHITE);


                        break;

                    case 11:



                        break;
                }
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override

        public void onClick(View view) {

            switch (view.getId()) {

                case R.id.BTNCAMERA1:

                        pez = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(pez,Toma1);


                    break;

                case R.id.BTNCAMERA3:

                    pez = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(pez,Toma2);

                    break;

                case R.id.BTN22:
                    BeloAzul.setVisibility(View.VISIBLE);
                    progress.setVisibility(View.VISIBLE);
                    tomate.postDelayed(new Runnable() {
                        public void run() {
                            progress.setVisibility(View.INVISIBLE);
                            Toast.makeText(reporte.this, "RECEPCION EN SERVIDOR .... OK",                                Toast.LENGTH_LONG).show();
                        }
                    }, 3000);

                    tomate.postDelayed(new Runnable() {
                        public void run() {finish(); }
                    }, 6800);

                    break;

                case R.id.BTN33:
                    finish();
                    break;

                case R.id.BTNCAMERA2:
                    Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                    galleryIntent.setType("image/*");
                    startActivityForResult(galleryIntent, Arch1);

                    break;

                case R.id.BTNCAMERA4:
                    Intent galleryIntent2 = new Intent(Intent.ACTION_GET_CONTENT);
                    galleryIntent2.setType("image/*");
                    startActivityForResult(galleryIntent2, Arch2);

                    break;

            }

        }

    @Override
    protected  void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if (requestCode == Toma1 && resultCode == RESULT_OK  ) {
           Bundle ext = data.getExtras();
           bmppp= (Bitmap)ext.get("data");
           BTNCAMERA1.setImageBitmap(bmppp);

            BTNCAMERA3.setImageResource(R.drawable.camarita);
            BTNCAMERA3.setPadding(0,0,0,0);
            BTNCAMERA3.setAlpha(1f);
            BTNCAMERA3.setOnClickListener(this);


        }

        if (requestCode == Toma2 && resultCode == RESULT_OK ) {
            Bundle ext = data.getExtras();
            bmppp= (Bitmap)ext.get("data");
            BTNCAMERA3.setImageBitmap(bmppp);

        }

        if (requestCode == Arch1 && resultCode == RESULT_OK   ){
            imaginax = data.getData();
            BTNCAMERA2.setImageURI(imaginax);
           BTNCAMERA4.setImageResource(R.drawable.archivito);
            BTNCAMERA4.setPadding(0,0,0,0);
            BTNCAMERA4.setAlpha(1f);
            BTNCAMERA4.setOnClickListener(this);

        }

        if (requestCode == Arch2 && resultCode == RESULT_OK  ) {
            imaginax = data.getData();
            BTNCAMERA4.setImageURI(imaginax);

        }
    }
    private void checkCameraPermission() {
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);

        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            Log.i("Mensaje", "No se tiene permiso para la camara!.");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 225);
            Toast.makeText(this, "sera", Toast.LENGTH_LONG).show();
        } else {
            Log.i("Mensaje", "Tienes permiso para usar la camara.");

        }
    }
}
