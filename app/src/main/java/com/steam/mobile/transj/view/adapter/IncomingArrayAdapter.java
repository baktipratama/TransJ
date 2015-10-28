package com.steam.mobile.transj.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.steam.mobile.transj.R;
import com.steam.mobile.transj.model.Incoming;

import java.util.List;

/**
 * Created by bakti on 3/19/15.
 */
public class IncomingArrayAdapter extends ArrayAdapter<Incoming> {

    private List<Incoming> list;
    private Context context;

    public IncomingArrayAdapter(Context context, List<Incoming> objects) {
        super(context, R.layout.row_halte, objects);
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