package com.steam.mobile.transj.service;

import com.steam.mobile.transj.model.Data;
import com.steam.mobile.transj.model.Station;

import retrofit.http.GET;
import rx.Observable;

/**
 * Created by heriman on 3/10/15.
 */
public interface IApiService {

    @GET("/its/master_halte/4")
    public Observable<Data<Station>> getListStation();
}
