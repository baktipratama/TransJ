package com.steam.mobile.transj.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.steam.mobile.transj.R;
import com.steam.mobile.transj.model.Station;

import java.util.List;

/**
 * Created by bakti on 3/19/15.
 */
public class HalteArrayAdapter extends ArrayAdapter<Station> {
    List<Station> list;
    Context context;
    public HalteArrayAdapter(Context context,List<Station> objects) {
        super(context,R.layout.row_halte,objects);
        list = objects;
        this.context = context;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row_halte, parent, false);
        TextView tvTitle= (TextView) rowView.findViewById(R.id.tvTitle);
        tvTitle.setText(list.get(position).getHalteName());
        return rowView;
    }
}
