package com.steam.mobile.transj.controller;

import android.content.Context;
import com.steam.mobile.transj.controller.task.ITaskFactory;
import com.steam.mobile.transj.controller.task.TaskFactory;
import com.steam.mobile.transj.response.IResponse;


/**
 * Created by heriman on 3/11/15.
 */
public class HalteController {

    private static HalteController instance;
    private ITaskFactory taskFactory;
    private Context context;
    public HalteController(Context context){
        this.context = context;
        taskFactory = new TaskFactory();
    }

    public static HalteController getInstance(Context context){
        if(instance==null)
            instance = new HalteController(context);
        return instance;
    }

    public void getAllHalte(IResponse response){
       taskFactory.createRetrieveAllHalteTask(response,context).execute();
    }

}
