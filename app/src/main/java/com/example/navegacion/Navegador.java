package com.example.navegacion;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Navegador#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Navegador extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Navegador() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Navegador.
     */
    // TODO: Rename and change types and number of parameters
    public static Navegador newInstance(String param1, String param2) {
        Navegador fragment = new Navegador();
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

    WebView nav;
    TextView txtnav;
    ImageButton btnlupa;
    WebSettings wbsetting;
    String GOOGLE="https://www.google.com/";
    String SEARCH="/search?q=";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_navegador, container, false);
        nav = view.findViewById(R.id.Webnav);
        txtnav= view.findViewById(R.id.txtnav);
        btnlupa=view.findViewById(R.id.btnlupa);
        wbsetting= nav.getSettings();
        nav.loadUrl(GOOGLE);
        btnlupa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String URl = txtnav.getText().toString();
                nav.setWebViewClient(new WebViewClient());
                wbsetting.setJavaScriptEnabled(true);
                nav.loadUrl(GOOGLE+SEARCH+URl);
            }
        });
        return view;
    }
}