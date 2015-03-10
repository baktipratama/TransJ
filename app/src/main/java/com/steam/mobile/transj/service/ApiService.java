package com.steam.mobile.transj.service;

import android.content.Context;
import android.widget.Toast;

import com.steam.mobile.transj.model.Data;
import com.steam.mobile.transj.model.Station;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by heriman on 3/10/15.
 */
public class ApiService extends BaseConnection{
    IApiService service;
    Context context;
    public ApiService(Context context){
        super(context);
        this.context = context;
        service = getAdapter().create(IApiService.class);
    }

    public void getStations(){
        service.getListStation().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Data<Station>>() {
                               @Override
                               public void call(Data<Station> data) {
                                    int a = 1;
                               }
                           },new Action1<Throwable>() {
                               @Override
                               public void call(Throwable throwable) {
                                    Toast.makeText(context,"Error ",Toast.LENGTH_LONG).show();
                               }
                           },
                        new Action0() {
                            @Override
                            public void call() {
                                Toast.makeText(context,"Finish",Toast.LENGTH_LONG).show();
                            }
                        }
                );
    }
}
