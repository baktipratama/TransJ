package com.steam.mobile.transj.service;

import android.content.Context;

/**
 * Created by heriman on 3/11/15.
 */
public class SingleService extends BaseConnection {

    private static SingleService instance;
    private IApiService service;

    public SingleService(Context context){
        super(context);
        service = getAdapter().create(IApiService.class);
    }

    public static SingleService getInstance(Context context){
        if(instance==null)
            instance = new SingleService(context);
        return instance;
    }
    public IApiService getService(){
        return service;
    }
}
