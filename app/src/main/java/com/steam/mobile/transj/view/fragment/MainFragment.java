package com.steam.mobile.transj.view.fragment;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.steam.mobile.transj.R;
import com.steam.mobile.transj.controller.HalteController;
import com.steam.mobile.transj.model.Data;
import com.steam.mobile.transj.model.Station;
import com.steam.mobile.transj.response.IResponse;

import java.util.ArrayList;

/**
 * Created by heriman on 3/11/15.
 */
public class MainFragment extends Fragment {
    HalteController halteController;
    ListView lvData;

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
        final ProgressDialog progress = ProgressDialog.show(getActivity(), "dialog title",
                "dialog message", true);
        halteController.getAllHalte(new IResponse() {
            @Override
            public void onSuccess(Object o) {
                progress.dismiss();
                Data<Station> data = (Data<Station>) o;
                ArrayList<String> list = new ArrayList<String>();
                for(Station s : data.getResult()){
                    list.add(s.getHalteName());
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getBaseContext(),android.R.layout.simple_list_item_1,list);
                lvData.setAdapter(adapter);
            }

            @Override
            public void onError(Object o) {
                Throwable t = (Throwable) o;
                Toast.makeText(getActivity().getBaseContext(), ((Throwable) o).getMessage(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFinish() {

            }
        },4);
    }
}
