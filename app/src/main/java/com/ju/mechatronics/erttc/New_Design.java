package com.ju.mechatronics.erttc;

import android.content.Intent;
import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class New_Design extends AppCompatActivity {

    GlobalVariables globalVariables;
TextView alert;
ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_design);
        alert = (TextView)findViewById(R.id.textView);
        progressBar = (ProgressBar)findViewById(R.id.progressbar);
        alert.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
        final LinearLayout run = (LinearLayout) findViewById(R.id.run);
        run.setEnabled(false);
        final LinearLayout elevator = (LinearLayout) findViewById(R.id.elevator);
        elevator.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                run.setEnabled(true);

                LayoutInflater layoutInflater
                        = (LayoutInflater)getBaseContext()
                        .getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = layoutInflater.inflate(R.layout.elevator, null);
                final View  popupView1 = layoutInflater.inflate(R.layout.elevator, null);

                final PopupWindow popUp = new PopupWindow(popupView1, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, true);
                popUp.setFocusable(true);
                popUp.setOutsideTouchable(isRestricted());
                TextView elevatorClose = (TextView) popupView1.findViewById(R.id.txtclose);
                elevatorClose.setOnClickListener(new Button.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        popUp.setContentView(popupView1);
                        globalVariables = (GlobalVariables)getApplicationContext();
                        globalVariables.setCheck2("false");
                        popUp.dismiss();
                    }});

                TextView elevatorSave = (TextView) popupView1.findViewById(R.id.elevatorSave);
                elevatorSave.setOnClickListener(new Button.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        popUp.setContentView(popupView1);
                        globalVariables = (GlobalVariables)getApplicationContext();
                        globalVariables.setCheck2("true");
                        final EditText  tdo = (EditText) popupView1.findViewById(R.id.tdo);
                        final EditText  tdc = (EditText) popupView1.findViewById(R.id.tdc);
                        final EditText  speed = (EditText) popupView1.findViewById(R.id.ratedvelocity);
                        final EditText  acc = (EditText) popupView1.findViewById(R.id.acc);
                        final EditText  jerk = (EditText) popupView1.findViewById(R.id.jerk);
                        tdo.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tdo.setText("");
                                tdo.setTextColor(Color.WHITE);
                            }
                        });

                        tdc.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tdc.setText("");
                                tdc.setTextColor(Color.WHITE);
                            }
                        });

                        acc.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                acc.setText("");
                                acc.setTextColor(Color.WHITE);
                            }
                        });

                        jerk.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                jerk.setText("");
                                jerk.setTextColor(Color.WHITE);
                            }
                        });
                        speed.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                speed.setText("");
                                speed.setTextColor(Color.WHITE);
                            }
                        });

                        String tdO =tdo.getText().toString();
                        String tdC = tdc.getText().toString();
                        String speeD =speed.getText().toString();
                        String acC = acc.getText().toString();
                        String jerK = jerk.getText().toString();

                        if(tdO.isEmpty() || tdO.length() == 0 || tdO.equals("") || tdO == null || tdO.length() == 27 )
                        {
                            tdo.setText("This field cannot be empty!");
                            tdo.setTextColor(Color.RED);
                        }
                        else
                        {if (tdO.length() < 27){
                            globalVariables.setTdo(Double.parseDouble(tdO));}
                        }

                        if(tdC.isEmpty() || tdC.length() == 0 || tdC.equals("") || tdC == null || tdC.length() == 27)
                        {
                            tdc.setText("This field cannot be empty!");
                            tdc.setTextColor(Color.RED);
                        }
                        else
                        {if (tdC.length() < 27){
                            globalVariables.setTdc(Double.parseDouble(tdC));}
                        }

                        if(acC.isEmpty() || acC.length() == 0 || acC.equals("") || acC == null || acC.length() == 27)
                        {
                            acc.setText("This field cannot be empty!");
                            acc.setTextColor(Color.RED);
                        }
                        else
                        {if (acC.length() < 27){
                            globalVariables.setAcc(Double.parseDouble(acC));}
                        }

                        if(jerK.isEmpty() || jerK.length() == 0 || jerK.equals("") || jerK == null || jerK.length() == 27)
                        {
                            jerk.setText("This field cannot be empty!");
                            jerk.setTextColor(Color.RED);
                        }
                        else
                        { if (jerK.length() < 27){

                            globalVariables.setJerk(Double.parseDouble(jerK));}
                        }

                        if(speeD.isEmpty() || speeD.length() == 0 || speeD.equals("") || speeD == null || speeD.length() == 27 )
                        {
                            speed.setText("This field cannot be empty!");
                            speed.setTextColor(Color.RED);
                        }
                        else
                        {if (tdO.length() < 27){
                            globalVariables.setV(Double.parseDouble(speeD));}
                        }


                        if(tdO.length() > 0 && tdO.length() < 27 && speeD.length() > 0 && speeD.length() < 27 && tdC.length()>0 && tdC.length() < 27 && acC.length() > 0 && acC.length() < 27 && jerK.length()>0 && jerK.length() < 27 )
                        {
                            popUp.dismiss();
                        }


                    }});

                popUp.showAtLocation(popupView, Gravity.CENTER, 0, 0);

            }


        });

