package com.example.maria.entregable2potettimariano;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    public static final String CLAVE_LISTA_RECETAS_ENVIADA = "clave lista recetas enviada";
    public static final String CLAVE_BUNDLE_DETALLE = "clave bundle Detalle";
    private List<FragmentDetalleReceta> listaFragmentDetalleReceta;
    private Receta recetaRecibida;
    private ArrayList<Receta> listaRecetasRecibidas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Inicializo la lista de Fragments y hardcodeo los fragments con un método
        listaFragmentDetalleReceta = new ArrayList<>();
        cargarFragmentsDetalleRecetaHardcodeados();

        //Encuentro el viewPager
        final ViewPager viewPager = findViewById(R.id.viewPager_activity2);
        //Creo el Adapter y le paso un fragment manager y la lista de fragments que mostrará
        final AdapterViewPagerFragmentDetalleReceta adapterViewPagerFragmentDetalleReceta = new AdapterViewPagerFragmentDetalleReceta(getSupportFragmentManager(), listaFragmentDetalleReceta);


        //Al viewPager le "presento" el adapter
        viewPager.setAdapter(adapterViewPagerFragmentDetalleReceta);

        //Como un ejemplo, hardcodeo que el view pager comenzará en la posición 2 (en el tercer fragment)
    /*    int posicionDelItem = 0;
        for (Integer i = 0; i < listaRecetasRecibidas.size(); i++) {
            if (listaRecetasRecibidas.get(i).equals(recetaRecibida)) {
                posicionDelItem = i;
                break;
            }
        }
        viewPager.setCurrentItem(posicionDelItem)*/


        viewPager.setCurrentItem(listaRecetasRecibidas.indexOf(recetaRecibida));
       // listaRecetasRecibidas.indexOf(recetaRecibida);



            /* 1 -para tomar la posicion q clickeo en el recycler y setearla para el pager view puedo hacer como hice yo que ..al crear el adapter del  recycler  en el fragment
             o activity(en este caso en el  fragment, le paso al adapter por constructor la lista que tengo como atributo(q es la lista harcodeada que cree en el mismo fragment(o activity).
              Esa misma lista , se la pase desde el fragment al activity 1 q contiene el fragment, por la interface (ademas de la receta q ya le pasaba. Despues el activity 1 le pasa esas 2 cosas\
               por bundle al activity2 y el activity 2 recibe esa lista y receta x bundle y las usa para el metodo cargarFragmentHarcodeados, que genera una lista de detalleFRagmentReceta que es la
                q se le pasa al view pager, y la receta la use para comparar con un for comun de la lista de recetas que viajaron juntas.. , es decir comparo cada elemento y cuando coincida x ej el titulo ,
                 tomo ese elem del for y lo seteo como parametro en setCurrentitem(esarecetaque coincidiodel for). En este caso la activity 1 es la q les paso la misma lista al adapter de recycler y al metodo
                  de la ifaz que crea ese fragment y ese metodo es el que se ejecuta en la ifaz que @override ese frag por implementar la ifaz del adapter..ver.
    2- Otra opcion es que desde el adapter del recyvler , dir' en vez de una receta se mande x parametro la posicion(getAdapterposition) y la lista que recibio y quedo seteada x constructort cuando se creo ese adapter.
    entonces eso viaja adapterRecycler-fragment-activiti1-activity2 y la activity 2 usa esa lista y busca esa posicion p hacer setCurrentintem al viewpager y ya..
    3 - Y la otra es hacer como en esta foto, pasar solo la receta desde el adapter del recycler y en el activity2  con esa receta y la lista q tengo o en el fragmento o activ q estoy parado o la traigo con ese metodo del controller(ver..)
     y con con eso hago un for y busco con equals como en la 1er forma q describo aca arriba.
     4-OOO en vez de hacer un  for  dir hago mas corto un idexOf(recetarecibida)--->  viewPager.setCurrentItem(listaRecetasRecibidas.indexOf(recetaRecibida)); y chau!*/


        //Esto es para poder ver un fragmento del siguiente/anterior fragment. Que el fragment no ocupe el ancho de la pantalla.
        //viewPager.setClipToPadding(false);
        //viewPager.setPageMargin(12);


    }

    private void cargarFragmentsDetalleRecetaHardcodeados() {

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        recetaRecibida = (Receta) bundle.getSerializable(CLAVE_BUNDLE_DETALLE);
        listaRecetasRecibidas = (ArrayList<Receta>) bundle.get(CLAVE_LISTA_RECETAS_ENVIADA);
        for (Receta recetaRecibida : listaRecetasRecibidas) {
            if (listaRecetasRecibidas != null) {
                listaFragmentDetalleReceta.add(FragmentDetalleReceta.DameUnFragment(recetaRecibida));
            }

        }

      /*  listaFragmentDetalleReceta.add(FragmentDetalleReceta.DameUnFragment(R.drawable.tostada_cangrejo,"Tostadas con ensalada de cangrejo","1 lata (6.5 oz) de carne de cangrejo (jaiba) en trozos, escurrida y desmenuzada" +
                "\n1 pimiento (pimentón) rojo, finamente rebanado\n1/2 taza de granos de elote (maíz) congelados; descongélalos antes de usar" +
                " 1/3 taza de aderezo italiano fuerte KRAFT Zesty Italian Dressing" +
                "\n 1/4 taza de cilantro fresco picado" +
                "\n 1 cucharada de jugo de limón verde (lime)" +
                "\n1 cucharada de chile jalapeño, rebanado fino; cantidad dividida" +
                "\n 3 cucharadas de mayonesa KRAFT Real Mayo Mayonnaise" +
                "\n 2 cucharadas de crema agria BREAKSTONE 'S Sour Cream o la de KNUDSEN" +
                "\n6 tostadas de maíz(5 pulgs.)","Mezcla los primeros 6 ingredientes y la mitad del jalapeño en un recipiente mediano." +
                "\nMezcla la mayonesa con la crema agria en un tazón pequeño." +
                "\nPica bien el resto del jalapeño rebanado; añádelo a la mezcla de mayonesa." +
                "\nUnta cada tostada con cerca de 1 cda.de la mezcla de mayonesa." +
                "\nCúbrelas con cantidades iguales de la mezcla de carne de cangrejo.Sírvelas inmediatamente."));
        listaFragmentDetalleReceta.add(FragmentDetalleReceta.DameUnFragment(R.drawable.camaronesalchipoteconnaranja,"Infalible lasaña de mariscos y espinaca","3 cucharadas de mantequilla\n" +
                "3 cucharadas de harina\n" +
                "3 tazas de leche\n" +
                "1/2 taza de queso parmesano rallado KRAFT Grated Parmesan Cheese\n" +
                "1 paquete (10 oz) de espinaca picada congelada, escurrida (descongélala antes de usar)\n" +
                "1 taza de queso cottage BREAKSTONE’S Cottage Cheese o el de KNUDSEN\n" +
                "1 taza de queso mozzarella parcialmente descremado, de baja humedad y desmenuzado KRAFT Shredded Low-Moisture Part-Skim Mozzarella Cheese, cantidad dividida\n" +
                "1/8 cucharadita de nuez moscada en polvo\n" +
                "9 láminas de pasta para lasaña, cocidas y escurridas\n" +
                "1/2 libra de camarones medianos, limpios y cocidos\n" +
                "2 latas (6 oz cada una) de carne de cangrejo (jaiba), escurrida, desmenuzada","Calienta el horno a 350°F." +
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
                "\nDéjala reposar 10min.antes de cortarla para servir."));
        listaFragmentDetalleReceta.add(FragmentDetalleReceta.DameUnFragment(R.drawable.lasagnamariscosyespinaca,"Infalible lasaña de mariscos y espinaca","3 cucharadas de mantequilla\n" +
                "3 cucharadas de harina\n" +
                "3 tazas de leche\n" +
                "1/2 taza de queso parmesano rallado KRAFT Grated Parmesan Cheese\n" +
                "1 paquete (10 oz) de espinaca picada congelada, escurrida (descongélala antes de usar)\n" +
                "1 taza de queso cottage BREAKSTONE’S Cottage Cheese o el de KNUDSEN\n" +
                "1 taza de queso mozzarella parcialmente descremado, de baja humedad y desmenuzado KRAFT Shredded Low-Moisture Part-Skim Mozzarella Cheese, cantidad dividida\n" +
                "1/8 cucharadita de nuez moscada en polvo\n" +
                "9 láminas de pasta para lasaña, cocidas y escurridas\n" +
                "1/2 libra de camarones medianos, limpios y cocidos\n" +
                "2 latas (6 oz cada una) de carne de cangrejo (jaiba), escurrida, desmenuzada","Calienta el horno a 350°F." +
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
                "\nDéjala reposar 10min.antes de cortarla para servir."));
        listaFragmentDetalleReceta.add(FragmentDetalleReceta.DameUnFragment(R.drawable.cremosa_pasta_con_poblanos_y_camarones,"Cremosa pasta con poblanos y camarones","6 chiles poblanos grandes, asados, pelados y desvenados, cantidad dividida" +
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
                "\nIncorpora 1/2 taza de mozzarella; cocínalo mientras lo revuelves 1 min. o hasta que se derrita. Espolvorea el resto del queso mozzarella, el cilantro y el parmesano."));  */

    }
}
