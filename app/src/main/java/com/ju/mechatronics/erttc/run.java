package com.ju.mechatronics.erttc;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class run extends AppCompatActivity {
    GlobalVariables globalVariables;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run);
        globalVariables = (GlobalVariables) getApplicationContext();
        ///////////////////////////////////////////// Initializing Textviews////////////////////////     -1-
        final TextView rtt = (TextView) findViewById(R.id.RTT);
        final TextView velocity = (TextView) findViewById(R.id.VELOCITY);
        final TextView numberofelevators = (TextView) findViewById(R.id.numberofelevators);
        final TextView intact = (TextView) findViewById(R.id.intact);
        final TextView hc = (TextView) findViewById(R.id.hc);
        final TextView cc = (TextView) findViewById(R.id.cc);
        //////////////////////////////////////////// Getting Our Variables//////////////////////////     -2-

        final Double acc = globalVariables.getAcc();
        final Double intt = globalVariables.getIntt();
        final Double jerk = globalVariables.getJerk();
        final Double height = globalVariables.getHeight();

        final Double iep = globalVariables.getIep() / 100;
        final Double ifp = globalVariables.getIfp() / 100;
        final Double icp = globalVariables.getIc() / 100;
        final Double ogp = globalVariables.getOg() / 100;

        final int nof = globalVariables.getNof();
        final int noe = globalVariables.getNoe();

        final Double Utotal = globalVariables.getU();
        final Double nf1 = globalVariables.getNf1();      // Floors population
        final Double nf2 = globalVariables.getNf2();
        final Double nf3 = globalVariables.getNf3();
        final Double nf4 = globalVariables.getNf4();
        final Double nf5 = globalVariables.getNf5();
        final Double nf6 = globalVariables.getNf6();
        final Double nf7 = globalVariables.getNf7();
        final Double nf8 = globalVariables.getNf8();


        final Double he1 = globalVariables.getHe1();     //Floor Heights
        final Double he2 = globalVariables.getHe2();
        final Double he3 = globalVariables.getHe3();
        final Double he4 = globalVariables.getHe4();
        final Double hf1 = globalVariables.getHf1();
        final Double hf2 = globalVariables.getHf2();
        final Double hf3 = globalVariables.getHf3();
        final Double hf4 = globalVariables.getHf4();
        final Double hf5 = globalVariables.getHf5();
        final Double hf6 = globalVariables.getHf6();
        final Double hf7 = globalVariables.getHf7();
        final Double hf8 = globalVariables.getHf8();

        final Double trials = globalVariables.getTrials();
        final Double ar = globalVariables.getAr();
        final Double tdo = globalVariables.getTdo();
        final Double tdc = globalVariables.getTdc();
        final Double tpi = globalVariables.getTpi();
        final Double tpo = globalVariables.getTpo();

        final Double we1 = globalVariables.getWe1();    //Entrances weights
        final Double we2 = globalVariables.getWe2();
        final Double we3 = globalVariables.getWe3();
        final Double we4 = globalVariables.getWe4();


        //////////////////////////////////////////// Calculations

        //////////// Selecting Rated Velocity
        if(globalVariables.getV()==0.0){Double[] VR10 = {1.0, 1.25, 1.6, 2.0, 2.5, 3.15, 4.0, 5.0, 6.3, 8.0, 10.0};     //Prefered speed values

        Double B = ((acc * acc) - intt * acc * jerk);
        Double v1 = abs((B + sqrt(B * B - 4 * jerk * jerk * height * acc)) / 2 * jerk);
        Double v2 = abs((B - sqrt(B * B - 4 * jerk * jerk * height * acc)) / 2 * jerk);

        if (v1 < v2) {
            Double[] VR10n = {abs(1.0 - v1), abs(1.25 - v1), abs(1.6 - v1), abs(2.0 - v1), abs(2.5 - v1), abs(3.15 - v1), abs(4.0 - v1), abs(5.0 - v1), abs(6.3 - v1), abs(8.0 - v1), abs(10.0 - v1)};
            int smallestIndex = 1;
            for (int j=0; j < VR10n.length; j++) {
                if (VR10n[j] < VR10n[smallestIndex]){
                    smallestIndex = j;
                }}
                Double v = VR10[smallestIndex];
            globalVariables.setV(v);


            }else{
            Double[] VR10n = {abs(1.0 - v2), abs(1.25 - v2), abs(1.6 - v2), abs(2.0 - v2), abs(2.5 - v2), abs(3.15 - v2), abs(4.0 - v2), abs(5.0 - v2), abs(6.3 - v2), abs(8.0 - v2), abs(10.0 - v2)};
            int smallestIndex = 1;
            for (int j=0; j < VR10n.length; j++) {
                if (VR10n[j] < VR10n[smallestIndex]){
                    smallestIndex = j;
                }}
             Double v = VR10[smallestIndex];
            globalVariables.setV(v);
            }}
            ///////////////////////////////////////////////////////////////////////////////////////////DONE
            //////////////////////Creating the PDF and CDF and The OD matrix//////////////////////////////////////////////////
        if (nf1>0.0){
////Floor popualtion % (pdf)
        Double pdf[]={nf1*1.0/(Utotal*1.0),(nf2*1.0/(Utotal*1.0)),(nf3*1.0/(Utotal*1.0)),(nf4*1.0/(Utotal*1.0)),(nf5*1.0/(Utotal*1.0)),(nf6*1.0/(Utotal*1.0)),(nf7*1.0/(Utotal*1.0)),(nf8*1.0/(Utotal*1.0))};
        List<Double> list = new ArrayList<Double>(Arrays.asList(pdf));
        list.removeAll(Arrays.asList(Double.valueOf(0.0)));
        pdf = list.toArray(new Double[nof]);
        globalVariables.setPdf(pdf);}
        if (nf1==0.0){
            Double nf = globalVariables.getU()/nof;
            Double pdf[] = new Double[nof];
            Arrays.fill(pdf, (1/Utotal)*nf);
            List<Double> listP = new ArrayList<Double>(Arrays.asList(pdf));
            listP.removeAll(Arrays.asList(Double.valueOf(0.0)));
            pdf = listP.toArray(new Double[listP.size()]);
            globalVariables.setPdf(pdf);}
