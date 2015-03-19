package com.steam.mobile.transj.controller.task;

import android.content.Context;

import com.steam.mobile.transj.model.Incoming;
import com.steam.mobile.transj.model.Station;
import com.steam.mobile.transj.response.IResponse;
import com.steam.mobile.transj.service.SingleService;

import java.util.List;

/**
 * Created by bakti on 3/19/15.
 */
public class RetrieveAllIncoming extends AsynchronousTask<List<Incoming>> {
    private String koridor,id;
    public RetrieveAllIncoming(IResponse callback, Context context,String koridor,String id) {
        super(callback, context);
        this.koridor = koridor;
        this.id = id;
    }

    @Override
    public List<Incoming> process() throws Exception {
        return SingleService.getInstance(getContext()).getService().getSynchListIncoming(koridor,id).getResult();
    }
}
