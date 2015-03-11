package com.steam.mobile.transj.service;

import com.steam.mobile.transj.model.Data;
import com.steam.mobile.transj.model.Station;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by heriman on 3/10/15.
 */
public interface IApiService {

    @GET("/its/master_halte/{id}")
    public Observable<Data<Station>> getListStation(@Path("id") int id);
}