///////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
        final LinearLayout building = (LinearLayout) findViewById(R.id.building);
        building.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                run.setEnabled(true);

                LayoutInflater layoutInflaterb
                        = (LayoutInflater)getBaseContext()
                        .getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupViewb = layoutInflaterb.inflate(R.layout.building_specs, null);
                final View  popupView1b = layoutInflaterb.inflate(R.layout.building_specs, null);

                final PopupWindow popUpb = new PopupWindow(popupView1b, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, true);
                popUpb.setFocusable(true);
                popUpb.setOutsideTouchable(isRestricted());
                TextView buildingClose = (TextView) popupView1b.findViewById(R.id.txtclosebuild);
                buildingClose.setOnClickListener(new Button.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        popUpb.setContentView(popupView1b);
                        globalVariables = (GlobalVariables)getApplicationContext();
                        globalVariables.setCheck2("false");
                        popUpb.dismiss();
                    }});
                TextView buildingSave = (TextView) popupView1b.findViewById(R.id.buildingSave);


                    buildingSave.setOnClickListener(new View.OnClickListener() {

                        public void onClick(View v) {

                        popUpb.setContentView(popupView1b);
                        globalVariables = (GlobalVariables)getApplicationContext();
                            globalVariables.setCheck2("true");
                        final EditText  height = (EditText) popupView1b.findViewById(R.id.height);
                        final EditText  noe = (EditText) popupView1b.findViewById(R.id.Noe);
                        final EditText  nof = (EditText) popupView1b.findViewById(R.id.Nof);
                        final EditText  intt = (EditText) popupView1b.findViewById(R.id.INT);
                        final EditText  trials = (EditText) popupView1b.findViewById(R.id.trials);
                            final EditText  he1 = (EditText) popupView1b.findViewById(R.id.entrance1h);
                            final EditText  he2 = (EditText) popupView1b.findViewById(R.id.entrance2h);
                            final EditText  he3 = (EditText) popupView1b.findViewById(R.id.entrance3h);
                            final EditText  he4 = (EditText) popupView1b.findViewById(R.id.entrance4h);
                            final EditText  hf1 = (EditText) popupView1b.findViewById(R.id.firsth);
                            final EditText  hf2 = (EditText) popupView1b.findViewById(R.id.secondh);
                            final EditText  hf3 = (EditText) popupView1b.findViewById(R.id.thirdh);
                            final EditText  hf4 = (EditText) popupView1b.findViewById(R.id.fourthh);
                            final EditText  hf5 = (EditText) popupView1b.findViewById(R.id.fifthh);
                            final EditText  hf6 = (EditText) popupView1b.findViewById(R.id.sixthh);
                            final EditText  hf7 = (EditText) popupView1b.findViewById(R.id.seventhh);
                            final EditText  hf8 = (EditText) popupView1b.findViewById(R.id.eighthh);
                            final EditText  we1 = (EditText) popupView1b.findViewById(R.id.entrance1w);
                            final EditText  we2 = (EditText) popupView1b.findViewById(R.id.entrance2w);
                            final EditText  we3 = (EditText) popupView1b.findViewById(R.id.entrance3w);
                            final EditText  we4 = (EditText) popupView1b.findViewById(R.id.entrance4w);


                        height.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                height.setText("");
                                height.setTextColor(Color.WHITE);
                            }
                        });

                        noe.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                noe.setText("");
                                noe.setTextColor(Color.WHITE);
                            }
                        });

                        nof.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                nof.setText("");
                                nof.setTextColor(Color.WHITE);
                            }
                        });

                        intt.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                intt.setText("");
                                intt.setTextColor(Color.WHITE);
                            }
                        });

                        trials.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                trials.setText("");
                                trials.setTextColor(Color.WHITE);
                            }
                        });

                            we1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    we1.setText("");
                                    we1.setTextColor(Color.WHITE);
                                }
                            });
                            we2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    we2.setText("");
                                    we2.setTextColor(Color.WHITE);
                                }
                            });
                            we3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    we3.setText("");
                                    we3.setTextColor(Color.WHITE);
                                }
                            });
                            we4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    we4.setText("");
                                    we4.setTextColor(Color.WHITE);
                                }
                            });
                        String heighT =height.getText().toString();
                        String noE =noe.getText().toString();
                        String noF = nof.getText().toString();
                        String intT = intt.getText().toString();
                        String trialS = trials.getText().toString();
                            String hE1 = he1.getText().toString();
                            String hE2 = he2.getText().toString();
                            String hE3 = he3.getText().toString();
                            String hE4 = he4.getText().toString();
                            String hF1 = hf1.getText().toString();
                            String hF2 = hf2.getText().toString();
                            String hF3 = hf3.getText().toString();
                            String hF4 = hf4.getText().toString();
                            String hF5 = hf5.getText().toString();
                            String hF6 = hf6.getText().toString();
                            String hF7 = hf7.getText().toString();
                            String hF8 = hf8.getText().toString();
                            String wE1 = we1.getText().toString();
                            String wE2 = we2.getText().toString();
                            String wE3 = we3.getText().toString();
                            String wE4 = we4.getText().toString();
                        if(heighT.isEmpty() || heighT.length() == 0 || heighT.equals("") || heighT == null || heighT.length() == 27 )
                        {
                            height.setText("This field cannot be empty!");
                            height.setTextColor(Color.RED);
                        }
                        else
                        {if (heighT.length() < 27){
                            globalVariables.setHeight(Double.parseDouble(heighT));}
                        }

                        if(noE.isEmpty() || noE.length() == 0 || noE.equals("") || noE == null || noE.length() == 27 )
                        {
                            noe.setText("This field cannot be empty!");
                            noe.setTextColor(Color.RED);
                        }
                        else
                        {if (noE.length() < 27){
                            globalVariables.setNoe(Integer.parseInt(noE));}
                        }

                        if(noF.isEmpty() || noF.length() == 0 || noF.equals("") || noF == null || noF.length() == 27)
                        {
                            nof.setText("This field cannot be empty!");
                            nof.setTextColor(Color.RED);
                        }
                        else
                        {if (noF.length() < 27){
                            globalVariables.setNof(Integer.parseInt(noF));}
                        }

                        if(intT.isEmpty() || intT.length() == 0 || intT.equals("") || intT == null || intT.length() == 27)
                        {
                            intt.setText("This field cannot be empty!");
                            intt.setTextColor(Color.RED);
                        }
                        else
                        {if (intT.length() < 27){
                            globalVariables.setIntt(Double.parseDouble(intT));}
                        }

                        if(trialS.isEmpty() || trialS.length() == 0 || trialS.equals("") || trialS == null || trialS.length() == 27)
                        {
                            trials.setText("This field cannot be empty!");
                            trials.setTextColor(Color.RED);
                        }
                        else
                        { if (trialS.length() < 27){

                            globalVariables.setTrials(Double.parseDouble(trialS));}
                        }
                        ////////////////////////////////////////////////////////
                            if(hF1.length() != 0 )
                            {
                                globalVariables.setHf1(Double.parseDouble(hF1));
                            }
                            else{
                                globalVariables.setHf1(0.0);
                            }
                            if(hF2.length() != 0 )
                            {
                                globalVariables.setHf2(Double.parseDouble(hF2));
                            }
                            else{
                                globalVariables.setHf2(0.0);
                            }
                            if(hF3.length() != 0 )
                            {
                                globalVariables.setHf3(Double.parseDouble(hF3));
                            }
                            else{
                                globalVariables.setHf3(0.0);
                            }
                            if(hF4.length() != 0 )
                            {
                                globalVariables.setHf4(Double.parseDouble(hF4));
                            }
                            else{
                                globalVariables.setHf4(0.0);
                            }
                            if(hF5.length() != 0 )
                            {
                                globalVariables.setHf5(Double.parseDouble(hF5));
                            }
                            else{
                                globalVariables.setHf5(0.0);
                            }
                            if(hF6.length() != 0 )
                            {
                                globalVariables.setHf6(Double.parseDouble(hF6));
                            }
                            else{
                                globalVariables.setHf6(0.0);
                            }
                            if(hF7.length() != 0 )
                            {
                                globalVariables.setHf7(Double.parseDouble(hF7));
                            }
                            else{
                                globalVariables.setHf7(0.0);
                            }
                            if(hF8.length() != 0 )
                            {
                                globalVariables.setHf8(Double.parseDouble(hF8));
                            }
                            else{
                                globalVariables.setHf8(0.0);
                            }
                            if(hE1.length() != 0 )
                            {
                                globalVariables.setHe1(Double.parseDouble(hE1));
                            }
                            else{
                                globalVariables.setHe1(0.0);
                            }
                            if(hE2.length() != 0 )
                            {
                                globalVariables.setHe2(Double.parseDouble(hE2));
                            }
                            else{
                                globalVariables.setHe2(0.0);
                            }
                            if(hE3.length() != 0 )
                            {
                                globalVariables.setHe3(Double.parseDouble(hE3));
                            }
                            else{
                                globalVariables.setHe3(0.0);
                            }
                            if(hE4.length() != 0 )
                            {
                                globalVariables.setHe4(Double.parseDouble(hE4));
                            }
                            else{
                                globalVariables.setHe4(0.0);
                            }


                            /////////////////////////////////////////////////////////
                            if(globalVariables.getNoe()==1){
                                globalVariables.setWe1(100.0);
                                globalVariables.setWe2(0.0);
                                globalVariables.setWe3(0.0);
                                globalVariables.setWe4(0.0);
                                globalVariables.setCheck(1.0);
                                we2.setText("");
                                we2.setTextColor(Color.WHITE);
                                we3.setText("");
                                we3.setTextColor(Color.WHITE);
                                we4.setText("");
                                we4.setTextColor(Color.WHITE);
                            }
                            if(globalVariables.getNoe()==2)
                            {if (wE1.isEmpty() || wE1.length() == 0 || wE1.equals("") || wE1 == null || wE1.length() == 9) {
                                we1.setText("Required!");
                                we1.setTextColor(Color.RED);
                                globalVariables.setCheck(0.0);
                            }
                            else
                            { if (wE1.length() < 9){
                                globalVariables.setWe1(Double.parseDouble(wE1));
                                globalVariables.setWe3(0.0);
                                globalVariables.setWe4(0.0);
                                globalVariables.setCheck(1.0);}
                            }
                                if (wE2.isEmpty() || wE2.length() == 0 || wE2.equals("") || wE2 == null || wE2.length() == 9) {
                                    we2.setText("Required!");
                                    we2.setTextColor(Color.RED);
                                    globalVariables.setCheck(0.0);
                                }
                                else
                                { if (wE2.length() < 9){

                                    globalVariables.setWe2(Double.parseDouble(wE2));
                                    globalVariables.setWe3(0.0);
                                    globalVariables.setWe4(0.0);
                                    globalVariables.setCheck(1.0);
                                }
                                }}

                            if(globalVariables.getNoe()==3) {
                                if (wE1.isEmpty() || wE1.length() == 0 || wE1.equals("") || wE1 == null || wE1.length() == 9) {
                                    we1.setText("Required!");
                                    we1.setTextColor(Color.RED);
                                    globalVariables.setCheck(0.0);
                                }
                                else
                                { if (wE1.length() < 9){

                                    globalVariables.setWe1(Double.parseDouble(wE1));
                                    globalVariables.setWe4(0.0);
                                    globalVariables.setCheck(1.0);}
                                }
                                if (wE2.isEmpty() || wE2.length() == 0 || wE2.equals("") || wE2 == null || wE2.length() == 9) {
                                    we2.setText("Required!");
                                    we2.setTextColor(Color.RED);
                                    globalVariables.setCheck(0.0);
                                }
                                else
                                { if (wE2.length() < 9){

                                    globalVariables.setWe2(Double.parseDouble(wE2));
                                    globalVariables.setWe4(0.0);
                                    globalVariables.setCheck(1.0);}
                                }
                                if (wE3.isEmpty() || wE3.length() == 0 || wE3.equals("") || wE3 == null || wE3.length() == 9) {
                                    we3.setText("Required!");
                                    we3.setTextColor(Color.RED);
                                    globalVariables.setCheck(0.0);
                                }
                                else
                                { if (wE3.length() < 9){

                                    globalVariables.setWe3(Double.parseDouble(wE3));
                                    globalVariables.setWe4(0.0);
                                    globalVariables.setCheck(1.0);}
                                }

                            }
                            if(globalVariables.getNoe()==4) {
                                if (wE1.isEmpty() || wE1.length() == 0 || wE1.equals("") || wE1 == null || wE1.length() == 9) {
                                    we1.setText("Required!");
                                    we1.setTextColor(Color.RED);
                                    globalVariables.setCheck(0.0);
                                }
                                else
                                { if (wE1.length() < 9){

                                    globalVariables.setWe1(Double.parseDouble(wE1));
                                    globalVariables.setCheck(1.0);}
                                }
                                if (wE2.isEmpty() || wE2.length() == 0 || wE2.equals("") || wE2 == null || wE2.length() == 9) {
                                    we2.setText("Required!");
                                    we2.setTextColor(Color.RED);
                                    globalVariables.setCheck(0.0);
                                }
                                else
                                { if (wE2.length() < 9){

                                    globalVariables.setWe2(Double.parseDouble(wE2));
                                    globalVariables.setCheck(1.0);}
                                }
                                if (wE3.isEmpty() || wE3.length() == 0 || wE3.equals("") || wE3 == null || wE3.length() == 9) {
                                    we3.setText("Required!");
                                    we3.setTextColor(Color.RED);
                                    globalVariables.setCheck(0.0);
                                }
                                else
                                { if (wE3.length() < 9){

                                    globalVariables.setWe3(Double.parseDouble(wE3));
                                    globalVariables.setCheck(1.0);}
                                }
                                if (wE4.isEmpty() || wE4.length() == 0 || wE4.equals("") || wE4 == null || wE4.length() == 9) {
                                    we4.setText("Required!");
                                    we4.setTextColor(Color.RED);
                                    globalVariables.setCheck(0.0);
                                }
                                else
                                { if (wE4.length() < 9){

                                    globalVariables.setWe4(Double.parseDouble(wE4));
                                    globalVariables.setCheck(1.0);}
                                }}





