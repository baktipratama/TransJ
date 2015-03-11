package com.steam.mobile.transj.controller;

import android.content.Context;

import com.steam.mobile.transj.model.Data;
import com.steam.mobile.transj.model.Station;
import com.steam.mobile.transj.response.IResponse;
import com.steam.mobile.transj.service.IApiService;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by heriman on 3/11/15.
 */
public class HalteController extends BaseConnection {
    private static HalteController instance;
    private IApiService service;
    public HalteController(Context context){
        super(context);
        service = getAdapter().create(IApiService.class);
    }
    public static HalteController getInstance(Context context){
        if(instance==null)
            instance = new HalteController(context);
        return instance;
    }
    public void getAllHalte(final IResponse response, int id){
        service.getListStation(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Data<Station>>() {
                               @Override
                               public void call(Data<Station> data) {
                                    response.onSuccess(data);
                               }
                           },
                        new Action1<Throwable>() {
                            @Override
                            public void call(Throwable throwable) {
                                response.onError(throwable);
                            }
                        },
                        new Action0() {
                            @Override
                            public void call() {
                                response.onFinish();
                            }
                        }
                );
    }
}
