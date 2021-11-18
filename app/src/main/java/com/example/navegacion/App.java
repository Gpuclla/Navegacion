package com.example.navegacion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.droidsonroids.gif.GifImageButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link App#newInstance} factory method to
 * create an instance of this fragment.
 */
public class App extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public App() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment App.
     */
    // TODO: Rename and change types and number of parameters
    public static App newInstance(String param1, String param2) {
        App fragment = new App();
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
    GifImageButton telegram, steam, googledrive,youtube;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_app, container, false);

        telegram= view.findViewById(R.id.telegram);
        steam= view.findViewById(R.id.steam);
        googledrive= view.findViewById(R.id.googledrive);
        youtube= view.findViewById(R.id.youtube);

        telegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telegram=getActivity().getPackageManager().getLaunchIntentForPackage("org.telegram.messenger");
                startActivity(telegram);
            }
        });
        steam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent steam=getActivity().getPackageManager().getLaunchIntentForPackage("com.valvesoftware.android.steam.community");
                startActivity(steam);
            }
        });
        googledrive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent drive=getActivity().getPackageManager().getLaunchIntentForPackage("com.google.android.apps.docs");
                startActivity(drive);
            }
        });
        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent youtube=getActivity().getPackageManager().getLaunchIntentForPackage("com.google.android.youtube");
                startActivity(youtube);
            }
        });

        return view;
    }
}