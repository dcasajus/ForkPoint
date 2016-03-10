package com.pp.dcasajus.forkpoint.Opcions;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import com.pp.dcasajus.forkpoint.MainContent.MainActivity;
import com.pp.dcasajus.forkpoint.R;

/**
 * Created by denisplata on 01/03/2016.
 */
public class OpcionsFragment extends Fragment {
    CheckBox checkNot;
    CheckBox checkUser;
    SharedPreferences sharedpreferences;

    public OpcionsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_opcions, container, false);
        sharedpreferences = getActivity().getSharedPreferences("Opcions", Context.MODE_PRIVATE);
        boolean not =sharedpreferences .getBoolean("Not",false);
        boolean user =sharedpreferences .getBoolean("User",false);

        checkNot = (CheckBox)view.findViewById(R.id.notcheck);
        checkNot.setChecked(not);

        checkUser = (CheckBox)view.findViewById(R.id.usercheck);
        checkUser.setChecked(user);

        Button button = (Button) view.findViewById(R.id.buttonSave);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean("User", checkUser.isChecked());
                editor.putBoolean("Not", checkNot.isChecked());
                editor.commit();

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

}
