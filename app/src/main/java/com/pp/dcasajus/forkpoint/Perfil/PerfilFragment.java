package com.pp.dcasajus.forkpoint.Perfil;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pp.dcasajus.forkpoint.R;

/**
 * Created by denisplata on 09/02/2016.
 */
public class PerfilFragment extends Fragment {

    public PerfilFragment() {
        // Required empty public constructor
    }
    TextView register;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);

        register = (TextView) view.findViewById(R.id.textView5);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   // register.setText("2792");
                RegisterFragment fragment2 = new RegisterFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment1, fragment2);
                fragmentTransaction.commit();
            }
        });

        return view;


    }
}