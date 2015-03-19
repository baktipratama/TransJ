package com.steam.mobile.transj.controller.task;

import android.content.Context;

import com.steam.mobile.transj.model.Data;
import com.steam.mobile.transj.model.Station;
import com.steam.mobile.transj.response.IResponse;
import com.steam.mobile.transj.service.SingleService;

import java.util.Collections;
import java.util.Comparator;
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
        List<Station> list = wrapList(SingleService.getInstance(getContext()).getService().getSynchListStation("4").getResult(),"4");
        list.addAll(wrapList(SingleService.getInstance(getContext()).getService().getSynchListStation("5").getResult(),"5"));
        list.addAll(wrapList(SingleService.getInstance(getContext()).getService().getSynchListStation("6").getResult(),"6"));
        list.addAll(wrapList(SingleService.getInstance(getContext()).getService().getSynchListStation("8").getResult(),"8"));
        list.addAll(wrapList(SingleService.getInstance(getContext()).getService().getSynchListStation("8A").getResult(),"8A"));
        Collections.sort(list,new StationComparator());
        return list;
    }
    private class StationComparator implements Comparator<Station> {

        @Override
        public int compare(Station lhs, Station rhs) {
            return lhs.getHalteName().compareTo(rhs.getHalteName());
        }

        @Override
        public boolean equals(Object object) {
            return false;
        }
    }
    private List<Station> wrapList(List<Station> list, String koridor){
        for(Station s:list){
            s.setKoridor(koridor);
        }
        return list;
    }
}
