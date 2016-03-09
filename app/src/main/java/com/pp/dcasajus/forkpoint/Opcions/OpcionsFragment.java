package com.pp.dcasajus.forkpoint.Opcions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.pp.dcasajus.forkpoint.MainContent.MainActivity;
import com.pp.dcasajus.forkpoint.R;

/**
 * Created by denisplata on 01/03/2016.
 */
public class OpcionsFragment extends Fragment {

    public OpcionsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_opcions, container, false);

        Button button = (Button) view.findViewById(R.id.buttonSave);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

}