////Taking the pdf of entrances weights
        Double[] pdfe={we1/100,we2/100,we3/100,we4/100};
        List<Double> list3 = new ArrayList<Double>(Arrays.asList(pdfe));
        list3.removeAll(Arrays.asList(Double.valueOf(0.0)));
        pdfe = list3.toArray(new Double[list3.size()]);
        globalVariables.setPdfe(pdfe);
        //////////////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        Double[] ODi = ArrayUtils.addAll(globalVariables.getPdfe(), globalVariables.getPdf());   ///Add the pdf and pdfe to one single array and store it in ODi
        globalVariables.setODi(ODi);
        /////
        Double  OD[][] = new Double[noe+nof][noe+nof];  ///Making a square matrix that will represent Origins and Destination

        Double Sum1=0.0;
        globalVariables.setSum1(Sum1);
        Double Sum2=0.0;
        globalVariables.setSum2(Sum2);
        globalVariables.setOD(OD);
        ///////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
//////////////////////Initializing OD Matrix
/////this nested loop works makes the following (multiply the transpose of ODi with the original ODi)
        for (int i=0; i<nof+noe;i++){
            for(int j=0; j<nof+noe;j++){
                if(i<noe && j<noe){
                    Double  ODD[][] = globalVariables.getOD();
                    ODD[i][j]=(globalVariables.getODi()[i]*globalVariables.getODi()[j])*iep*1.0;
                    globalVariables.setOD(ODD);
                }
                if(i>=noe && j>=noe){
                    Double  ODD[][] = globalVariables.getOD();
                    ODD[i][j]=(globalVariables.getODi()[i]*globalVariables.getODi()[j])*ifp*1.0;
                    globalVariables.setOD(ODD);
                }
                if(i<noe && j>=noe){
                    Double  ODD[][] = globalVariables.getOD();
                    ODD[i][j]=(globalVariables.getODi()[i]*globalVariables.getODi()[j])*icp;
                    globalVariables.setOD(ODD);
                }
                if(i>=noe && j<noe){
                    Double  ODD[][] = globalVariables.getOD();
                    ODD[i][j]=(globalVariables.getODi()[i]*globalVariables.getODi()[j])*ogp;
                    globalVariables.setOD(ODD);
                }
            }
        }
