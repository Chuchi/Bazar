package com.sincro.allup;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class Historicos extends AppCompatActivity implements View.OnClickListener {


    TextView TXV40, TXV41, TXV42, TXV43, TXV44;
    Button BTN41;
    Spinner SPNN40, SPNN41,SPNN43, SPNN42;
    ImageButton IMBTN114, IMBTN252 ;
    ListView LV40;
    ArrayAdapter<String> Lines, States, Ares ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historicos);


        TXV40 = (TextView) findViewById(R.id.TXV40);
        TXV41 = (TextView) findViewById(R.id.TXV41);
        TXV42 = (TextView) findViewById(R.id.TXV42);
       // TXV43 = (TextView) findViewById(R.id.TXV43);
     //   TXV44 = (TextView) findViewById(R.id.TXV44);


        SPNN40=(Spinner) findViewById(R.id.SPNN40) ;
        SPNN41=(Spinner) findViewById(R.id.SPNN41) ;
        SPNN42=(Spinner) findViewById(R.id.SPNN42) ;
     // SPNN43=(Spinner) findViewById(R.id.SPNN43) ;

        IMBTN114=(ImageButton)findViewById(R.id.IMBTN114) ;
        IMBTN252=(ImageButton)findViewById(R.id.IMBTN252) ;

        BTN41 = (Button) findViewById(R.id.BTN41);

        IMBTN114.setOnClickListener(this);
        BTN41.setOnClickListener(this);


        Lines = new ArrayAdapter<String>(this,R.layout.stilotexto2,getResources().getStringArray(R.array.Lineaxxx));
        States = new ArrayAdapter<String>(this,R.layout.stilotexto2,getResources().getStringArray(R.array.Estadox));
        Ares = new ArrayAdapter<String>(this,R.layout.stilotexto2,getResources().getStringArray(R.array.Areax));


        SPNN40.setAdapter(Lines);
        SPNN41.setAdapter(Ares);
        SPNN42.setAdapter(States);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.BTN41:
                    finish();
                break;

        }
    }

    public void MostrarEscogedorFecha(View v) {
        DialogFragment newFragment = new DialogoEscogerFecha();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public static class DialogoEscogerFecha extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
        }

    }
}
