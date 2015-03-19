package com.steam.mobile.transj.controller;

import android.content.Context;

import com.steam.mobile.transj.controller.task.ITaskFactory;
import com.steam.mobile.transj.controller.task.TaskFactory;
import com.steam.mobile.transj.response.IResponse;

/**
 * Created by bakti on 3/19/15.
 */
public class IncomingController {

    private static IncomingController instance;
    private ITaskFactory taskFactory;
    private Context context;
    public IncomingController(Context context){
        this.context = context;
        taskFactory = new TaskFactory();
    }

    public static IncomingController getInstance(Context context){
        if(instance==null)
            instance = new IncomingController(context);
        return instance;
    }

    public void getAllIncoming(IResponse response, String koridor, String id){
        taskFactory.createRetrieveAllIncomingTask(response,context,koridor,id).execute();
    }
}
