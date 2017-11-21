package com.sincro.allup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

public class Departamentos extends AppCompatActivity implements View.OnClickListener  {

    Button BTN201,BTN202,BTN204, BTN25698 ;
    ImageView IMV22 ;
    Handler opera = new Handler();
    Handler pop = new Handler();
    SharedPreferences queridas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        queridas = PreferenceManager.getDefaultSharedPreferences(this);
        if (queridas.getString(getResources().getString(R.string.Usuar), "").equals("")) {
            //Verificamos que la aplicacion tiene numero de trazador asignado,,, de lo contrario abrimos
            //la actividad de bienvenida para la personalizacion de la actividad
            startActivity(new Intent(Departamentos.this, Iniciamox.class));
        } else {
            setContentView(R.layout.activity_departamentos);


            BTN201 = (Button) findViewById(R.id.BTN201);
            BTN202 = (Button) findViewById(R.id.BTN202);
            BTN204 = (Button) findViewById(R.id.BTN204);
            IMV22 = (ImageView) findViewById(R.id.IMV22);
            BTN201.setOnClickListener(this);
            BTN204.setOnClickListener(this);
            BTN202.setOnClickListener(this);

            opera.postDelayed(new Runnable() {
                public void run() {
                    Desvanecer(IMV22);
                }
            }, 1000);

            pop.postDelayed(new Runnable() {
                public void run() {
                    Amanecer(BTN201);
                    Amanecer(BTN202);

                    Amanecer(BTN204);
                }
            }, 2000);

            // Check if Android M or higher
            if (android.os.Build.VERSION.SDK_INT >= 23) {   //Android M Or Over
                if (!Settings.canDrawOverlays(this)) {
                    Intent myIntent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
                    myIntent.setData(Uri.parse("package:" + getPackageName()));
                    startActivity(myIntent);
                    return;
                }}
        }
    }

    @Override
    public void onClick(View botoncito) {

        switch (botoncito.getId()) {

            case R.id.BTN201:
                startActivity(new Intent(Departamentos.this, MainActivity.class));

                break;

            case R.id.BTN202:
                startActivity(new Intent(Departamentos.this, MainActivity.class));

                break;

            case R.id.BTN204:
                finish();

                break;

        }
    }
    private void Desvanecer(final ImageView img)
    {
        Animation desvaneceme = new AlphaAnimation(1, 0);
        desvaneceme.setInterpolator(new AccelerateInterpolator());
        desvaneceme.setDuration(1500);

        desvaneceme.setAnimationListener(new Animation.AnimationListener()
        {
            public void onAnimationEnd(Animation animation)
            {
                img.setVisibility(View.INVISIBLE);
            }
            public void onAnimationRepeat(Animation animation) {}
            public void onAnimationStart(Animation animation) {img.setVisibility(View.VISIBLE);}
        });

        img.startAnimation(desvaneceme);
    }
    private void Amanecer(final Button BTTN)
    {
        Animation amaneceme = new AlphaAnimation(0, 1);
        amaneceme.setInterpolator(new AccelerateInterpolator());
        amaneceme.setDuration(1500);

        amaneceme.setAnimationListener(new Animation.AnimationListener()
        {
            public void onAnimationEnd(Animation animation)
            {
                BTTN.setVisibility(View.VISIBLE);
            }
            public void onAnimationRepeat(Animation animation) {}
            public void onAnimationStart(Animation animation) {BTTN.setVisibility(View.VISIBLE);}
        });

        BTTN.startAnimation(amaneceme);
    }

}