////////////////////////////////////////////////////////////Taking the changes after zeroing the diagonal
        for (int i=0; i<noe+nof;i++){
            for(int j=0; j<noe+nof;j++){
                if(i<noe && j<noe && i==j){
                    Double  Sum11 = globalVariables.getSum1();
                    Sum11=Sum11+globalVariables.getOD()[i][j];
                    globalVariables.setSum1(Sum11);
                }
                if(i>=noe && j>=noe && i==j){
                    Double  Sum22= globalVariables.getSum2();
                    Sum22=Sum22+globalVariables.getOD()[i][j];
                    globalVariables.setSum2(Sum22);
                }

                if(i==j){
                    Double  ODDD[][] = globalVariables.getOD();
                    ODDD[i][i]=0.0;
                    globalVariables.setOD(ODDD);}
            }
        }
////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////Normalizing
        for (int i=0; i<noe+nof;i++){
            for(int j=0; j<noe+nof;j++){
                if(i<noe && j<noe && i!=j && iep!=0.0){
                    Double  ODDD[][] = globalVariables.getOD();
                    ODDD[i][j]=globalVariables.getOD()[i][j]*iep/(iep-globalVariables.getSum1());
                    globalVariables.setOD(ODDD);
                }
                if(i>=noe && j>=noe && i!=j && ifp != 0.0){
                    Double  ODDD[][] = globalVariables.getOD();
                    ODDD[i][j]=globalVariables.getOD()[i][j]*ifp/(ifp-globalVariables.getSum2());
                    globalVariables.setOD(ODDD);
                }
            }
        }
        /////////////////////////////////////////////////////////////////////////////
        //////////////////CDF
        Double Sum3=0.0;
        globalVariables.setSum3(Sum3);
        Double  CDF[][] = new Double[noe+nof][noe+nof];   // Squre Matrix that will represent the CDF matrix which will be stored in CDFF
        globalVariables.setCDFF(CDF);
        ////This nested loop fills the matrix with zeros
        for (int i=0; i<noe+nof;i++){
            for(int j=0; j<noe+nof;j++){
                Double  ODFF[][] = globalVariables.getCDFF();
                ODFF[i][j]=0.0;
                globalVariables.setCDFF(ODFF);
            }
        }
       /////This nested loop calculates the CDF
        for (int i=0; i<noe+nof;i++){
            for(int j=0; j<noe+nof;j++){
                Double  ODF[][] = globalVariables.getCDFF();
                ODF[i][j]=globalVariables.getOD()[i][j]+globalVariables.getCDFF()[i][j];
                Double  Sum33= globalVariables.getSum3();
                Sum33=Sum33+ODF[i][j];
                globalVariables.setSum3(Sum33);
                ODF[i][j]= globalVariables.getSum3();
                globalVariables.getCDFF()[i][j]=globalVariables.getSum3();
                globalVariables.setCDFF(ODF);
            }
        }
        ///////////////////////////////////////////////////////////////////////////////////////////DONE
        //////////////////////////////////Creating Kinematics Matrix///////////////////////////////////
        globalVariables.setN(noe+nof);
        //This is for unequal floor heights
        if (he1>0.0){
        Double[] dtotal={globalVariables.getHe1(),he2,he3,he4,hf1,hf2,hf3,hf4,hf5,hf6,hf7,hf8};
        List<Double> list2 = new ArrayList<Double>(Arrays.asList(dtotal));
        list2.removeAll(Arrays.asList(Double.valueOf(0.0)));
        dtotal = list2.toArray(new Double[list2.size()]);
        globalVariables.setDtotal(dtotal);}

        ///This is for equal floor heights

        if (he1==0.0) {
            Double hf = height / globalVariables.getN();
            Double dtotal[] = new Double[globalVariables.getN()];
            Arrays.fill(dtotal, hf);
            globalVariables.setDtotal(dtotal);
            globalVariables.setHe1(hf);
        }
        ///////////////////////////////////
        Double[][] Distances= new Double[globalVariables.getN()][globalVariables.getN()];
        for (Double[] row: Distances)
            Arrays.fill(row, 0.0);
        globalVariables.setDistances(Distances);
        ///////////////////////////////////


        for(int i=0; i<globalVariables.getN()-1; i++){

            Double[][] Distancess=globalVariables.getDistances();
            for(int j=i+1; j<globalVariables.getN(); j++){
                Double sumOfDtotal=globalVariables.getDtotal()[j-1];
                for(int b=i; b<j-1;b++){
                    sumOfDtotal=sumOfDtotal+globalVariables.getDtotal()[b];
                }
                Distancess[i][j]=sumOfDtotal;
                Distancess[j][i]=sumOfDtotal;
            }
            globalVariables.setDistances(Distancess);
        }
