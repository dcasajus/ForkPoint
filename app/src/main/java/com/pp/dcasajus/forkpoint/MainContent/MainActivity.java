package com.pp.dcasajus.forkpoint.MainContent;




/**
 * Created by denisplata on 08/02/2016.
 */

import android.os.Bundle;

import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.pp.dcasajus.forkpoint.Favortios.FavoritosFragment;
import com.pp.dcasajus.forkpoint.ForkMeter.ForkMeterFragment;
import com.pp.dcasajus.forkpoint.Opcions.OpcionsFragment;
import com.pp.dcasajus.forkpoint.Perfil.PerfilFragment;
import com.pp.dcasajus.forkpoint.R;

public class MainActivity extends AppCompatActivity  {

    private Toolbar appbar;
    private DrawerLayout drawerLayout;
    private NavigationView navView;
    TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appbar = (Toolbar)findViewById(R.id.appbar);
        setSupportActionBar(appbar);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_nav_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);

        login = (TextView)findViewById(R.id.goLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PerfilFragment fragment = new PerfilFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_frame, fragment)
                        .commit();
            }
        });

        navView = (NavigationView)findViewById(R.id.navview);
        navView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {

                        boolean fragmentTransaction = false;
                        Fragment fragment = null;

                        switch (menuItem.getItemId()) {
                            case R.id.menu_perfil:
                                fragment = new PerfilFragment();
                                fragmentTransaction = true;
                                break;
                            case R.id.menu_partymeter:
                                fragment = new ForkMeterFragment();
                                fragmentTransaction = true;
                                break;
                            case R.id.menu_favoritos:
                                fragment = new FavoritosFragment();
                                fragmentTransaction = true;
                                break;
                            case R.id.menu_ajustes:
                                fragment = new OpcionsFragment();
                                fragmentTransaction = true;
                                break;
                            case R.id.menu_salir:
                                System.exit(0);
                                Log.i("NavigationView", "Pulsada opción 2");
                                break;
                        }

                        if (fragmentTransaction) {
                            getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.content_frame, fragment)
                                    .commit();

                            menuItem.setChecked(true);
                            getSupportActionBar().setTitle(menuItem.getTitle());
                        }

                        drawerLayout.closeDrawers();

                        return true;
                    }
                });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch(item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}



