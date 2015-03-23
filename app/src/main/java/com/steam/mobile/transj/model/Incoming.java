package com.steam.mobile.transj.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bakti on 3/19/15.
 */
public class Incoming {

    @SerializedName("HalteId")
    private String halteId;
    @SerializedName("HalteName")
    private String halteName;
    @SerializedName("long")
    private String longitude;
    @SerializedName("lat")
    private String latitude;

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    private String koridor;

    public String getHalteId() {
        return halteId;
    }

    public String getKoridor() {
        return koridor;
    }

    public void setKoridor(String koridor) {
        this.koridor = koridor;
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
