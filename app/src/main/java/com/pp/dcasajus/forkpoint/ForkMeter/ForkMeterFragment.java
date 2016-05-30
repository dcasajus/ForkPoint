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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.dscu.myapplication.backend.localApi.LocalApi;
import com.example.dscu.myapplication.backend.localApi.model.LocalBean;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.pp.dcasajus.forkpoint.LocalDetall.Local;
import com.pp.dcasajus.forkpoint.LocalDetall.LocalDetall;
import com.pp.dcasajus.forkpoint.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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
   // List<String> com;
    double lat;
    double lon;
    private LocalApi myApiService = null;
    CustomAdapter adapter;
    private List<RowItem> rowItems;
    List<LocalBean> remoteTasks;
    ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
    ArrayList<HashMap<String, List<String>>> mylist2 = new ArrayList<>();

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


            try {
                URL url = new URL("http://forkpoint-server.herokuapp.com/getLocals");
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.setRequestProperty("Content-Type", "application/json");
                con.setRequestProperty("Accept", "application/json");

                int HttpResult = con.getResponseCode();
                if (HttpResult == 200) {
                    InputStream in = new BufferedInputStream(con.getInputStream());
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    JSONArray aardata = new JSONArray(reader);
                    JSONObject obj = aardata.getJSONObject(0);
                    String local = obj.getString("local");
                    System.out.println(obj.toString());
                    System.out.println(local);

                    HashMap<String, String> map = new HashMap<String, String>();
                    HashMap<String, List<String>> map2 = new HashMap<String, List<String>>();
                    map.put("id",  obj.getString("id"));
                    map.put("local",  obj.getString("local"));
                    map.put("preu",  obj.getString("preu"));
                    map.put("carrer",  obj.getString("carrer"));
                    map.put("horari",  obj.getString("horari"));
                    map.put("descripcio",  obj.getString("descripcio"));
                    map2.put("comentaris", (List<String>) obj.getJSONArray("comentaris"));
                    //com =  taskBean.getComentaris();
                    mylist.add(map);
                    mylist2.add(map2);
                    return mylist;
                } else {
                    return null;
                }
            } catch(Exception e) {
                return null;
            }
            /*if(myApiService == null) {  // Only do this once
                LocalApi.Builder builder = new LocalApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null);
                myApiService = builder.build();
            }
            try {
                remoteTasks = myApiService.getLocal().execute().getItems();
                for (LocalBean taskBean : remoteTasks) {
                    HashMap<String, String> map = new HashMap<String, String>();
                    HashMap<String, List<String>> map2 = new HashMap<String, List<String>>();
                    map.put("id", String.valueOf(taskBean.getId()));
                    map.put("local", taskBean.getLocal());
                    map.put("preu", taskBean.getPreu());
                    map.put("carrer", taskBean.getCarrer());
                    map.put("horari", taskBean.getHorari());
                    map.put("descripcio", taskBean.getDescripcio());
                    map2.put("comentaris", taskBean.getComentaris());
                    //com =  taskBean.getComentaris();
                    System.out.println("COMENTARIS prova" + String.valueOf(taskBean.getComentaris()));
                    System.out.println("LAT " + taskBean.getLat()+ "LOT "+taskBean.getLon() );

                    mylist.add(map);
                    mylist2.add(map2);

                }
                return mylist;
            } catch (IOException e) {
                Log.e("log_tag", "Error parsing data "+e.toString());
            }
            return null;*/

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
        Local local = new Local(Long.parseLong(mylist.get(position).get("id")),mylist.get(position).get("local"),mylist.get(position).get("carrer"),mylist.get(position).get("preu"),Icons.getResourceId(position, -1),0,mylist.get(position).get("horari"),0,0,mylist.get(position).get("descripcio"),mylist2.get(position).get("comentaris"));
        Intent intent = new Intent(getActivity().getApplicationContext(), LocalDetall.class);
        intent.putExtra("localSelected", local);
        startActivity(intent);
    }

}