//////////////////////////////////////////////////////////////////////End of Distance Matrix
        Double[][] Kinematics= new Double[globalVariables.getN()][globalVariables.getN()];
        for (Double[] row: Kinematics)
            Arrays.fill(row, 0.0);
        globalVariables.setKinematics(Kinematics);
        ///////////////////////////////////////////////////
        for(int pi=0; pi<globalVariables.getN()-1; pi++) {

            for (int pii = pi; pii < globalVariables.getN(); pii++) {
                Double[][] Kinematicss=globalVariables.getKinematics();



                if (globalVariables.getDistances()[pi][pii] > (globalVariables.getV() * acc * acc + jerk * globalVariables.getV() * globalVariables.getV()) / (acc * jerk)) {

                    Kinematicss[pi][pii] = globalVariables.getDistances()[pi][pii] / globalVariables.getV() + globalVariables.getV() / acc + acc / jerk;
                    Kinematicss[pii][pi] = Kinematicss[pi][pii];

                } else {
                    if (globalVariables.getDistances()[pi][pii] < (globalVariables.getV() * acc * acc + jerk * globalVariables.getV() * globalVariables.getV()) / (acc * jerk) && globalVariables.getDistances()[pi][pii] > (2 * acc * acc * acc) / (jerk * jerk)) {

                        Kinematicss[pi][pii] = (acc / jerk + sqrt(4 * globalVariables.getDistances()[pi][pii] / acc + (acc / jerk) * (acc / jerk)));
                        Kinematicss[pii][pi] = Kinematicss[pi][pii];

                    } else {

                        Kinematicss[pi][pii] = (Math.pow((32 * globalVariables.getDistances()[pi][pii] / jerk), 1.0 / 3.0));
                        Kinematicss[pii][pi] = Kinematicss[pi][pii];

                    }
                }
                globalVariables.setKinematics(Kinematicss);}
        }
        //////////////////////////////////////////////////////////////////////End of Kinematics Matrix

        ////////////////////////////////Monte Carlo Simulation//////////////////////////////////////

        globalVariables.setP((ar*Utotal/30000)*intt);
        Double RTT=0.0;
        globalVariables.setRTT(RTT);
        globalVariables.setSocc((int) Math.ceil((globalVariables.getP())));
