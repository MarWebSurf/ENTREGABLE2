package com.example.maria.entregable2potettimariano;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterFragment extends RecyclerView.Adapter {

    private List<Receta> listaRecetasAdapter;
    private NotificadorCeldaRecetaClickeadaAdapter notificadorCeldaRecetaClickeadaAdapter;

    public AdapterFragment(List<Receta> listaRecetasAdapter, NotificadorCeldaRecetaClickeadaAdapter notificadorCeldaRecetaClickeadaAdapter) {
        this.listaRecetasAdapter = listaRecetasAdapter;
        this.notificadorCeldaRecetaClickeadaAdapter = notificadorCeldaRecetaClickeadaAdapter;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.celda_recyclerview,parent,false);
        ViewHolderReceta viewHolderReceta = new ViewHolderReceta(view);

        return viewHolderReceta;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Receta receta = listaRecetasAdapter.get(position);
        ViewHolderReceta viewHolderRecetaBis = (ViewHolderReceta) holder;
        viewHolderRecetaBis.cargarReceta(receta);

    }

    @Override
    public int getItemCount() {
        if(listaRecetasAdapter != null){
           return listaRecetasAdapter.size();
        } else {
            return 0;

        }
    }

    private class ViewHolderReceta extends RecyclerView.ViewHolder {
        TextView textViewSuperiorCelda = itemView.findViewById(R.id.textView_superior_celda_Recycler);
        ImageView imageViewCelda = itemView.findViewById(R.id.imagen_celda_Recycler);
       /* TextView textView2Celda = itemView.findViewById(R.id.textView_2_celda_Recycler);
        TextView textView3Celda = itemView.findViewById(R.id.textView_3_celda_Recycler);*/

        public ViewHolderReceta(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int posicionRecetaClickeada = getAdapterPosition();
                    Receta recetaObtenida = listaRecetasAdapter.get(posicionRecetaClickeada);
                    notificadorCeldaRecetaClickeadaAdapter.notificarRecetaClickeada(recetaObtenida);
                }
            });

        }

        public void cargarReceta(Receta receta) {
            textViewSuperiorCelda.setText(receta.getTitulo());
            imageViewCelda.setImageResource(receta.getImageRes());
            /*textView2Celda.setText(receta.getIngredientes());
            textView3Celda.setText(receta.getPreparacion());*/
        }
    }

    public interface NotificadorCeldaRecetaClickeadaAdapter {
        public void notificarRecetaClickeada(Receta recetaClickeada);
    }
}
