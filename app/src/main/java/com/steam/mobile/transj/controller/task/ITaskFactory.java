package com.steam.mobile.transj.controller.task;

import android.content.Context;

import com.steam.mobile.transj.response.IResponse;

/**
 * Created by heriman on 3/11/15.
 */
public interface ITaskFactory {
    public AsynchronousTask createRetrieveAllHalteTask(IResponse callback, Context context);
}
