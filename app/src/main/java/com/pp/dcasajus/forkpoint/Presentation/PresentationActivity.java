package com.pp.dcasajus.forkpoint.Presentation;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;

import com.pp.dcasajus.forkpoint.HomeActivity;
import com.pp.dcasajus.forkpoint.R;

/**
 * Created by denisplata on 08/02/2016.
 */
public class PresentationActivity  extends Activity {

    private final int Duracio = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentation);
       // getActionBar().hide();
        final LocationManager manager = (LocationManager) getSystemService( Context.LOCATION_SERVICE );

        if ( !manager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {
            AlertNoGps();
        };
        new Handler().postDelayed(new Runnable(){
            public void run(){
                Intent intent = new Intent(PresentationActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();
            };
        }, Duracio);
    }

    private void AlertNoGps() {
        AlertDialog alert = null;
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("El sistema GPS esta desactivado, ¿Desea activarlo?")
                .setCancelable(false)
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        dialog.cancel();
                    }
                });
        alert = builder.create();
        alert.show();
    }


}
