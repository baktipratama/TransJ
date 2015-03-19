package com.steam.mobile.transj.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.steam.mobile.transj.R;
import com.steam.mobile.transj.controller.HalteController;
import com.steam.mobile.transj.controller.IncomingController;
import com.steam.mobile.transj.model.Incoming;
import com.steam.mobile.transj.model.Station;
import com.steam.mobile.transj.response.IResponse;
import com.steam.mobile.transj.view.adapter.HalteArrayAdapter;
import com.steam.mobile.transj.view.adapter.IncomingArrayAdapter;

import java.util.List;

/**
 * Created by bakti on 3/19/15.
 */
public class IncomingFragment extends BaseFragment {
    private IncomingController incomingController;
    private ListView lvData;
    private Station s;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        incomingController = IncomingController.getInstance(getActivity().getApplicationContext());
        s = (Station)getActivity().getIntent().getExtras().get("station");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_list, container, false);
        lvData = (ListView) root.findViewById(R.id.lvData);
        lvData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Station station = (Station)parent.getItemAtPosition(position);
                Toast.makeText(getActivity().getApplicationContext(), station.getHalteId(), Toast.LENGTH_LONG).show();
            }
        });
        loadAllData();
        return root;
    }

    public void loadAllData(){
        showProgressDialog("Load Halte","Loading");
        incomingController.getAllIncoming(new IResponse() {
            @Override
            public void onSuccess(Object o) {
                dismissProgressDialog();
                setAdapter(new IncomingArrayAdapter(getActivity().getBaseContext(), (List<Incoming>) o));
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
        }, s.getKoridor(), s.getHalteId());
    }
    public void setAdapter(IncomingArrayAdapter adapter){
        lvData.setAdapter(adapter);
    }
}
