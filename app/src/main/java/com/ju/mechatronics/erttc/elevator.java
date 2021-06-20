package com.ju.mechatronics.erttc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;


public class elevator extends AppCompatActivity {
    GlobalVariables globalVariables;
    EditText TDO = (EditText)findViewById(R.id.tdo);
    TextView elevatorSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.elevator);
        globalVariables = (GlobalVariables)getApplicationContext();
        elevatorSave = (TextView)findViewById(R.id.elevatorSave);
        final TextView test = (TextView)findViewById(R.id.test);



    }


}
