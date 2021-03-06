package com.steam.mobile.transj.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.steam.mobile.transj.R;
import com.steam.mobile.transj.controller.HalteController;
import com.steam.mobile.transj.model.Station;
import com.steam.mobile.transj.response.IResponse;
import com.steam.mobile.transj.view.IncomingActivity;
import com.steam.mobile.transj.view.adapter.HalteArrayAdapter;

import java.util.List;

/**
 * Created by heriman on 3/11/15.
 */
public class HalteFragment extends BaseFragment {
    HalteController halteController;
    ListView lvData;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        halteController = HalteController.getInstance(getActivity().getApplicationContext());
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_list, container, false);
        lvData = (ListView) root.findViewById(R.id.lvData);
        lvData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Station station = (Station)parent.getItemAtPosition(position);
                Intent i = new Intent(getActivity().getBaseContext(), IncomingActivity.class);
                i.putExtra("station",station);
                getActivity().startActivity(i);
            }
        });
        loadAllData();
        return root;
    }

    public void loadAllData(){
        showProgressDialog("Load Halte","Loading");
        halteController.getAllHalte(new IResponse() {
            @Override
            public void onSuccess(Object o) {
                dismissProgressDialog();
                setAdapter(new HalteArrayAdapter(getActivity().getBaseContext(), (List<Station>) o));
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
    public void setAdapter(HalteArrayAdapter adapter){
        lvData.setAdapter(adapter);
    }
}
