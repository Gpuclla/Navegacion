package com.example.navegacion;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.gauravk.audiovisualizer.visualizer.CircleLineVisualizer;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Musica#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Musica extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Musica() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Musica.
     */
    // TODO: Rename and change types and number of parameters
    public static Extra newInstance(String param1, String param2) {
        Extra fragment = new Extra();
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

    private Button play_pausa, sig,atras;
    private TextView txt;
    private MediaPlayer mp;
    private CircleLineVisualizer mVisualizer;
    /*int canciones =(R.raw.juegos+R.raw.daft_punk_hdfs);
    int index=0;*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_slideshow, container, false);

        txt=view.findViewById(R.id.txt);
        play_pausa= view.findViewById(R.id.play);
        sig= view.findViewById(R.id.next);
        atras= view.findViewById(R.id.back);
        mp=MediaPlayer.create(getContext(),R.raw.daft_punk_hdfs);
        mVisualizer = view.findViewById(R.id.circle);

        play_pausa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mp.isPlaying()){
                    mp.pause();
                    play_pausa.setBackgroundResource(R.drawable.reproducir);
                    int audioSessionId = mp.getAudioSessionId();
                    if (audioSessionId != -1) {
                        mVisualizer.setAudioSessionId(audioSessionId);
                    }
                }
                else{
                    mp.start();
                    play_pausa.setBackgroundResource(R.drawable.pausa);
                }
            }
        });

        return view;
    }
}