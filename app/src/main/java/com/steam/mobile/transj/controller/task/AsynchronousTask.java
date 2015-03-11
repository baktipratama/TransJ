package com.steam.mobile.transj.controller.task;

import android.content.Context;
import android.os.AsyncTask;

import com.steam.mobile.transj.response.IResponse;

/**
 * Created by heriman on 3/11/15.
 */
public abstract class AsynchronousTask<T> extends AsyncTask<Void, Void, Void> implements ITask<T> {

    private final IResponse callback;
    private Exception mE;
    private T mResult;
    private Context context;

    public AsynchronousTask(final IResponse callback,Context context) {
        this.callback = callback;
        this.context = context;
    }

    @Override
    public Context getContext() {
        return context;
    }

    @Override
    protected Void doInBackground(Void... params) {
        try {
            mResult = process();
        }
        catch (Exception e) {
            mE = e;
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        invokeCallback();
    }

    /**
     * This method doesn't override {@link AsyncTask#execute}, but to execute it.
     * Problem : Object[] cannot be cast to Void[] in AsyncTask
     */
    public void execute() {
        super.execute();
    }

    private final void invokeCallback() {
        if(callback != null) {
            if(mE == null) {
                callback.onSuccess(mResult);
            }
            else {
                callback.onError(mE);
            }
        }
    }
}
