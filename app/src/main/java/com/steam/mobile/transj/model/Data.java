package com.steam.mobile.transj.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by heriman on 3/10/15.
 */
public class Data<T> implements Serializable {

    @SerializedName("result")
    private List<T> result;
    @SerializedName("error")
    private String error;

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
