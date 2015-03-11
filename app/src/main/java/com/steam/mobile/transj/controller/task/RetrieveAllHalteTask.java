package com.steam.mobile.transj.controller.task;

import android.content.Context;

import com.steam.mobile.transj.model.Data;
import com.steam.mobile.transj.model.Station;
import com.steam.mobile.transj.response.IResponse;
import com.steam.mobile.transj.service.SingleService;

import java.util.List;

/**
 * Created by heriman on 3/11/15.
 */
public class RetrieveAllHalteTask extends AsynchronousTask<List<Station>> {

    public RetrieveAllHalteTask(IResponse callback, Context context) {
        super(callback, context);
    }

    @Override
    public List<Station> process() throws Exception {
        List<Station> list = SingleService.getInstance(getContext()).getService().getSynchListStation("4").getResult();
        list.addAll(SingleService.getInstance(getContext()).getService().getSynchListStation("5").getResult());
        list.addAll(SingleService.getInstance(getContext()).getService().getSynchListStation("6").getResult());
        list.addAll(SingleService.getInstance(getContext()).getService().getSynchListStation("8").getResult());
        list.addAll(SingleService.getInstance(getContext()).getService().getSynchListStation("8A").getResult());
        return list;
    }
}
