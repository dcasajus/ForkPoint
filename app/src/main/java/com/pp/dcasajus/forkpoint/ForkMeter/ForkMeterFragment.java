package com.pp.dcasajus.forkpoint.ForkMeter;

/**
 * Created by denisplata on 09/02/2016.
 */

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.dscu.myapplication.backend.localApi.LocalApi;
import com.example.dscu.myapplication.backend.localApi.model.LocalBean;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.pp.dcasajus.forkpoint.LocalDetall.Local;
import com.pp.dcasajus.forkpoint.LocalDetall.LocalDetall;
import com.pp.dcasajus.forkpoint.R;
import com.pp.dcasajus.forkpoint.Serveis.LocationSave;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ForkMeterFragment extends ListFragment implements AdapterView.OnItemClickListener {


    String[] titles;
    TypedArray Icons;
    String[] carrers;
    String[] preu;
    String[] horari;
    String descripcio;
    double lat;
    double lon;
    private LocalApi myApiService = null;
    CustomAdapter adapter;
    private List<RowItem> rowItems;
    List<LocalBean> remoteTasks;
    ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();

    public ForkMeterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {

        Bundle args = getArguments();
        if (args != null) {
            lat = args.getDouble("latitud");
            lon = args.getDouble("longitud");
        }
        Icons = getResources().obtainTypedArray(R.array.icons);

        new EndpointsAsyncTask().execute();

        return inflater.inflate(R.layout.fragment_forkmeter, container, false);
    }

    class EndpointsAsyncTask extends AsyncTask<String, Integer, ArrayList<HashMap<String, String>> > {
        private LocalApi myApiService = null;
        private Context context;



        @Override
        protected ArrayList<HashMap<String, String>> doInBackground(String... params) {
            if(myApiService == null) {  // Only do this once
                LocalApi.Builder builder = new LocalApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null);
                myApiService = builder.build();
            }
            try {
                remoteTasks = myApiService.getLocal().execute().getItems();
                for (LocalBean taskBean : remoteTasks) {
                    HashMap<String, String> map = new HashMap<String, String>();
                    map.put("id", String.valueOf(taskBean.getId()));
                    map.put("local", taskBean.getLocal());
                    map.put("preu", taskBean.getPreu());
                    map.put("carrer", taskBean.getCarrer());
                    System.out.println("LAT " + taskBean.getLat()+ "LOT "+taskBean.getLon() );

                    mylist.add(map);

                }
                return mylist;
            } catch (IOException e) {
                Log.e("log_tag", "Error parsing data "+e.toString());
            }
            return null;
        }

        @Override
        protected void onPostExecute(ArrayList<HashMap<String, String>> result) {
            rowItems = new ArrayList<RowItem>();
            for (int i = 0; i < result.size(); i++) {
                RowItem items = new RowItem(result.get(i).get("local"),Icons.getResourceId(
                        i, -1), result.get(i).get("carrer"), result.get(i).get("preu"), lat, lon);

                rowItems.add(items);
            }

            System.out.println(result);

            adapter = new CustomAdapter(getActivity(), rowItems,lat,lon);
            setListAdapter(adapter);
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        getListView().setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        System.out.println("Position "+position);
        Local local = new Local(mylist.get(position).get("local"),mylist.get(position).get("carrer"),mylist.get(position).get("preu"),Icons.getResourceId(position, -1),0,mylist.get(position).get("horari"),0,0,mylist.get(position).get("descripcio"));
        Intent intent = new Intent(getActivity().getApplicationContext(), LocalDetall.class);
        intent.putExtra("localSelected", local);
        startActivity(intent);
    }

}