////////////////////////////////////////////////////////////
        //////////////////////////////////Main Loop
        Integer origin[] = new Integer[globalVariables.getSocc()];
        Integer destination[] = new Integer[globalVariables.getSocc()];
        Arrays.fill(origin, -1);
        Arrays.fill(destination, -1);
        globalVariables.setDestination(destination);
        globalVariables.setOrigin(origin);
        Double Sum4=0.0;
        globalVariables.setFloorTravelTime(Sum4);
        for(int k=0; k<trials ; k++) {

            for (int m = 0; m < globalVariables.getSocc(); m++) {
                Random r = new Random();
                globalVariables.setRandDes(r.nextDouble());
                for (int i=0; i<nof+noe;i++){
                    for (int j = 0; j < nof+noe; j++) {

                        if (globalVariables.getRandDes() < globalVariables.getCDFF()[i][j] && globalVariables.getDestination()[m]<0 && globalVariables.getOrigin()[m]<0) {
                            Integer[] destinationn = globalVariables.getDestination();
                            destinationn[m] = i;
                            globalVariables.setDestination(destinationn);
                            /////////
                            Integer[] originn = globalVariables.getOrigin();
                            originn[m] = j;
                            globalVariables.setOrigin(originn);
                            /////////////////
                        }
                    }
                }
                Integer[] OriginDestination = ArrayUtils.addAll(globalVariables.getOrigin(), globalVariables.getDestination());
                Arrays.sort(OriginDestination);
                globalVariables.setOriginDestination(OriginDestination); ///////////////// Getting Unique values only and zeroing the duplicates.
                for (int i = 0; i<globalVariables.getOriginDestination().length;i++){
                    if(i!=globalVariables.getOriginDestination().length-1){
                        if(globalVariables.getOriginDestination()[i]==globalVariables.getOriginDestination()[i+1] ){
                            Integer[] OriginDestinationn = globalVariables.getOriginDestination();
                            OriginDestinationn[i+1] = 0;
                            globalVariables.setOriginDestinationn(OriginDestinationn);}
                    }
                }

                List<Integer> list4 = new ArrayList<Integer>(Arrays.asList(globalVariables.getOriginDestinationn())); /////// Eliminating the zeros from the OD
                list4.removeAll(Arrays.asList(Integer.valueOf(0)));
                globalVariables.setOriginDestination(list4.toArray(new Integer[list4.size()]));
                /////////////////////////////////////////////////////////////////////////////////////////



                }
            for (int i = 0; i<globalVariables.getOriginDestination().length;i++){
                if(i!=globalVariables.getOriginDestination().length-1){
                    Double  Sum44= globalVariables.getFloorTravelTime();
                    Sum44=Sum44+globalVariables.getKinematics()[globalVariables.getOriginDestination()[i]][globalVariables.getOriginDestination()[i+1]];
                    globalVariables.setFloorTravelTime(Sum44);
                }
            }
            globalVariables.setStopsTime(globalVariables.getOriginDestination().length*(tdo+tdc));
            globalVariables.setPassengersInOutTime(globalVariables.getSocc()*(tpi+tpo));
            Double RTT2= globalVariables.getRTT();
            RTT2 = RTT2+globalVariables.getFloorTravelTime()+globalVariables.getStopsTime()+globalVariables.getPassengersInOutTime();
            globalVariables.setRTT(RTT2);
            globalVariables.setFloorTravelTime(0.0);
            globalVariables.setStopsTime(0.0);
            globalVariables.setPassengersInOutTime(0.0);
        }
            Double RTT3= globalVariables.getRTT();
            RTT3 = RTT3/globalVariables.getTrials();
            globalVariables.setRTT(RTT3);

                /////////////////////////////////////////////////////////////////////////////////////////


/////////////////////////////////////////////////////End of MCS///////////////////////////////////////////////////////////
                //.................................................................................//
        //////////////////////////////////////////////////////////////////////////////////////////////////////
                   //........................................................................//
                      /////////////////////////////////////////////////////////////////////

///////////////////////////////////Number of Elevators
        Double NL=((ar*Utotal*globalVariables.getRTT())/(30000*globalVariables.getSocc()));
        globalVariables.setNL(NL);
        globalVariables.setNumberOfElevator((int) Math.ceil(globalVariables.getNL()));

////////////////////////////////////////////////////////////////////Done
//////////////////////Actual Interval
        Double INTactual= globalVariables.getRTT()/globalVariables.getNumberOfElevator();
        globalVariables.setINTact(INTactual);
/////////////////////////////////////////////////////////Done

        //////////////////////Handling Capacity
        Double HC= ((300*globalVariables.getNumberOfElevator()*globalVariables.getSocc())/(globalVariables.getRTT()*Utotal))*100;
        globalVariables.setHC(HC);


        //////////////////////Car Capacity
        Integer[] CCR10 = {8, 10, 13, 17, 20, 26, 33};
        Double ccc=(globalVariables.getSocc()/0.8)+1;
        globalVariables.setCC((int) Math.ceil(ccc));
