package com.example.maria.entregable2potettimariano;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

public class AdapterViewPagerFragmentDetalleReceta  extends FragmentStatePagerAdapter {

    private List<FragmentDetalleReceta> listaFragmentDetalleRecetas;

    public AdapterViewPagerFragmentDetalleReceta(FragmentManager fm, List<FragmentDetalleReceta> listaFragments) {
        super(fm);
        this.listaFragmentDetalleRecetas = listaFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return listaFragmentDetalleRecetas.get(position);
    }

    @Override
    public int getCount() {
        return listaFragmentDetalleRecetas.size();
    }
}
