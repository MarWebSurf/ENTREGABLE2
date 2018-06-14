package com.example.maria.entregable2potettimariano;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ToDoubleBiFunction;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentRecetas extends Fragment implements AdapterFragment.NotificadorCeldaRecetaClickeadaAdapter {

    private NotificadorRecetaRecibidaDelAdapter notificadorRecetaRecibidaDelAdapter;
    protected ArrayList<Receta> listaRecetasFragment;
    private RecyclerView recyclerView;


    public FragmentRecetas() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recetas, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        // falta harcodear lista recetas y ponel el metodo aca
        armarListaReceta();
        AdapterFragment adapterFragment = new AdapterFragment(listaRecetasFragment, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterFragment);
        return view;
    }


    public void armarListaReceta() {
        listaRecetasFragment = new ArrayList<>();
        listaRecetasFragment.add(new Receta("Tostadas con ensalada de cangrejo",
                "1 lata (6.5 oz) de carne de cangrejo (jaiba) en trozos, escurrida y desmenuzada" +
                        "\n1 pimiento (pimentón) rojo, finamente rebanado\n1/2 taza de granos de elote (maíz) congelados; descongélalos antes de usar" +
                        " 1/3 taza de aderezo italiano fuerte KRAFT Zesty Italian Dressing" +
                        "\n 1/4 taza de cilantro fresco picado" +
                        "\n 1 cucharada de jugo de limón verde (lime)" +
                        "\n1 cucharada de chile jalapeño, rebanado fino; cantidad dividida" +
                        "\n 3 cucharadas de mayonesa KRAFT Real Mayo Mayonnaise" +
                        "\n 2 cucharadas de crema agria BREAKSTONE 'S Sour Cream o la de KNUDSEN" +
                        "\n6 tostadas de maíz(5 pulgs.)", "Mezcla los primeros 6 ingredientes y la mitad del jalapeño en un recipiente mediano." +
                "\nMezcla la mayonesa con la crema agria en un tazón pequeño." +
                "\nPica bien el resto del jalapeño rebanado; añádelo a la mezcla de mayonesa." +
                "\nUnta cada tostada con cerca de 1 cda.de la mezcla de mayonesa." +
                "\nCúbrelas con cantidades iguales de la mezcla de carne de cangrejo.Sírvelas inmediatamente.", R.drawable.tostada_cangrejo));
        listaRecetasFragment.add(new Receta("Camarones al chipote con naranja", "1/3 taza de aderezo italiano fuerte KRAFT Zesty Italian Dressing" +
                "\n1-1/2 libra de camarones frescos grandes, crudos, pelados y sin venas" +
                "\n1/4 taza de mermelada de naranja" +
                "\n2 cucharadas de chiles chipotles en adobo enlatados, picados" +
                "\n1/4 taza de cilantro picado" +
                "\n3 tazas de arroz cocido, calientito", "Calienta el aderezo en una sartén grande a fuego medio-alto." +
                "\nAñade los camarones; cocínalos durante 4 min., revolviéndolos frecuentemente." +
                "\nAgrega la mermelada y los chiles;"+
                "\ncocina y revuélvelos por 3 min.o hasta que los camarones estén tiernos." +
                "\nRetíralos del fuego." +
                "\nIncorpora el cilantro a los camarones." +
                "\nSírvelos sobre el arroz.);", R.drawable.camaronesalchipoteconnaranja));
        listaRecetasFragment.add(new Receta("Infalible lasaña de mariscos y espinaca", "3 cucharadas de mantequilla\n" +
                "3 cucharadas de harina\n" +
                "3 tazas de leche\n" +
                "1/2 taza de queso parmesano rallado KRAFT Grated Parmesan Cheese\n" +
                "1 paquete (10 oz) de espinaca picada congelada, escurrida (descongélala antes de usar)\n" +
                "1 taza de queso cottage BREAKSTONE’S Cottage Cheese o el de KNUDSEN\n" +
                "1 taza de queso mozzarella parcialmente descremado, de baja humedad y desmenuzado KRAFT Shredded Low-Moisture Part-Skim Mozzarella Cheese, cantidad dividida\n" +
                "1/8 cucharadita de nuez moscada en polvo\n" +
                "9 láminas de pasta para lasaña, cocidas y escurridas\n" +
                "1/2 libra de camarones medianos, limpios y cocidos\n" +
                "2 latas (6 oz cada una) de carne de cangrejo (jaiba), escurrida, desmenuzada", "Calienta el horno a 350°F." +
                "\nDerrite la mantequilla en una cacerola grande a fuego medio." +
                "\nAñade la harina; revuelve bien la mezcla con un batidor de varillas." +
                "\nAgrega poco a poco la leche. Deja hervir, revolviendo constantemente;" +
                "\nmantén un hervor suave a fuego bajo de 3 a 5 min. o hasta que espese," +
                "\nrevolviendo constantemente." +
                "\n Sácala del fuego. Incorpora el queso parmesano." +
                "\nCombina la espinaca, el queso cottage, 2/3 de taza del queso mozzarella" +
                "\ny la nuez moscada." +
                "\nEsparce 1 / 4de la salsa de queso parmesano sobre el fondo de una fuente para hornear de 13x9 pulgadas." +
                "\nCubre esto con 3láminas de lasaña;" +
                "\nluego, haz una capa con la mitad de los camarones;otra con la mitad de la carne de cangrejo," +
                "\ny otra con la mitad de la mezcla de espinaca." +
                "\nCubre esto con 1 / 3de la salsa de queso parmesano restante." +
                "\nRepite las capas, empezando por la pasta para lasaña. Cúbrela con el resto de las láminas, salsa" +
                "\ny mozzarella.Tápala con papel de aluminio." +
                "\nHornéala durante 45min.o hasta que la lasaña este completamente caliente" +
                "\ny ligeramente dorada por arriba quitándole el papel de aluminio después de 25min." +
                "\nDéjala reposar 10min.antes de cortarla para servir.", R.drawable.lasagnamariscosyespinaca));
        listaRecetasFragment.add(new Receta("Cremosa pasta con poblanos y camarones", "6 chiles poblanos grandes, asados, pelados y desvenados, cantidad dividida" +
                "\n1lata(8oz)de salsa de tomate(jitomate)" +
                "\n4onzas(1 / 2pqte.de 8oz)de queso crema PHILADELPHIA Cream Cheese, en cubitos, ablandado"+
                "\n1libra de espagueti, sin cocer" +
                "\n2libras de camarones medianos crudos, pelados y limpios" +
                "\n1taza de queso mozzarella parcialmente descremado, de baja humedad y desmenuzado KRAFT Shredded Low - Moisture Part - Skim Mozzarella Cheese, cantidad dividida" +
                "\n2cucharadas de cilantro fresco picado" +
                "\n2cucharadas de queso parmesano rallado KRAFT Grated Parmesan Cheese","Corta 4 chiles en tiras delgadas; ponlos a un lado." +
                "\nLicúa los demás chiles en la licuadora junto con la salsa de tomate y el queso crema hasta obtener una consistencia homogénea.\n" +
                "\nCocina el espagueti en una olla de 8 L según indica el paquete, pero omite la sal."+
                "\n Mientras tanto, cocina los camarones, en 2 tandas, revolviendo con frecuencia, dentro de una sartén grande antiadherente a fuego alto 3 min. o hasta que se pongan rosados." +
                "\nRetíralos del fuego; tápalos para mantenerlos calientes.\n" +
                "\nEscurre el espagueti, pero reserva 1/2 taza del agua de la cocción.\nPon el espagueti y el agua que reservaste de vuelta en la olla." +
                "\n Agrega la salsa de chiles, las tiras de chile y los camarones; \ncocínalos revolviendo con frecuencia 2 min. a fuego medio-bajo o hasta que se terminen de calentar." +
                "\nIncorpora 1/2 taza de mozzarella; cocínalo mientras lo revuelves 1 min. o hasta que se derrita. Espolvorea el resto del queso mozzarella, el cilantro y el parmesano.",R.drawable.cremosa_pasta_con_poblanos_y_camarones));
        listaRecetasFragment.add(new Receta("Mejillones a la crema","4 libras de mejillones, cepillados y sin barbas\n" +
                "1 taza de caldo de pescado o de pollo\n" +
                "1/4 taza (1/2 barra) de mantequilla o margarina\n" +
                "1 taza de champiñones (hongos) rebanados\n" +
                "2 dientes de ajo bien picados\n" +
                "1/4 taza de harina\n" +
                "1 taza de crema agria BREAKSTONE'S Sour Cream o la de KNUDSEN\n" +
                "1 cucharada de jugo de limón amarillo (lemon)\n" +
                "1/2 taza de perejil italiano, picado","Pon los mejillones y el caldo de pescado en una olla grande de hierro tipo Dutch oven;" +
                "\ntápala. Cuécelos a fuego alto durante 7 minutos o hasta que se abran las conchas." +
                "\nDesecha todos los mejillones que no se abran;" +
                "\ncuela y guarda el líquido en un tazón pequeño." +
                "\nColoca los mejillones en otro tazón. Para mantenerlos calientes, cubre tanto los mejillones como el líquido; reserva.\n" +
                "Derrite la mantequilla en la misma olla a fuego medio." +
                "\nAgrega los hongos y el ajo; cocina durante 5 minutos, revolviendo constantemente." +
                "\nAgrega la harina y mézclala con un batidor de varillas." +
                "\nAñade poco a poco el líquido de los mejillones que reservaste, revolviendo hasta que quede bien mezclado." +
                "\nBaja el fuego a medio-bajo.\n" +
                "\nAgrega la crema agria y el jugo de limón; mezcla todo bien." +
                "\nAñade los mejillones; cocínalos hasta que estén completamente calientes, revolviendo de vez en cuando. (No los hiervas.)" +
                "\nEspolvoréalos con el perejil justo antes de servir.",R.drawable.mejillones_a_la_crema));
        listaRecetasFragment.add(new Receta("Mariscos al eneldo en salsa de mostaza","2 cucharadas de mantequilla o margarina\n" +
                "3/4 libra de camarones medianos crudos, pelados y limpios\n" +
                "3/4 libra de vieiras (scallops), cortadas por la mitad\n" +
                "1/2 libra de tallos de espárragos frescos, cortados en pedazos del tamaño de un bocado\n" +
                "2 cucharadas de eneldo fresco picado\n" +
                "1/2 taza de leche\n" +
                "1/2 taza de crema agria BREAKSTONE'S Sour Cream o la de KNUDSEN\n" +
                "2 cucharadas de mostaza parda picante GREY POUPON Hearty Spicy Brown Mustard\n" +
                "3 tazas de fideos cocidos todavía calientitos","Derrite la mantequilla en una sartén grande a fuego medio-alto."+
                "\nAgrega los mariscos con el espárrago y el eneldo;" +
                "\ncocínalos revolviéndolos de vez en cuando de 5 a 7 min. o hasta que se pongan rosados."+
                "\nRetíralos de la sartén; tápalos para mantenerlos calientes.\n" +
                "Agrega la leche, la crema agria y la mostaza a la sartén;"+
                "\ncocínalas revolviéndolas con frecuencia a fuego bajo de 4 a 5 min. o hasta que se terminen de calentar. (No las hiervas.)\n" +
                "\nIncorpora la mezcla de mariscos a la salsa; cocina el platillo de 2 a 3 min. o hasta que se termine de calentar."+
                "\nSírvelo sobre los fideos.",R.drawable.mariscos_al_eneldo));
        listaRecetasFragment.add(new Receta("Huachinango con salsa de pimientos asados", " frasco (12 oz) de pimientos (pimentones) rojos asados, escurridos\n" +
                "1/2 taza de mayonesa KRAFT Real Mayo Mayonnaise\n" +
                "3 dientes de ajo, picados\n" +
                "1/2 cucharadita de pimienta de cayena\n" +
                "1 taza de cilantro fresco picado\n" +
                "1 hoja grande de plátano (48x14 pulgs.) más tiritas adicionales de hoja de plátano\n" +
                "2 filetes de huachinango rojo (2 lb), limpios, sin espinas","Calienta la parrilla a fuego medio.\n" +
                "Licúa los pimientos, la mayonesa, el ajo y la pimienta hasta que estén homogéneos." +
                "Transfiere la mezcla a un tazón; incorpora el cilantro.\n" +
                "Corta la hoja de plátano en 4 cuadrados de unas 12 pulgadas;" +
                "\npon 2 trozos sobre una superficie de trabajo con los lados levemente encimados."+
                "\nCúbrelos con 1/4 taza de salsa de pimientos, 1 filete de pescado y 1/4 taza más de salsa."+
                "\nEnvuelve el pescado con las hojas. Repite con las hojas, el pescado y 1/2 taza de salsa restantes.\n" +
                "Amarra bien cada filete envuelto con tiritas adicionales de hojas de plátano."+
                "\nÁsalos, tapados, 15 min. o hasta que el pescado se desmenuce fácilmente con un tenedor, voltéandolo después de 8 min."+
                "\nSírvelos con la salsa restante.",R.drawable.huachinango));
        listaRecetasFragment.add(new Receta("Paella valenciana"," hebras de azafrán trituradas (una pizca)\n" +
                "3 tazas de caldo de pollo\n" +
                "1/4 taza de aceite de oliva\n" +
                "1 pollo para asar o freír (2-1/2 libras), sin pellejo, cortado en 12 trozos\n" +
                "5 onzas de lomo de cerdo, cortado en trozos\n" +
                "4 dientes de ajo, bien picados\n" +
                "1 cebolla, picada\n" +
                "1 libra de salchicha italiana o chipolata, cortada en trozos de 1 pulgada\n" +
                "2 tazas de arroz blanco de grano corto, Valencia o arborio, sin cocer\n" +
                "2 hojas de laurel\n" +
                "1 taza de vino blanco seco\n" +
                "3 tomates (jitomates), pelados, sin semillas y picados\n" +
                "1 cucharadita de pimienta negra molida\n" +
                "12 camarones medianos, crudos, pelados y sin venas\n" +
                "4 onzas de anillos de calamar (sepias)\n" +
                "1 filete (6 oz) de pez rape o pejesapo (monkfish), sin piel, cortado en trozos\n" +
                "8 almejas, enjuagadas\n" +
                "8 mejillones, limpios, estregados, sin barbas (bisos) y enjuagadas\n" +
                "1 taza de chícharos (guisantes o arvejas) congelados; descongélalos antes de usar\n" +
                "1 pimiento (pimentón) verde y otro rojo, cortados en tiras\n" +
                "2 limones amarillos (lemons), cortados en cuñas","Calienta el horno a 400ºF.\n" +
                "Mezcla el azafrán con el caldo de pollo; reserva." +
                "\nCalienta el aceite en una paellera o en una sartén refractaria muy grande a fuego medio-alto."+
                "\nAgrega el pollo y el cerdo; cocínalos hasta que el pollo esté ligeramente dorado, volteando ambos de vez en cuando."+
                "\nAñade el ajo, la cebolla y las salchichas; cocina y revuelve durante 5 min. o hasta que la cebolla esté tierna y crujiente."+
                "\nAgrega el arroz; cocina y revuelve durante 5 min."+
                "\nCon una cuchara, retira cuidadosamente el exceso de aceite. Incorpora las hojas de laurel, el vino, los tomates, la sal y la pimienta."+
                "\nDeja hervir. Añade la mitad del caldo de pollo. Deja hervir. Agrega los camarones, los calamares, el rape, las almejas y los mejillones;"+
                "\nmezcla bien.\n" +
                "Pon la paellera en el horno con mucho cuidado. Añade suficiente caldo de pollo para cubrir todos los ingredientes."+
                "\nCúbrelos con los chícharos y los pimientos; tapa.\n" +
                "Hornea la paella 35 min. o hasta que esté completamente caliente y las almejas abiertas."+
                "\nCorona con las cuñas de limón.",R.drawable.paella_valenciana));
        listaRecetasFragment.add(new Receta("Bacalao a la sartén con ensalada de frijoles blancos","1/2 taza de aderezo italiano fuerte KRAFT Zesty Italian Dressing, cantidad dividida\n" +
                "1 cucharadita de páprika ahumada\n" +
                "6 filetes de bacalao fresco (1-1/2 lb)\n" +
                "2 latas (15.5 oz cada una) de frijoles norteños, enjuagados\n" +
                "1 tomate (jitomate) grande, sin semillas y picado\n" +
                "4 cebollitas verdes, en rebanadas finas\n" +
                "1/4 taza de perejil fresco picado\n" +
                "1 diente grande de ajo, bien picado\n" +
                "1/2 taza de aceitunas negras sin hueso, en rebanadas\n" +
                "3 huevos duros, cortados en cuñas","Mezcla 1/4 taza de aderezo con la páprika;"+
                "\nvierte la mezcla sobre el pescado en un plato llano."+
                "\nVoltea el pescado para cubrir parejamente por ambos lados cada filete."+
                "\nPonlos a marinar en la nevera durante 30 min.\n" +
                "Mezcla los ingredientes restantes, entretanto, excepto las aceitunas y los huevos, en un tazón grande.\n" +
                "Saca el pescado de la marinada y deshazte de ésta. Cocina el pescado en una sartén grande a fuego medio-alto de 4 a 5 min. por lado o hasta que el pescado se desmenuce fácilmente con un tenedor."+
                "\nSírvelo con la ensalada de frijoles; corona todo con las aceitunas y los huevos.",R.drawable.bacalao));

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        notificadorRecetaRecibidaDelAdapter = (NotificadorRecetaRecibidaDelAdapter) context;
    }

    @Override
    public void notificarRecetaClickeada(Receta recetaClickeada) {
        notificadorRecetaRecibidaDelAdapter.notificarRecetaRecibidaDelAdapter(recetaClickeada,listaRecetasFragment);
    }

    public interface NotificadorRecetaRecibidaDelAdapter {
        public void notificarRecetaRecibidaDelAdapter(Receta recetaRecibida,ArrayList<Receta> listaRecetas);

    }
}
