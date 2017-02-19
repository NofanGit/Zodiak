package com.example.aminsuyanto.tes.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by amin suyanto on 19-Feb-17.
 */

public class mingguanModel {
    @SerializedName("umum")
    @Expose
    private String umum;

    @SerializedName("percintaan")
    @Expose percintaanModel percintaan;

    public String getKarir_keuangan() {
        return karir_keuangan;
    }

    public void setKarir_keuangan(String karir_keuangan) {
        this.karir_keuangan = karir_keuangan;
    }

    public String getUmum() {
        return umum;
    }

    public void setUmum(String umum) {
        this.umum = umum;
    }

    public percintaanModel getPercintaan() {
        return percintaan;
    }

    public void setPercintaan(percintaanModel percintaan) {
        this.percintaan = percintaan;
    }

    @SerializedName("karir_keuangan")

    @Expose String karir_keuangan;

}
