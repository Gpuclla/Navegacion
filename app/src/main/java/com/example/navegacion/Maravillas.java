package com.example.navegacion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Maravillas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Maravillas extends Fragment  {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Maravillas() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Maravillas.
     */
    // TODO: Rename and change types and number of parameters
    public static Maravillas newInstance(String param1, String param2) {
        Maravillas fragment = new Maravillas();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    List<MaravillasModernas> lst;
    ListView scroll;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_maravillas, container, false);
        scroll=view.findViewById(R.id.lista);
        CustomAdapter adapter= new CustomAdapter(getActivity(),GetData());
        scroll.setAdapter(adapter);
        scroll.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MaravillasModernas p=lst.get(i);
                    Intent open = new Intent(getActivity(),MaravillaActivity.class)
                        .putExtra("imagen",p.imagen)
                        .putExtra("nombre",p.nombre)
                        .putExtra("ubicacion",p.ubicacion)
                        .putExtra("descripcion",p.descripcion);
                getActivity().startActivity(open);
            }
        });
        return view;
        }
    private List<MaravillasModernas> GetData() {
        lst=new ArrayList<>();
        lst.add(new MaravillasModernas(1,R.drawable.tm,"Taj Mahal","India","En 2007, millones de personas votaron por sus monumentos favoritos, de entre 21 preseleccionados. As?? se form?? la lista de las nuevas siete maravillas del mundo. No pod??a faltar en ella el Taj Mahal, en Agra, India. El mausoleo del siglo XVII, revestido de m??rmol, es considerado una obra maestra arquitect??nica y atrae anualmente hasta ocho millones de turistas."));
        lst.add(new MaravillasModernas(2,R.drawable.petra,"Petra ","Jordania","Son especialmente las fachadas de los templos mortuorios, esculpidas directamente en la roca, las que dieron a la antigua ciudad de Petra, en Jordania, la categor??a de nueva maravilla del mundo. La idea de ese t??tulo extraoficial la tuvo el suizo Bernard Weber, despu??s de que las fuerzas talibanes destruyeran dos estatuas de Buda en Bamiyan, Afganist??n, en 2001."));
        lst.add(new MaravillasModernas(3,R.drawable.muralla,"La Gran Muralla china","China","Tampoco esta impresionante construcci??n pod??a estar ausente. Con m??s de 6000 kil??metros de largo, la Gran Muralla china fue concebida como un muro defensivo. Contrariamente al rumor que circula desde hace mucho, no se la puede ver a simple vista desde el espacio."));
        lst.add(new MaravillasModernas(4,R.drawable.chichen,"Chich??n Itz??","M??xico","La ciudad maya de Chich??n Itz??, en M??xico, no solo fue incorporada a la lista de las nuevas maravillas por el templo piramidal que se levanta en su centro. Tambi??n era un centro pol??tico-religioso del imperio maya, por lo que re??ne distintos estilos arquitect??nicos de diversas regiones."));
        lst.add(new MaravillasModernas(5,R.drawable.mp,"Machu Picchu","Per??","En Machu Picchu, Per??, se ve tambi??n la otra cara de la fama de las maravillas del mundo: las ruinas de la ciudad incaica se ven amenazadas por el turismo masivo. La UNESCO ha pedido regulaciones m??s estrictas para reducir el n??mero de visitantes."));
        lst.add(new MaravillasModernas(6,R.drawable.coliseo,"Coliseo ","italia","El Coliseo de Roma es el ??nico monumento europeo que logr?? obtener un lugar entre las siete nuevas maravillas. En su d??a escenarios de espect??culos y luchas de gladiadores, es hoy una de las principales atracciones de la capital italiana."));
        lst.add(new MaravillasModernas(7,R.drawable.cristo,"El Cristo Redentor","Brasil","Tiene 30 metros de altura y pesa 1145 toneladas. Sus brazos extendidos, abarcan 28 metros. En R??o de Janeiro, el monumental Cristo Redentor se levanta sobre la colina del Corcovado. La estatua se termin?? en 1931."));
        return lst;
    }
}