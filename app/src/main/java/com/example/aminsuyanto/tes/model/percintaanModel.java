package com.example.aminsuyanto.tes.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by amin suyanto on 19-Feb-17.
 */

public class percintaanModel {
    @SerializedName("single")
    @Expose String single;

    @SerializedName("couple")
    @Expose String couple;

    public String getSingle() {
        return single;
    }

    public void setSingle(String single) {
        this.single = single;
    }

    public String getCouple() {
        return couple;
    }

    public void setCouple(String couple) {
        this.couple = couple;
    }
}