Integer smallestIndex=0;
        Integer[] CCR10n = {abs(8 - globalVariables.getCC()),abs(10 - globalVariables.getCC()),abs(13 - globalVariables.getCC()),abs(17 - globalVariables.getCC()),abs(20 - globalVariables.getCC()),abs(26 - globalVariables.getCC()),abs(33 - globalVariables.getCC())} ;
        for (int j=0; j < CCR10n.length; j++) {
            if (CCR10n[j] < CCR10n[smallestIndex]){
                smallestIndex = j;
            }}
        Integer CCn = CCR10[smallestIndex];
        globalVariables.setCC(CCn);




/////////////////////////////////////////////////////////Done




////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////Setting the Results/////////////////////////////////////////////////////
rtt.setText(String.valueOf(Math.floor(globalVariables.getRTT() * 100) / 100)+" s");
velocity.setText(String.valueOf(globalVariables.getV())+ " m/s");
numberofelevators.setText(String.valueOf(globalVariables.getNumberOfElevator())+ " Elevators");
intact.setText(String.valueOf(Math.floor(globalVariables.getINTact() * 100) / 100)+" s");
hc.setText(String.valueOf(Math.floor(globalVariables.getHC() * 100) / 100)+" %");
        cc.setText(String.valueOf(globalVariables.getCC())+ " Passengers");

