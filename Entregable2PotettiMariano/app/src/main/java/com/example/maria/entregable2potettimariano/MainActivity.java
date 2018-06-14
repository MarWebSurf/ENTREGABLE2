package com.example.maria.entregable2potettimariano;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, FragmentRecetas.NotificadorRecetaRecibidaDelAdapter {

    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private FragmentRecetas fragmentRecetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView = findViewById(R.id.navigationView);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView.setNavigationItemSelectedListener(this);
        //fragmentRecetas = new FragmentRecetas();
        //cargarFragment(fragmentRecetas);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragmentACargar = null;
        switch (item.getItemId()) {
            case R.id.recetas:
                fragmentACargar = new FragmentRecetas();
                break;
            case R.id.about_us:
                fragmentACargar = new FragmentAboutUs();
                break;
        }
        cargarFragment(fragmentACargar);
            drawerLayout.closeDrawers();
        return true;
    }

    public void cargarFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_fragment_main_main, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void notificarRecetaRecibidaDelAdapter(Receta recetaRecibida,ArrayList<Receta> listaRecetas) {

        //FragmentDetalleReceta fragmentDetalleReceta = new FragmentDetalleReceta();
        Intent intent = new Intent(this,Main2Activity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(Main2Activity.CLAVE_BUNDLE_DETALLE,recetaRecibida);
        bundle.putSerializable(Main2Activity.CLAVE_LISTA_RECETAS_ENVIADA, listaRecetas);
        intent.putExtras(bundle);
        startActivity(intent);
       // fragmentDetalleReceta.setArguments(bundle);
        //cargarFragment(fragmentDetalleReceta);

    }
}
