package com.ju.mechatronics.erttc;

import android.app.Application;

/**
 * Created by Abdulkareem on 12/11/2017.
 */

public class GlobalVariables extends Application {
    private Double tdo,tdc,tdoor;

    private Double acc;
    private Double jerk;
    private Double height;
    private int noe;
    private int nof;
    private int N;
    private Double Doublet;
    private Double trials;
    private Double tpi;
    private Double tpo;
    private Double ar;
    private Double ic;
    private Double og;
    private Double ifp;
    private Double iep;
    private Double v;
    private Double he1,he2,he3,he4,hf1,hf2,hf3,hf4,hf5,hf6,hf7,hf8;
    private Double we1,we2,we3,we4;
    private Double u,nf1,nf2,nf3,nf4,nf5,nf6,nf7,nf8;
    private Double[] dtotal;
    private Double[][] Kinematics,Distances,OD,CDFF;
    private Double[] cdf,pdf,pdfe,ODi;
    private Double P;
    private Double randDes;
    private Integer[] destination,origin,trip,OriginDestination,OriginDestinationn;
    private Integer Socc;
private Double Sum1,Sum2,Sum3,floorTravelTime,StopsTime,PassengersInOutTime;
private Double RTT;
private Integer NumberOfElevator;
private Double NL;
private Double INTact,HC;
private Integer CC;
    private Double Check;
    private String Check2;

    public String getCheck2() {
        return Check2 ;
    }

    public void setCheck2(String check2) {
        Check2 = check2;
    }

    public Double getCheck() {
        return Check;
    }

    public void setCheck(Double check) {
        Check = check;
    }

    public Integer getCC() {
        return CC;
    }

    public void setCC(Integer CC) {
        this.CC = CC;
    }

    public Double getHC() {
        return HC;
    }

    public void setHC(Double HC) {
        this.HC = HC;
    }

    public Double getINTact() {
        return INTact;
    }

    public void setINTact(Double INTact) {
        this.INTact = INTact;
    }

    public Double getNL() {
        return NL;
    }

    public void setNL(Double NL) {
        this.NL = NL;
    }

    public Integer getNumberOfElevator() {
        return NumberOfElevator;
    }

    public void setNumberOfElevator(Integer numberOfElevator) {
        NumberOfElevator = numberOfElevator;
    }

    public Double getRTT() {
        return RTT;
    }

    public void setRTT(Double RTT) {
        this.RTT = RTT;
    }

    public Double getStopsTime() {
        return StopsTime;
    }

    public void setStopsTime(Double stopsTime) {
        StopsTime = stopsTime;
    }

    public Double getPassengersInOutTime() {
        return PassengersInOutTime;
    }

    public void setPassengersInOutTime(Double passengersInOutTime) {
        PassengersInOutTime = passengersInOutTime;
    }

    public Double getFloorTravelTime() {
        return floorTravelTime;
    }

    public void setFloorTravelTime(Double floorTravelTime) {
        this.floorTravelTime = floorTravelTime;
    }

    public Integer[] getOriginDestinationn() {
        return OriginDestinationn;
    }

    public void setOriginDestinationn(Integer[] originDestinationn) {
        OriginDestinationn = originDestinationn;
    }

    public Integer[] getOriginDestination() {
        return OriginDestination;
    }

    public void setOriginDestination(Integer[] originDestination) {
        OriginDestination = originDestination;
    }

    public Integer[] getTrip() {
        return trip;
    }

    public void setTrip(Integer[] trip) {
        this.trip = trip;
    }

    public Integer[] getOrigin() {
        return origin;
    }

    public void setOrigin(Integer[] origin) {
        this.origin = origin;
    }

    public Double getSum3() {
        return Sum3;
    }

    public void setSum3(Double sum3) {
        Sum3 = sum3;
    }

    public Double[][] getCDFF() {
        return CDFF;
    }

    public void setCDFF(Double[][] CDFF) {
        this.CDFF = CDFF;
    }

    public Double getSum1() {
        return Sum1;
    }

    public void setSum1(Double sum1) {
        Sum1 = sum1;
    }

    public Double getSum2() {
        return Sum2;
    }

    public void setSum2(Double sum2) {
        Sum2 = sum2;
    }

    public Double[] getODi() {
        return ODi;
    }

    public void setODi(Double[] ODi) {
        this.ODi = ODi;
    }

    public Double[][] getOD() {
        return OD;
    }

    public void setOD(Double[][] OD) {
        this.OD = OD;
    }

    public Double[] getPdfe() {
        return pdfe;
    }

    public void setPdfe(Double[] pdfe) {
        this.pdfe = pdfe;
    }

    public Double getHe4() {
        return he4;
    }

    public void setHe4(Double he4) {
        this.he4 = he4;
    }

    public Double getWe1() {
        return we1;
    }

    public void setWe1(Double we1) {
        this.we1 = we1;
    }

    public Double getWe2() {
        return we2;
    }

    public void setWe2(Double we2) {
        this.we2 = we2;
    }

    public Double getWe3() {
        return we3;
    }

    public void setWe3(Double we3) {
        this.we3 = we3;
    }

    public Double getWe4() {
        return we4;
    }

    public void setWe4(Double we4) {
        this.we4 = we4;
    }

    public Double getTdoor() {
        return tdoor;
    }

    public void setTdoor(Double tdoor) {
        this.tdoor = tdoor;
    }

    public Integer getSocc() {
        return Socc;
    }

    public void setSocc(Integer socc) {
        Socc = socc;
    }

    public Double getRandDes() {
        return randDes;
    }

    public void setRandDes(Double randDes) {
        this.randDes = randDes;
    }

