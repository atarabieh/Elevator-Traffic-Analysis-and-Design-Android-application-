package com.ju.mechatronics.erttc;

import android.content.Intent;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;


public class Home extends AppCompatActivity {
GlobalVariables globalVariables;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        final

        FloatingActionButton NewDesign= (FloatingActionButton) findViewById(R.id.create);
        NewDesign.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(Home.this,New_Design.class);
                startActivity(Intent);

            }
        });
    }
}
