package com.pp.dcasajus.forkpoint.LocalDetall.ContingutLocal;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.dscu.myapplication.backend.localApi.LocalApi;
import com.example.dscu.myapplication.backend.localApi.model.LocalBean;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.pp.dcasajus.forkpoint.ForkMeter.CustomAdapter;
import com.pp.dcasajus.forkpoint.ForkMeter.ForkMeterFragment;
import com.pp.dcasajus.forkpoint.ForkMeter.RowItem;
import com.pp.dcasajus.forkpoint.LocalDetall.Local;
import com.pp.dcasajus.forkpoint.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by denisplata on 18/02/2016.
 */
public class Opinions extends Fragment implements View.OnClickListener {

    Local local;
    LocalBean localUpdate;
    EditText comentari;
    ArrayAdapter<String> adaptador;
    ListView lv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detall_opinions, container, false);
        local = (Local) getArguments().getParcelable("local");
        comentari = (EditText) view.findViewById(R.id.comentari);

        localUpdate = new LocalBean();
        localUpdate.setId(local.getId());
        localUpdate.setLocal(local.getLocal());
        localUpdate.setDescripcio(local.getDescripcio());
        localUpdate.setCarrer(local.getCarrer());
        localUpdate.setHorari(local.getHorari());
        localUpdate.setPreu(local.getPreu());

        lv = (ListView) view.findViewById(R.id.listviewCom);

        adaptador = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, local.getComentaris());

        lv.setAdapter(adaptador);

        Button b1 = (Button) view.findViewById(R.id.button);
        b1.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (comentari.getText() != null || comentari.getText().equals("")) {
            List<String> comentaris = local.getComentaris();
            comentaris.add(comentari.getText().toString());
            local.setComentaris(comentaris);
            localUpdate.setComentaris(comentaris);
            new EndpointsUpdateAsyncTask().execute();

            adaptador = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, comentaris);
            lv.setAdapter(adaptador);
        }else{
            errorMesage();
        }
    }

    class EndpointsUpdateAsyncTask extends AsyncTask<String, Integer, String> {
        private LocalApi myApiService = null;
        private Context context;

        @Override
        protected String doInBackground(String... params) {
            if(myApiService == null) {  // Only do this once
                LocalApi.Builder builder = new LocalApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null);
                myApiService = builder.build();
            }
            try {
              myApiService.storeLocal(localUpdate).execute();

            return null;
            } catch (IOException e) {
                Log.e("log_tag", "Error parsing data " + e.toString());
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            System.out.println(result);
        }
    }

    private void errorMesage() {
        AlertDialog alert = null;
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Necessita esciure un comentari!").setCancelable(true);
        alert = builder.create();
        alert.show();
    }


}