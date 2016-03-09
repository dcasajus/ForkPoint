package com.pp.dcasajus.forkpoint.LocalDetall.ContingutLocal;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pp.dcasajus.forkpoint.LocalDetall.Local;
import com.pp.dcasajus.forkpoint.R;

/**
 * Created by denisplata on 18/02/2016.
 */
public class Informacio extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detall_informacio, container, false);
        Local local = (Local) getArguments().getParcelable("local");
        TextView txtCarrer = (TextView) view.findViewById(R.id.textView);
        TextView txtHorari = (TextView) view.findViewById(R.id.horari);
        TextView txtDescrip = (TextView) view.findViewById(R.id.descripcio);
        txtCarrer.setText(local.getCarrer());
        txtHorari.setText(local.getHorari());
        txtDescrip.setText(local.getDescripcio());

        System.out.println(local);
        return view;
    }

}