    public Integer[] getDestination() {
        return destination;
    }

    public void setDestination(Integer[] destination) {
        this.destination = destination;
    }

    public Double getP() {
        return P;
    }

    public void setP(Double p) {
        P = p;
    }

    public Double[][] getDistances() {
        return Distances;
    }

    public void setDistances(Double[][] distances) {
        Distances = distances;
    }

    public int getN() {
        return N;
    }

    public void setN(int n) {
        N = n;
    }

    public Double[] getCdf() {
        return cdf;
    }

    public void setCdf(Double[] cdf) {
        this.cdf = cdf;
    }

    public Double[] getPdf() {
        return pdf;
    }

    public void setPdf(Double[] pdf) {
        this.pdf = pdf;
    }

    public Double[][] getKinematics() {
        return Kinematics;
    }

    public void setKinematics(Double[][] kinematics) {
        Kinematics = kinematics;
    }

    public Double[] getDtotal() {
        return dtotal;
    }

    public void setDtotal(Double[] dtotal) {
        this.dtotal = dtotal;
    }

    public Double getHe1() {
        return he1;
    }

    public void setHe1(Double he1) {
        this.he1 = he1;
    }

    public Double getHe2() {
        return he2;
    }

    public void setHe2(Double he2) {
        this.he2 = he2;
    }

    public Double getHe3() {
        return he3;
    }

    public void setHe3(Double he3) {
        this.he3 = he3;
    }

    public Double getHf1() {
        return hf1;
    }

    public void setHf1(Double hf1) {
        this.hf1 = hf1;
    }

    public Double getHf2() {
        return hf2;
    }

    public void setHf2(Double hf2) {
        this.hf2 = hf2;
    }

    public Double getHf3() {
        return hf3;
    }

    public void setHf3(Double hf3) {
        this.hf3 = hf3;
    }

    public Double getHf4() {
        return hf4;
    }

    public void setHf4(Double hf4) {
        this.hf4 = hf4;
    }

    public Double getHf5() {
        return hf5;
    }

    public void setHf5(Double hf5) {
        this.hf5 = hf5;
    }

    public Double getHf6() {
        return hf6;
    }

    public void setHf6(Double hf6) {
        this.hf6 = hf6;
    }

    public Double getHf7() {
        return hf7;
    }

    public void setHf7(Double hf7) {
        this.hf7 = hf7;
    }

    public Double getHf8() {
        return hf8;
    }

    public void setHf8(Double hf8) {
        this.hf8 = hf8;
    }

    public Double getNf1() {
        return nf1;
    }

    public void setNf1(Double nf1) {
        this.nf1 = nf1;
    }

    public Double getNf2() {
        return nf2;
    }

    public void setNf2(Double nf2) {
        this.nf2 = nf2;
    }

    public Double getNf3() {
        return nf3;
    }

    public void setNf3(Double nf3) {
        this.nf3 = nf3;
    }

    public Double getNf4() {
        return nf4;
    }

    public void setNf4(Double nf4) {
        this.nf4 = nf4;
    }

    public Double getNf5() {
        return nf5;
    }

    public void setNf5(Double nf5) {
        this.nf5 = nf5;
    }

    public Double getNf6() {
        return nf6;
    }

    public void setNf6(Double nf6) {
        this.nf6 = nf6;
    }

    public Double getNf7() {
        return nf7;
    }

    public void setNf7(Double nf7) {
        this.nf7 = nf7;
    }

    public Double getNf8() {
        return nf8;
    }

    public void setNf8(Double nf8) {
        this.nf8 = nf8;
    }

    public Double getV() {
        return v;
    }

    public void setV(Double v) {
        this.v = v;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getU() {
        return u;
    }

    public void setU(Double u) {
        this.u = u;
    }

    public Double getTpi() {
        return tpi;
    }

    public void setTpi(Double tpi) {
        this.tpi = tpi;
    }

    public Double getTpo() {
        return tpo;
    }

    public void setTpo(Double tpo) {
        this.tpo = tpo;
    }

    public Double getAr() {
        return ar;
    }

    public void setAr(Double ar) {
        this.ar = ar;
    }

    public Double getIc() {
        return ic;
    }

    public void setIc(Double ic) {
        this.ic = ic;
    }

    public Double getOg() {
        return og;
    }

    public void setOg(Double og) {
        this.og = og;
    }

    public Double getIfp() {
        return ifp;
    }

    public void setIfp(Double ifp) {
        this.ifp = ifp;
    }

    public Double getIep() {
        return iep;
    }

    public void setIep(Double iep) {
        this.iep = iep;
    }

    public int getNoe() {
        return noe;
    }

    public void setNoe(int noe) {
        this.noe = noe;
    }

    public int getNof() {
        return nof;
    }

    public void setNof(int nof) {
        this.nof = nof;
    }

    public Double getIntt() {
        return Doublet;
    }

    public void setIntt(Double Doublet) {
        this.Doublet = Doublet;
    }

    public Double getTrials() {
        return trials;
    }

    public void setTrials(Double trials) {
        this.trials = trials;
    }

    public Double getTdc() {
        return tdc;
    }

    public void setTdc(Double tdc) {
        this.tdc = tdc;
    }

    public Double getAcc() {
        return acc;
    }

    public void setAcc(Double acc) {
        this.acc = acc;
    }

    public Double getJerk() {
        return jerk;
    }

    public void setJerk(Double jerk) {
        this.jerk = jerk;
    }

    public Double getTdo() {
        return tdo;
    }

    public void setTdo(Double tdo) {
        this.tdo = tdo;
    }
}
