package com.pp.dcasajus.forkpoint.ForkMeter;

/**
 * Created by denisplata on 17/02/2016.
 */

import java.text.DecimalFormat;
import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pp.dcasajus.forkpoint.R;

public class CustomAdapter extends BaseAdapter {

    Context context;
    List<RowItem> rowItem;

    CustomAdapter(Context context, List<RowItem> rowItem) {
        this.context = context;
        this.rowItem = rowItem;

    }

    @Override
    public int getCount() {

        return rowItem.size();
    }

    @Override
    public Object getItem(int position) {

        return rowItem.get(position);
    }

    @Override
    public long getItemId(int position) {

        return rowItem.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.forkmeter_list_item, null);
        }

        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.title);
        TextView txtCarrer = (TextView) convertView.findViewById(R.id.carrer);
        TextView txtPreu = (TextView) convertView.findViewById(R.id.preulocal);
        TextView txtdistancia = (TextView) convertView.findViewById(R.id.localitzacio);
        TextView txtlabeldistancia = (TextView) convertView.findViewById(R.id.dist);



        RowItem row_pos = rowItem.get(position);
        // setting the image resource and title

        imgIcon.setImageResource(row_pos.getIcon());
        txtTitle.setText(row_pos.getTitle());
        txtCarrer.setText(row_pos.getCarrer());
        String euro = "\u20ac";
        txtPreu.setText(row_pos.getPreu()+euro);

        double latitude= 41.6175899;
        double longitude= 0.6200145999999904;

        float distance=0;
        Location crntLocation=new Location("crntlocation");
        crntLocation.setLatitude(row_pos.getLat());
        crntLocation.setLongitude(row_pos.getLon());

        if(row_pos.getLat()==0.0){
            txtlabeldistancia.setText("Ubicació no disponible");
            txtlabeldistancia.setTextColor(Color.parseColor("#B40404"));
        } else {
            Location newLocation = new Location("newlocation");
            newLocation.setLatitude(latitude);
            newLocation.setLongitude(longitude);
            //float distance = crntLocation.distanceTo(newLocation);  in meters
            distance = crntLocation.distanceTo(newLocation) / 1000; // in km
            DecimalFormat df = new DecimalFormat("0.00");
            String text = df.format(distance);
            txtdistancia.setText(text + " km");
        }

        return convertView;

    }

}