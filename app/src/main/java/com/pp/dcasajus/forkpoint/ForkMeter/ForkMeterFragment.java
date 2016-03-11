package com.pp.dcasajus.forkpoint.ForkMeter;

/**
 * Created by denisplata on 09/02/2016.
 */

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.pp.dcasajus.forkpoint.LocalDetall.Local;
import com.pp.dcasajus.forkpoint.LocalDetall.LocalDetall;
import com.pp.dcasajus.forkpoint.R;
import com.pp.dcasajus.forkpoint.Serveis.LocationSave;

import java.util.ArrayList;
import java.util.List;

public class ForkMeterFragment extends ListFragment implements AdapterView.OnItemClickListener {


    String[] titles;
    TypedArray Icons;
    String[] carrers;
    String[] edatmin;
    String[] horari;
    String descripcio;
    double lat;
    double lon;

    CustomAdapter adapter;
    private List<RowItem> rowItems;

    public ForkMeterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_forkmeter, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        boolean notLocation = false;
        Bundle args = getArguments();
        if (args != null) {
            lat = args.getDouble("latitud");
            lon = args.getDouble("longitud");
        }
        titles = getResources().getStringArray(R.array.Locales);
        Icons = getResources().obtainTypedArray(R.array.icons);
        carrers = getResources().getStringArray(R.array.carrers);
        edatmin = getResources().getStringArray(R.array.preulocal);
        horari = getResources().getStringArray(R.array.horari);
        descripcio = getResources().getString(R.string.descripcio);

        rowItems = new ArrayList<RowItem>();

        for (int i = 0; i < titles.length; i++) {
            RowItem items = new RowItem(titles[i], Icons.getResourceId(
                    i, -1), carrers[i],edatmin[i],lat,lon);

            rowItems.add(items);
        }

        adapter = new CustomAdapter(getActivity(), rowItems);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {

        Toast.makeText(getActivity(), titles[position], Toast.LENGTH_SHORT)
                .show();

        Local local = new Local(titles[position],carrers[position],edatmin[position],Icons.getResourceId(position, -1),0,horari[position],0,0,descripcio);
        Intent intent = new Intent(getActivity().getApplicationContext(), LocalDetall.class);
        intent.putExtra("localSelected", local);
        startActivity(intent);
    }

}