////////////////////////////////////////////Real Life Iterations
        FloatingActionButton real =(FloatingActionButton)findViewById(R.id.real);
        real.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                globalVariables.setP((globalVariables.getRTT()/globalVariables.getNumberOfElevator())*(globalVariables.getINTact()*Utotal/30000));
                globalVariables.setSocc((int) Math.ceil((globalVariables.getP())));
                while (((300*globalVariables.getNumberOfElevator()*globalVariables.getSocc())/(globalVariables.getRTT()*Utotal))*100-ar>0.1){
                    Double HC= ((300*globalVariables.getNumberOfElevator()*globalVariables.getSocc())/(globalVariables.getRTT()*Utotal))*100;

                    //////////////////////Handling Capacity
                        globalVariables.setHC(HC);
                    globalVariables.setP((globalVariables.getRTT()/globalVariables.getNumberOfElevator())*(globalVariables.getINTact()*Utotal/30000));
                    globalVariables.setSocc((int) Math.ceil((globalVariables.getP())));
////////////////////////////////////////////////////////////
                    //////////////////////////////////Main Loop
                    Integer origin[] = new Integer[globalVariables.getSocc()];
                    Integer destination[] = new Integer[globalVariables.getSocc()];
                    Arrays.fill(origin, -1);
                    Arrays.fill(destination, -1);
                    globalVariables.setDestination(destination);
                    globalVariables.setOrigin(origin);
                    Double Sum4=0.0;
                    globalVariables.setFloorTravelTime(Sum4);
                    for(int k=0; k<trials ; k++) {

                        for (int m = 0; m < globalVariables.getSocc(); m++) {
                            Random r = new Random();
                            globalVariables.setRandDes(r.nextDouble());
                            for (int i=0; i<nof+noe;i++){
                                for (int j = 0; j < nof+noe; j++) {

                                    if (globalVariables.getRandDes() < globalVariables.getCDFF()[i][j] && globalVariables.getDestination()[m]<0 && globalVariables.getOrigin()[m]<0) {
                                        Integer[] destinationn = globalVariables.getDestination();
                                        destinationn[m] = i;
                                        globalVariables.setDestination(destinationn);
                                        /////////
                                        Integer[] originn = globalVariables.getOrigin();
                                        originn[m] = j;
                                        globalVariables.setOrigin(originn);
                                        /////////////////
                                    }
                                }
                            }
                            Integer[] OriginDestination = ArrayUtils.addAll(globalVariables.getOrigin(), globalVariables.getDestination());
                            Arrays.sort(OriginDestination);
                            globalVariables.setOriginDestination(OriginDestination); ///////////////// Getting Unique values only and zeroing the duplicates.
                            for (int i = 0; i<globalVariables.getOriginDestination().length;i++){
                                if(i!=globalVariables.getOriginDestination().length-1){
                                    if(globalVariables.getOriginDestination()[i]==globalVariables.getOriginDestination()[i+1] ){
                                        Integer[] OriginDestinationn = globalVariables.getOriginDestination();
                                        OriginDestinationn[i+1] = 0;
                                        globalVariables.setOriginDestinationn(OriginDestinationn);}
                                }
                            }

                            List<Integer> list4 = new ArrayList<Integer>(Arrays.asList(globalVariables.getOriginDestinationn())); /////// Eliminating the zeros from the OD
                            list4.removeAll(Arrays.asList(Integer.valueOf(0)));
                            globalVariables.setOriginDestination(list4.toArray(new Integer[list4.size()]));
                            /////////////////////////////////////////////////////////////////////////////////////////



                        }
                        for (int i = 0; i<globalVariables.getOriginDestination().length;i++){
                            if(i!=globalVariables.getOriginDestination().length-1){
                                Double  Sum44= globalVariables.getFloorTravelTime();
                                Sum44=Sum44+globalVariables.getKinematics()[globalVariables.getOriginDestination()[i]][globalVariables.getOriginDestination()[i+1]];
                                globalVariables.setFloorTravelTime(Sum44);
                            }
                        }
                        globalVariables.setStopsTime(globalVariables.getOriginDestination().length*(tdo+tdc));
                        globalVariables.setPassengersInOutTime(globalVariables.getSocc()*(tpi+tpo));
                        Double RTT2= globalVariables.getRTT();
                        RTT2 = RTT2+globalVariables.getFloorTravelTime()+globalVariables.getStopsTime()+globalVariables.getPassengersInOutTime();
                        globalVariables.setRTT(RTT2);
                        globalVariables.setFloorTravelTime(0.0);
                        globalVariables.setStopsTime(0.0);
                        globalVariables.setPassengersInOutTime(0.0);
                    }
                    Double RTT3= globalVariables.getRTT();
                    RTT3 = RTT3/globalVariables.getTrials();
                    globalVariables.setRTT(RTT3);

                    /////////////////////////////////////////////////////////////////////////////////////////


/////////////////////////////////////////////////////End of MCS///////////////////////////////////////////////////////////
                    //.................................................................................//
                    //////////////////////////////////////////////////////////////////////////////////////////////////////
                    //........................................................................//
                    /////////////////////////////////////////////////////////////////////

//////////////////////Actual Interval
                    Double INTactual= globalVariables.getRTT()/globalVariables.getNumberOfElevator();
                    globalVariables.setINTact(INTactual);
/////////////////////////////////////////////////////////Done




                    //////////////////////Car Capacity
                    Integer[] CCR10 = {8, 10, 13, 17, 20, 26, 33};
                    Double ccc=(globalVariables.getSocc()/0.8)+1;
                    globalVariables.setCC((int) Math.ceil(ccc));
                    Integer smallestIndex=0;
                    Integer[] CCR10n = {abs(8 - globalVariables.getCC()),abs(10 - globalVariables.getCC()),abs(13 - globalVariables.getCC()),abs(17 - globalVariables.getCC()),abs(20 - globalVariables.getCC()),abs(26 - globalVariables.getCC()),abs(33 - globalVariables.getCC())} ;
                    for (int j=0; j < CCR10n.length; j++) {
                        if (CCR10n[j] < CCR10n[smallestIndex]){
                            smallestIndex = j;
                        }}
                    Integer CCn = CCR10[smallestIndex];
                    globalVariables.setCC(CCn);

/////////////////////////////////////////////////////////Done

                }
                ////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////Setting the Results/////////////////////////////////////////////////////
                rtt.setText(String.valueOf(Math.floor(globalVariables.getRTT() * 100) / 100)+" s");
                velocity.setText(String.valueOf(globalVariables.getV())+ " m/s");
                numberofelevators.setText(String.valueOf(globalVariables.getNumberOfElevator())+ " Elevators");
                intact.setText(String.valueOf(Math.floor(globalVariables.getINTact() * 100) / 100)+" s");
                hc.setText(String.valueOf(Math.floor(globalVariables.getHC() * 100) / 100)+" %");
                cc.setText(String.valueOf(globalVariables.getCC())+ " Passengers");
        }});



    }
    public static Integer countUnique(Integer[] array) {
        if (array.length == 0) {
            return 0;
        }
        Integer count = 1;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] != array[i + 1]) {
                count++;
            }
        }
        return count;
    }}

