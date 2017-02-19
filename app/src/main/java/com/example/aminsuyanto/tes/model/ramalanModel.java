package com.example.aminsuyanto.tes.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by amin suyanto on 19-Feb-17.
 */

public class ramalanModel {
    @SerializedName("harian")
    @Expose
    private harianModel harian;
    @SerializedName("mingguan")
    @Expose
    private mingguanModel mingguan;

    public harianModel getHarian() {
        return harian;
    }

    public void setHarian(harianModel harian) {
        this.harian = harian;
    }

    public mingguanModel getMingguan() {
        return mingguan;
    }

    public void setMingguan(mingguanModel mingguan) {
        this.mingguan = mingguan;
    }
}
