package com.steam.mobile.transj.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.steam.mobile.transj.R;
import com.steam.mobile.transj.controller.HalteController;
import com.steam.mobile.transj.model.Station;
import com.steam.mobile.transj.response.IResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

/**
 * Created by heriman on 3/11/15.
 */
public class HalteFragment extends BaseFragment {
    HalteController halteController;
    ListView lvData;
    Handler handler;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        halteController = HalteController.getInstance(getActivity().getApplicationContext());
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        lvData = (ListView) root.findViewById(R.id.lvData);
        loadAllData();
        return root;
    }

    public void loadAllData(){
        showProgressDialog("Load Halte","Loading");
        halteController.getAllHalte(new IResponse() {
            @Override
            public void onSuccess(Object o) {
                dismissProgressDialog();
                List<Station> data = (List<Station>) o;
                ArrayList<String> list = new ArrayList<String>();
                for (Station s : data) {
                    list.add(s.getHalteName());
                }
                setAdapter(list);
            }

            @Override
            public void onError(Object o) {
                dismissProgressDialog();
                Exception t = (Exception) o;
                Toast.makeText(getActivity().getBaseContext(), ((Throwable) o).getMessage(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFinish() {

            }
        });
    }
    public void setAdapter(ArrayList<String> list){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getBaseContext(), android.R.layout.simple_list_item_1, list);
        lvData.setAdapter(adapter);

    }
}
