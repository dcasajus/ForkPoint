package com.pp.dcasajus.forkpoint.Perfil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pp.dcasajus.forkpoint.ForkMeter.ForkMeterFragment;
import com.pp.dcasajus.forkpoint.LocalDetall.LocalDetall;
import com.pp.dcasajus.forkpoint.MainContent.MainActivity;
import com.pp.dcasajus.forkpoint.R;

/**
 * Created by denisplata on 23/02/2016.
 */
public class RegisterFragment extends Fragment {

    public RegisterFragment() {
        // Required empty public constructor
    }
    TextView register;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        register = (TextView) view.findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        return view;


    }
}