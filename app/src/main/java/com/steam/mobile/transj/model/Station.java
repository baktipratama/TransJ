package com.steam.mobile.transj.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by heriman on 3/10/15.
 */
public class Station implements Serializable {

    @SerializedName("HalteId")
    private String halteId;
    @SerializedName("HalteName")
    private String halteName;

    public String getHalteId() {
        return halteId;
    }

    public void setHalteId(String halteId) {
        this.halteId = halteId;
    }

    public String getHalteName() {
        return halteName;
    }

    public void setHalteName(String halteName) {
        this.halteName = halteName;
    }
}
