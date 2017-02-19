package com.example.aminsuyanto.tes.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by amin suyanto on 19-Feb-17.
 */

public class zodiakParcel implements Parcelable {
    String nama;
    String lahir;
    String usia;
    String zodiak;
    String harianumum;
    String hariancintasingle;
    String hariancintacouple;
    String hariankarir;
    String mingguanumum;

    public zodiakParcel(){

}
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getLahir() {
        return lahir;
    }

    public void setLahir(String lahir) {
        this.lahir = lahir;
    }

    public String getUsia() {
        return usia;
    }

    public void setUsia(String usia) {
        this.usia = usia;
    }

    public String getZodiak() {
        return zodiak;
    }

    public void setZodiak(String zodiak) {
        this.zodiak = zodiak;
    }

    public String getHarianumum() {
        return harianumum;
    }

    public void setHarianumum(String harianumum) {
        this.harianumum = harianumum;
    }

    public String getHariancintasingle() {
        return hariancintasingle;
    }

    public void setHariancintasingle(String hariancintasingle) {
        this.hariancintasingle = hariancintasingle;
    }

    public String getHariancintacouple() {
        return hariancintacouple;
    }

    public void setHariancintacouple(String hariancintacouple) {
        this.hariancintacouple = hariancintacouple;
    }

    public String getHariankarir() {
        return hariankarir;
    }

    public void setHariankarir(String hariankarir) {
        this.hariankarir = hariankarir;
    }

    public String getMingguanumum() {
        return mingguanumum;
    }

    public void setMingguanumum(String mingguanumum) {
        this.mingguanumum = mingguanumum;
    }

    protected zodiakParcel (Parcel in){
        nama = in.readString();
        lahir=in.readString();
        usia=in.readString();
        zodiak=in.readString();
        harianumum=in.readString();
        hariancintasingle=in.readString();
        hariancintacouple=in.readString();
        hariankarir=in.readString();
        mingguanumum=in.readString();
    }
    public static final Parcelable.Creator<zodiakParcel> CREATOR=new Parcelable.Creator<zodiakParcel>(){

        @Override
        public zodiakParcel createFromParcel(Parcel in) {
            return new zodiakParcel(in);
        }

        @Override
        public zodiakParcel[] newArray(int size) {
            return new zodiakParcel[size];
        }
    };
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flage) {
        parcel.writeString(nama);
        parcel.writeString(lahir);
        parcel.writeString(usia);
        parcel.writeString(zodiak);
        parcel.writeString(harianumum);
        parcel.writeString(hariancintasingle);
        parcel.writeString(hariancintacouple);
        parcel.writeString(hariankarir);
        parcel.writeString(mingguanumum);

    }
}
