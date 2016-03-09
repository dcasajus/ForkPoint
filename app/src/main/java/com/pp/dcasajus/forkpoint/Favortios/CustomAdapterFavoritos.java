package com.pp.dcasajus.forkpoint.Favortios;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pp.dcasajus.forkpoint.R;

import java.util.List;

/**
 * Created by denisplata on 02/03/2016.
 */
public class CustomAdapterFavoritos  extends BaseAdapter {
    Context context;
    List<RowItemFavoritos> rowItem;

    CustomAdapterFavoritos(Context context, List<RowItemFavoritos> rowItem) {
        this.context = context;
        this.rowItem = rowItem;

    }

    public int getCount() {

        return rowItem.size();
    }


    public Object getItem(int position) {

        return rowItem.get(position);
    }


    public long getItemId(int position) {

        return rowItem.indexOf(getItem(position));
    }


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

        RowItemFavoritos row_pos = rowItem.get(position);
        // setting the image resource and title
        imgIcon.setImageResource(row_pos.getIcon());
        txtTitle.setText(row_pos.getTitle());
        txtCarrer.setText(row_pos.getCarrer());
        txtPreu.setText(row_pos.getPreu());

        return convertView;

    }

}

