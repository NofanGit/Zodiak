package com.example.aminsuyanto.tes.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by amin suyanto on 19-Feb-17.
 */

public class zodiakModel implements Parcelable {
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("lahir")
    @Expose
    private String lahir;
    @SerializedName("usia")
    @Expose
    private String usia;
    @SerializedName("zodiak")
    @Expose
    private String zodiak;
    @SerializedName("ramalan")
    @Expose
    private ramalanModel ramalan;

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

    public ramalanModel getRamalan() {
        return ramalan;
    }

    public void setRamalan(ramalanModel ramalan) {
        this.ramalan = ramalan;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nama);
        parcel.writeString(lahir);
        parcel.writeString(usia);
        parcel.writeString(zodiak);
        parcel.writeValue(ramalan);

    }
    public static final Parcelable.Creator<zodiakModel> CREATOR = new Parcelable.Creator<zodiakModel>(){

        @Override
        public zodiakModel createFromParcel(Parcel in) {
            return new zodiakModel(in);
        }

        @Override
        public zodiakModel[] newArray(int i) {
            return new zodiakModel[i];
        }
    };
    protected zodiakModel(Parcel in){
        nama=in.readString();
        lahir=in.readString();
        usia=in.readString();
        zodiak=in.readString();
        ramalan=(ramalanModel)in.readValue(ramalanModel.class.getClassLoader());
}

        }
