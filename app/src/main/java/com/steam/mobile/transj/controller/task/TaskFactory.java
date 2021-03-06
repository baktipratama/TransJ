package com.steam.mobile.transj.controller.task;

import android.content.Context;

import com.steam.mobile.transj.response.IResponse;

/**
 * Created by heriman on 3/11/15.
 */
public class TaskFactory implements ITaskFactory {
    @Override
    public AsynchronousTask createRetrieveAllHalteTask(IResponse callback, Context context) {
        return new RetrieveAllHalteTask(callback,context);
    }

    @Override
    public AsynchronousTask createRetrieveAllIncomingTask(IResponse callback, Context context, String koridor, String id) {
        return new RetrieveAllIncoming(callback,context,koridor,id);
    }

}
