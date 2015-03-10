package com.steam.mobile.transj.service;

import android.content.Context;

import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;

import java.io.IOException;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by heriman on 3/10/15.
 */
public class BaseConnection {

    private Context context;
    private OkHttpClient okHttpClient;
    private RestAdapter adapter;

    public BaseConnection(Context context) {
        this.context = context;


        try{
            okHttpClient = new OkHttpClient();
            Cache cache = new Cache(context.getCacheDir(), 1024 * 2);
            okHttpClient.setCache(cache);

        }catch (IOException e){

        }


        adapter = new RestAdapter.Builder()
                .setEndpoint("http://itsjakarta.com")
                .setClient(new OkClient(okHttpClient))
                .setRequestInterceptor(interceptor)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
    }
    protected RequestInterceptor interceptor = new RequestInterceptor() {
        @Override
        public void intercept(RequestFacade request) {
            request.addHeader("Accept", "application/json");
        }
    };
    public RestAdapter getAdapter() {
        return adapter;
    }
}
