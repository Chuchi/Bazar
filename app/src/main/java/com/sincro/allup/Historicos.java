package com.sincro.allup;


import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class Historicos extends AppCompatActivity implements View.OnClickListener,View.OnDragListener, AdapterView.OnItemSelectedListener,AdapterView.OnItemClickListener {

    TextView TXV40, TXV41, TXV42, TXV51, TXV52;
    Button BTN41;
    Spinner SPNN40, SPNN41, SPNN43, SPNN42;
    ImageButton IMBTN114, IMBTN252, IMBTN253;
    ImageView IMV72;
    ListView LV40;
    ArrayAdapter<String> Lines, States, Ares,Selector;
    Handler popo = new Handler();
    ProgressBar PGSS12;
    int fotero =0;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historicos);


        TXV40 = (TextView) findViewById(R.id.TXV40);
        TXV41 = (TextView) findViewById(R.id.TXV41);
        TXV42 = (TextView) findViewById(R.id.TXV42);
        TXV51 = (TextView) findViewById(R.id.TXV51);
        TXV52 = (TextView) findViewById(R.id.TXV52);
        IMV72 = (ImageView)findViewById(R.id.IMV72) ;

        LV40 = (ListView) findViewById(R.id.LV40);

        SPNN40 = (Spinner) findViewById(R.id.SPNN40);
        SPNN41 = (Spinner) findViewById(R.id.SPNN41);
        SPNN42 = (Spinner) findViewById(R.id.SPNN42);
        // SPNN43=(Spinner) findViewById(R.id.SPNN43) ;

        IMBTN114 = (ImageButton) findViewById(R.id.IMBTN114);
        IMBTN252 = (ImageButton) findViewById(R.id.IMBTN252);
        IMBTN253 = (ImageButton) findViewById(R.id.IMBTN253);
        PGSS12=(ProgressBar)findViewById(R.id.PGSS12) ;

        BTN41 = (Button) findViewById(R.id.BTN41);

        IMBTN114.setOnClickListener(this);
        IMBTN252.setOnClickListener(this);
        IMBTN253.setOnClickListener(this);
        BTN41.setOnClickListener(this);



        Lines = new ArrayAdapter<String>(this, R.layout.stilotexto2, getResources().getStringArray(R.array.Lineaxxx));
        States = new ArrayAdapter<String>(this, R.layout.stilotexto2, getResources().getStringArray(R.array.Estadox));
        Ares = new ArrayAdapter<String>(this, R.layout.stilotexto2, getResources().getStringArray(R.array.Areax));
        Selector = new ArrayAdapter<String>(this, R.layout.stilotexto2, getResources().getStringArray(R.array.Selecciones));


        SPNN40.setAdapter(Lines);
        SPNN41.setAdapter(Ares);
        SPNN42.setAdapter(States);
        LV40.setOnItemClickListener( this);
        IMV72.setOnDragListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.BTN41:
                finish();
                break;
            case R.id.IMBTN252:
                final Calendar calendar = Calendar.getInstance();
                int yy = calendar.get(Calendar.YEAR);
                int mm = calendar.get(Calendar.MONTH);
                int dd = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePicker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int año, int mes, int dia) {
                        String date = String.valueOf(dia) +"-"+String.valueOf(mes)
                                +"-"+String.valueOf(año);
                        TXV51.setText(date);

                    }
                }, yy, mm, dd);
                datePicker.show();
                break;
            case R.id.IMBTN253:
                final Calendar calendar2 = Calendar.getInstance();
                int yy2 = calendar2.get(Calendar.YEAR);
                int mm2 = calendar2.get(Calendar.MONTH);
                int dd2 = calendar2.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePicker2 = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int año, int mes, int dia) {
                        String date2 = String.valueOf(dia) +"-"+String.valueOf(mes)
                                +"-"+String.valueOf(año);
                        TXV52.setText(date2);

                    }
                }, yy2, mm2, dd2);
                datePicker2.show();
                break;
            case R.id.IMBTN114:

                PGSS12.setVisibility(View.VISIBLE);
                popo.postDelayed(new Runnable() {
                    public void run() {
                        PGSS12.setVisibility(View.INVISIBLE);
                        LV40.setAdapter(Selector);




                    }
                }, 3000);





                break;

        }
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (adapterView.getId()) {
            case R.id.LV40:

                int ordene = LV40.getCheckedItemPosition();

                switch (ordene) {
                    case 0:
                        IMV72.setVisibility(View.VISIBLE);
                        IMV72.setImageResource(R.drawable.rapazare);
                        fotero=0;
                        break;

                    case 1:
                        IMV72.setVisibility(View.VISIBLE);
                        IMV72.setImageResource(R.drawable.guidore);
                        fotero=1;
                        break;

                    case 2:
                        IMV72.setVisibility(View.VISIBLE);
                        IMV72.setImageResource(R.drawable.barunire);
                        fotero=2;
                        break;
                }
           break;
          }
        }


    @Override
    public boolean onDrag(View view, DragEvent dragEvent) {
        switch(dragEvent.getAction())
        {
            case DragEvent.ACTION_DRAG_STARTED:

                // Do nothing
                break;

            case DragEvent.ACTION_DRAG_ENTERED:

                break;

            case DragEvent.ACTION_DRAG_EXITED :
                switch(fotero){
                    case 0:
                        IMV72.setImageResource(R.drawable.guidore);
                        fotero ++;
                        break;
                    case 1:
                        IMV72.setImageResource(R.drawable.barunire);
                        fotero ++;
                        break;
                    case 2:
                        IMV72.setImageResource(R.drawable.rapazare);
                        fotero =0;
                        break;
                    default: break;

                }


                break;

            case DragEvent.ACTION_DRAG_LOCATION  :

                break;

            case DragEvent.ACTION_DRAG_ENDED   :
                switch(fotero){
                    case 0:
                        IMV72.setImageResource(R.drawable.guidore);
                        fotero ++;
                        break;
                    case 1:
                        IMV72.setImageResource(R.drawable.barunire);
                        fotero ++;
                        break;
                    case 2:
                        IMV72.setImageResource(R.drawable.rapazare);
                        fotero =0;
                        break;
                    default: break;

                }

                // Do nothing
                break;

            case DragEvent.ACTION_DROP:

                // Do nothing
                break;
            default: break;
        }


        return false;
    }
}