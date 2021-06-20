package com.ju.mechatronics.erttc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class passenger extends AppCompatActivity {
    EditText UValue;
    String UString;
    int U;

    EditText tpiValue;
    String tpiString;
    int tpi;

    EditText tpoValue;
    String tpoString;
    int tpo;

    EditText ARValue;
    String ARString;
    int AR;

    EditText ICValue;
    String ICString;
    int IC;

    EditText OGValue;
    String OGString;
    int OG;

    EditText IFPValue;
    String IFPString;
    int IFP;

    EditText IEPValue;
    String IEPString;
    int IEP;

    TextView passengerSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.passenger_specs);
        UValue = (EditText) findViewById(R.id.U);
        tpiValue = (EditText) findViewById(R.id.tpi);
        tpoValue = (EditText) findViewById(R.id.tpo);
        ARValue = (EditText) findViewById(R.id.AR);
        ICValue = (EditText) findViewById(R.id.IC);
        OGValue = (EditText) findViewById(R.id.OG);
        IFPValue = (EditText) findViewById(R.id.IFP);
        IEPValue = (EditText) findViewById(R.id.IEP);

        passengerSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UString = UValue.getText().toString();
                U = Integer.parseInt(UString);

                tpiString = tpiValue.getText().toString();
                tpi = Integer.parseInt(tpiString);

                tpoString = tpoValue.getText().toString();
                tpo = Integer.parseInt(tpoString);

                ARString = ARValue.getText().toString();
                AR = Integer.parseInt(ARString);

                ICString = ICValue.getText().toString();
                IC = Integer.parseInt(ICString);

                OGString = OGValue.getText().toString();
                OG = Integer.parseInt(OGString);

                IFPString = IFPValue.getText().toString();
                IFP = Integer.parseInt(IFPString);

                IEPString = IEPValue.getText().toString();
                IEP = Integer.parseInt(IEPString);
            }
        });

    }
}
