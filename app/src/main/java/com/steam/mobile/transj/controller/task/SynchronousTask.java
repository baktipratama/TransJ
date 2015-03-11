package com.steam.mobile.transj.controller.task;

/**
 * Created by heriman on 3/11/15.
 */
public abstract class SynchronousTask<T> implements ITask<T> {
    private T mResult;
    public T execute(){
        try {
            mResult = process();
            return mResult;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