//////////////////////////////////////////////////////////////////////////////////////


                        if(heighT.length() > 0 && heighT.length() < 27 && noE.length() > 0 && noE.length() < 27 && noF.length()>0 && noF.length() < 27 && intT.length() > 0 && intT.length() < 27 && trialS.length()>0 && trialS.length() < 27 && globalVariables.getCheck() != 0.0 )
                        {
                            popUpb.dismiss();
                        }


                    }});

                popUpb.showAtLocation(popupViewb, Gravity.CENTER, 0, 0);

            }


        });
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
        final LinearLayout passengers = (LinearLayout) findViewById(R.id.passengers);
        passengers.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                run.setEnabled(true);
                LayoutInflater layoutInflaterp
                        = (LayoutInflater)getBaseContext()
                        .getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupViewp = layoutInflaterp.inflate(R.layout.passenger_specs, null);
                final View  popupView1p = layoutInflaterp.inflate(R.layout.passenger_specs, null);

                final PopupWindow popUpp = new PopupWindow(popupView1p, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, true);
                popUpp.setFocusable(true);
                popUpp.setOutsideTouchable(isRestricted());
                TextView passengersClose = (TextView) popupView1p.findViewById(R.id.txtclosepass);
                passengersClose.setOnClickListener(new Button.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        popUpp.setContentView(popupView1p);
                        globalVariables = (GlobalVariables)getApplicationContext();
                        globalVariables.setCheck2("false");
                        popUpp.dismiss();
                    }});

                TextView passengersSave = (TextView) popupView1p.findViewById(R.id.passengerSave);
                passengersSave.setOnClickListener(new Button.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        popUpp.setContentView(popupView1p);
                        globalVariables = (GlobalVariables)getApplicationContext();
                        globalVariables.setCheck2("true");
                        final EditText  u = (EditText) popupView1p.findViewById(R.id.U);
                        final EditText  tpi = (EditText) popupView1p.findViewById(R.id.tpi);
                        final EditText  tpo = (EditText) popupView1p.findViewById(R.id.tpo);
                        final EditText  ar = (EditText) popupView1p.findViewById(R.id.AR);
                        final EditText  ic = (EditText) popupView1p.findViewById(R.id.IC);
                        final EditText  og = (EditText) popupView1p.findViewById(R.id.OG);
                        final EditText  ifp = (EditText) popupView1p.findViewById(R.id.IFP);
                        final EditText  iep = (EditText) popupView1p.findViewById(R.id.IEP);
                        final EditText  nf1 = (EditText) popupView1p.findViewById(R.id.firstf);
                        final EditText  nf2 = (EditText) popupView1p.findViewById(R.id.secondf);
                        final EditText  nf3 = (EditText) popupView1p.findViewById(R.id.thirdf);
                        final EditText  nf4 = (EditText) popupView1p.findViewById(R.id.fourthf);
                        final EditText  nf5 = (EditText) popupView1p.findViewById(R.id.fifthf);
                        final EditText  nf6 = (EditText) popupView1p.findViewById(R.id.sixthf);
                        final EditText  nf7 = (EditText) popupView1p.findViewById(R.id.seventhf);
                        final EditText  nf8 = (EditText) popupView1p.findViewById(R.id.eighthf);
                        u.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                u.setText("");
                                u.setTextColor(Color.WHITE);
                            }
                        });

                        tpi.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tpi.setText("");
                                tpi.setTextColor(Color.WHITE);
                            }
                        });

                        tpo.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tpo.setText("");
                                tpo.setTextColor(Color.WHITE);
                            }
                        });

                        ar.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ar.setText("");
                                ar.setTextColor(Color.WHITE);
                            }
                        });

                        ic.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ic.setText("");
                                ic.setTextColor(Color.WHITE);
                            }
                        });

                        og.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                og.setText("");
                                og.setTextColor(Color.WHITE);
                            }
                        });

                        ifp.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ifp.setText("");
                                ifp.setTextColor(Color.WHITE);
                            }
                        });

                        iep.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                iep.setText("");
                                iep.setTextColor(Color.WHITE);
                            }
                        });

                        String U =u.getText().toString();
                        String tpI = tpi.getText().toString();
                        String tpO = tpo.getText().toString();
                        String aR = ar.getText().toString();
                        String iC = ic.getText().toString();
                        String oG = og.getText().toString();
                        String ifP = ifp.getText().toString();
                        String ieP = iep.getText().toString();
                        String nF1 = nf1.getText().toString();
                        String nF2 = nf2.getText().toString();
                        String nF3 = nf3.getText().toString();
                        String nF4 = nf4.getText().toString();
                        String nF5 = nf5.getText().toString();
                        String nF6 = nf6.getText().toString();
                        String nF7 = nf7.getText().toString();
                        String nF8 = nf8.getText().toString();

                        if(U.isEmpty() || U.length() == 0 || U.equals("") || U == null || U.length() == 27 )
                        {
                            u.setText("This field cannot be empty!");
                            u.setTextColor(Color.RED);
                        }
                        else
                        {if (U.length() < 27){
                            globalVariables.setU(Double.parseDouble(U));}
                        }

                        if(tpI.isEmpty() || tpI.length() == 0 || tpI.equals("") || tpI == null || tpI.length() == 27)
                        {
                            tpi.setText("This field cannot be empty!");
                            tpi.setTextColor(Color.RED);
                        }
                        else
                        {if (tpI.length() < 27){
                            globalVariables.setTpi(Double.parseDouble(tpI));}
                        }

                        if(tpO.isEmpty() || tpO.length() == 0 || tpO.equals("") || tpO == null || tpO.length() == 27)
                        {
                            tpo.setText("This field cannot be empty!");
                            tpo.setTextColor(Color.RED);
                        }
                        else
                        {if (tpO.length() < 27){
                            globalVariables.setTpo(Double.parseDouble(tpO));}
                        }

                        if(aR.isEmpty() || aR.length() == 0 || aR.equals("") || aR == null || aR.length() == 27)
                        {
                            ar.setText("This field cannot be empty!");
                            ar.setTextColor(Color.RED);
                        }
                        else
                        { if (aR.length() < 27){

                            globalVariables.setAr(Double.parseDouble(aR));}
                        }

                        if(iC.isEmpty() || iC.length() == 0 || iC.equals("") || iC == null || iC.length() == 27)
                        {
                            ic.setText("This field cannot be empty!");
                            ic.setTextColor(Color.RED);
                        }
                        else
                        { if (iC.length() < 27){

                            globalVariables.setIc(Double.parseDouble(iC));}
                        }

                        if(oG.isEmpty() || oG.length() == 0 || oG.equals("") || oG == null || oG.length() == 27)
                        {
                            og.setText("This field cannot be empty!");
                            og.setTextColor(Color.RED);
                        }
                        else
                        { if (oG.length() < 27){

                            globalVariables.setOg(Double.parseDouble(oG));}
                        }

                        if(ifP.isEmpty() || ifP.length() == 0 || ifP.equals("") || ifP == null || ifP.length() == 27)
                        {
                            ifp.setText("This field cannot be empty!");
                            ifp.setTextColor(Color.RED);
                        }
                        else
                        { if (ifP.length() < 27){

                            globalVariables.setIfp(Double.parseDouble(ifP));}
                        }

                        if(ieP.isEmpty() || ieP.length() == 0 || ieP.equals("") || ieP == null || ieP.length() == 27)
                        {
                            iep.setText("This field cannot be empty!");
                            iep.setTextColor(Color.RED);
                        }
                        else
                        { if (ieP.length() < 27){

                            globalVariables.setIep(Double.parseDouble(ieP));}
                        }
                        /////////////////////////////////////////////////////////////////
                        if(nF1.isEmpty())
                        {
                            globalVariables.setNf1(0.0);

                        }
                        else{
                            globalVariables.setNf1(Double.parseDouble(nF1));
                        }
                        if(nF2.isEmpty() )
                        {
                            globalVariables.setNf2(0.0);

                        }
                        else{
                            globalVariables.setNf2(Double.parseDouble(nF2));
                        }
                        if(nF3.isEmpty())
                        {
                            globalVariables.setNf3(0.0);

                        }
                        else{
                            globalVariables.setNf3(Double.parseDouble(nF3));
                        }
                        if(nF4.isEmpty() )
                        {
                            globalVariables.setNf4(0.0);

                        }
                        else{
                            globalVariables.setNf4(Double.parseDouble(nF4));
                        }
                        if(nF5.isEmpty() )
                        {
                            globalVariables.setNf5(0.0);

                        }
                        else{
                            globalVariables.setNf5(Double.parseDouble(nF5));
                        }
                        if(nF6.isEmpty())
                        {
                            globalVariables.setNf6(0.0);
                        }
                        else{
                            globalVariables.setNf6(Double.parseDouble(nF6));
                        }
                        if(nF7.isEmpty())
                        {
                            globalVariables.setNf7(0.0);
                        }
                        else{
                            globalVariables.setNf7(Double.parseDouble(nF7));
                        }
                        if(nF8.isEmpty())
                        {
                            globalVariables.setNf8(0.0);

                        }
                        else{
                            globalVariables.setNf8(Double.parseDouble(nF8));
                        }


                        /////////////////////////////////////////////////////////////////

                        if(U.length() > 0 && U.length() < 27 && tpI.length()>0 && tpI.length() < 27 && tpO.length() > 0 && tpO.length() < 27 && aR.length()>0 && aR.length() < 27 )
                        {
                            popUpp.dismiss();
                        }




                    }});

                popUpp.showAtLocation(popupViewp, Gravity.CENTER, 0, 0);

            }


        });








        run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent Intentt = new Intent(New_Design.this,run.class);
                if(globalVariables.getCheck2()=="true"){
                    alert.setVisibility(View.GONE);
                    progressBar.setVisibility(View.VISIBLE);
                startActivity(Intentt);}

                if(globalVariables.getCheck2()=="false"){
                    Toast.makeText(New_Design.this, "Please make sure you have saved all required data!",
                            Toast.LENGTH_LONG).show();}
            }
        });



    };

}
