package com.example.maria.entregable2potettimariano;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetalleReceta extends Fragment {


    private static final String CLAVE_TEXTO_INGREDIENTES = "clave ingrediente";
    private static final String CLAVE_TEXTO_PREPARACION = "clave preparacion";
    private static final String CLAVE_RESOURCE_IMAGE_VIEW = "clave recurso imagen";
    private static final String CLAVE_TITULO = "clave titulo";
    private static final String CLAVE_RECETA_ENTERA = "CLAVE RECETEA ENTERA O ENVIADA";

    private ImageView imageViewDetalle;
    private TextView textViewIngredientesDetalle;
    private TextView textViewPreparacionDetalle;


    public FragmentDetalleReceta() {
        // Required empty public constructor
    }

    public static FragmentDetalleReceta DameUnFragment(Receta receta ) {
        FragmentDetalleReceta fragmentDetalleReceta = new FragmentDetalleReceta();

        Bundle bundle = new Bundle();
       /* bundle.putString(CLAVE_TITULO,receta.getTitulo());
        bundle.putString(CLAVE_TEXTO_INGREDIENTES,receta.getIngredientes());
        bundle.putString(CLAVE_TEXTO_PREPARACION,receta.getPreparacion());*/
        bundle.putSerializable(CLAVE_RECETA_ENTERA,receta);
        fragmentDetalleReceta.setArguments(bundle);
        return fragmentDetalleReceta;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detalle_receta, container, false);
        imageViewDetalle = view.findViewById(R.id.imagen_Detalle_Receta);
        textViewIngredientesDetalle = view.findViewById(R.id.texto_Ingredientes_Receta);
        textViewPreparacionDetalle = view.findViewById(R.id.texto_Preparacion_Receta);
        Bundle bundle = getArguments();
        Receta recetaRecibida = (Receta) bundle.getSerializable(CLAVE_RECETA_ENTERA);
        imageViewDetalle.setImageResource(recetaRecibida.getImageRes());
        textViewIngredientesDetalle.setText(recetaRecibida.getIngredientes());
        textViewPreparacionDetalle.setText(recetaRecibida.getPreparacion());
        return view;
    }

}
