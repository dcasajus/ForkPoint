package com.pp.dcasajus.forkpoint.Favortios;

import android.content.Intent;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.pp.dcasajus.forkpoint.ForkMeter.CustomAdapter;
import com.pp.dcasajus.forkpoint.ForkMeter.RowItem;
import com.pp.dcasajus.forkpoint.LocalDetall.Local;
import com.pp.dcasajus.forkpoint.LocalDetall.LocalDetall;
import com.pp.dcasajus.forkpoint.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by denisplata on 09/02/2016.
 */
public class FavoritosFragment  extends ListFragment  {
    String titles;
    int Icons;
    String carrer;
    String preu;

    CustomAdapterFavoritos adapter;
    private List<RowItemFavoritos> rowItems;
    private FavoritosSQLite db ;
    public FavoritosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favoritos, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        db = new FavoritosSQLite(getActivity(), "Locals",null,1);
        SQLiteDatabase data = db.getWritableDatabase();
        Cursor cursor = data.rawQuery("SELECT * FROM Locals", null);

        rowItems = new ArrayList<RowItemFavoritos>();
        cursor.moveToFirst();

        while(!cursor.isAfterLast()) {
//            System.out.println(cursor.getString(1));
            titles = cursor.getString(1);
            Icons = cursor.getInt(2);
            carrer = cursor.getString(3);
            preu = cursor.getString(4);
            RowItemFavoritos items = new RowItemFavoritos(titles,Icons, carrer,preu);
            rowItems.add(items);
            cursor.moveToNext();
        }

        adapter = new CustomAdapterFavoritos(getActivity(), rowItems);
        setListAdapter(adapter);
        //getListView().setOnItemClickListener(this);

    }



    /*@Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {

        Toast.makeText(getActivity(), titles, Toast.LENGTH_SHORT)
                .show();

        Local local = new Local(titles,carrer,preu,Icons,1 );
        Intent intent = new Intent(getActivity().getApplicationContext(), LocalDetall.class);
        intent.putExtra("localSelected", local);
        startActivity(intent);
    }*/
}