package com.pp.dcasajus.forkpoint.LocalDetall.ContingutLocal;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.pp.dcasajus.forkpoint.LocalDetall.Local;
import com.pp.dcasajus.forkpoint.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by denisplata on 18/02/2016.
 */
public class Opinions extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detall_opinions, container, false);
        Local local = (Local) getArguments().getParcelable("local");
/*


        ArrayAdapter arrayAdapter;
        ListView lv= (ListView) view.findViewById(R.id.listviewCom);

        String[] coments = {local.getComentaris()};

        String[] from = { "php_key","c_key","android_key","hacking_key" };

        arrayAdapter = new ArrayAdapter(this,R.layout.fragment_detall_opinions_adapt, R.id.coment, from);

        lv.setAdapter(arrayAdapter);*/

        return view;
    }
}