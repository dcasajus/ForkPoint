package com.pp.dcasajus.forkpoint.LocalDetall.ContingutLocal;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.pp.dcasajus.forkpoint.R;

/**
 * Created by denisplata on 18/02/2016.
 */
public class Photos extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detall_photos, container, false);

        GridView gridview = (GridView) view.findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(getActivity()));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                if (position == 0) {
                    if (getActivity().getApplicationContext().getPackageManager().hasSystemFeature(
                            PackageManager.FEATURE_CAMERA)) {

                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        // intent.putExtra(MediaStore.EXTRA_OUTPUT,);
                        startActivityForResult(intent, 100);

                    } else {
                        Toast.makeText(getActivity().getApplication(), "El teu dispositiu no soporta la camera, estas utilitzant un totxo?", Toast.LENGTH_LONG).show();
                    }
            }
            }
        });
        return view;
    }

}