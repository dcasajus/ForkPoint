package com.pp.dcasajus.forkpoint.LocalDetall;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.TabLayout;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.pp.dcasajus.forkpoint.Favortios.FavoritosSQLite;
import com.pp.dcasajus.forkpoint.LocalDetall.ContingutLocal.PagerAdapter;
import com.pp.dcasajus.forkpoint.R;

/**
 * Created by denisplata on 18/02/2016.
 */
public class LocalDetall extends AppCompatActivity {
    ImageView imgFav;
    FavoritosSQLite fav ;

    Local local;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detall_local);
        local= (Local) getIntent().getParcelableExtra("localSelected");

        fav= new FavoritosSQLite(this, "Locals", null, 1);

        TextView txtTitle = (TextView)findViewById(R.id.title_dtll);
        ImageView imgIcon = (ImageView)findViewById(R.id.imatge_detall);
        imgFav = (ImageView)findViewById(R.id.favorito);
        txtTitle.setText(local.local);
        imgIcon.setImageResource(local.Icons);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        setSupportActionBar(toolbar);

        SQLiteDatabase db = fav.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Locals", null);
        cursor.moveToFirst();
        local.setIsFavorite(0);
        while(!cursor.isAfterLast()) {
            System.out.println(cursor.getString(1));
            System.out.println(local.local);
            if (cursor.getString(1).equals(local.local)) {
                System.out.println("entro");
                imgFav.setImageResource(R.drawable.favoritosicoadd);
                local.setIsFavorite(1);
            }
            cursor.moveToNext();
        }
        cursor.close();

        imgFav.setOnClickListener(mFavoriteChangeImageListener);

        toolbar.setNavigationOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
            finish();
        }
        }
        );

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Informació"));
        tabLayout.addTab(tabLayout.newTab().setText("Fotos"));
        tabLayout.addTab(tabLayout.newTab().setText("Opinions"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount(), local);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener()

        {
            @Override
            public void onTabSelected (TabLayout.Tab tab){
            viewPager.setCurrentItem(tab.getPosition());
        }

            @Override
            public void onTabUnselected (TabLayout.Tab tab){

        }

            @Override
            public void onTabReselected (TabLayout.Tab tab){

        }
        }

        );

    }
        View.OnClickListener mFavoriteChangeImageListener = new View.OnClickListener() {
        public void onClick(View v) {
            imgFav.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    SQLiteDatabase db = fav.getWritableDatabase();
                    Cursor cursor = db.rawQuery("SELECT * FROM Locals", null);
                    if (local.getIsFavorite() == 0){
                        imgFav.setImageResource(R.drawable.favoritosicoadd);
                        int codigo = 1;
                        db.execSQL("INSERT INTO Locals (codigo, title, icon, carrer, preu) " +
                                "VALUES (" + codigo + ", '" + local.local + "', " + local.getIcons() + ", '"+local.getCarrer()+"' ,'"+local.getPreu()+"')");

                    } else {
                        imgFav.setImageResource(R.drawable.favoritosico);
                        String[] args = new String[]{local.local};
                        db.execSQL("DELETE FROM Locals WHERE title=?", args);
                    }
                    cursor.close();
                }
            });

        }
        };
    }