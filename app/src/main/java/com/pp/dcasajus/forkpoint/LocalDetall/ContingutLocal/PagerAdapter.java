package com.pp.dcasajus.forkpoint.LocalDetall.ContingutLocal;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.pp.dcasajus.forkpoint.LocalDetall.Local;

/**
 * Created by denisplata on 18/02/2016.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    Local local;

    public PagerAdapter(FragmentManager fm, int NumOfTabs, Local local) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
        this.local = local;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Informacio tab1 = new Informacio();
                Bundle bundle = new Bundle();
                bundle.putParcelable("local", local);
                tab1.setArguments(bundle);
                return tab1;
            case 1:
                Photos tab2 = new Photos();
                return tab2;
            case 2:
                Opinions tab3 = new Opinions();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}