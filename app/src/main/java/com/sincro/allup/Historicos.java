package com.sincro.allup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class Historicos extends AppCompatActivity {


    TextView TXV40, TXV41, TXV42, TXV43, TXV44;
    Button BTN40,BTN41;
    Spinner SPNN40, SPNN41,SPNN43, SPNN42;
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


        BTN40 = (Button) findViewById(R.id.BTN40);
        BTN41 = (Button) findViewById(R.id.BTN41);


        Lines = new ArrayAdapter<String>(this,R.layout.stilotexto2,getResources().getStringArray(R.array.Lineaxxx));
        States = new ArrayAdapter<String>(this,R.layout.stilotexto2,getResources().getStringArray(R.array.Estadox));
        Ares = new ArrayAdapter<String>(this,R.layout.stilotexto2,getResources().getStringArray(R.array.Areax));


        SPNN40.setAdapter(Lines);
        SPNN41.setAdapter(Ares);
        SPNN42.setAdapter(States);
    }
}
