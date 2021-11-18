package com.example.navegacion;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Calculadora#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Calculadora extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Calculadora() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Calculadora.
     */
    // TODO: Rename and change types and number of parameters
    public static Calculadora newInstance(String param1, String param2) {
        Calculadora fragment = new Calculadora();
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

    private View view;
    private Button btnSuma, btnResta, btnProducto, btnDiv, btnLimpiar;
    private EditText txtnum1, txtnm2;
    private TextView txtresultado;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        txtnum1 = view.findViewById(R.id.numero1);
        txtnm2 = (EditText) view.findViewById(R.id.numero2);
        txtresultado = (TextView) view.findViewById(R.id.resultado);
        btnSuma = (Button) view.findViewById(R.id.btnsuma);
        btnResta = (Button) view.findViewById(R.id.btnresta);
        btnProducto = (Button) view.findViewById(R.id.btnmultiplicacion);
        btnDiv = (Button) view.findViewById(R.id.btndivision);
        btnLimpiar = (Button) view.findViewById(R.id.btnlimpiar);

        btnSuma.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                double numero1 = Double.parseDouble(txtnum1.getText().toString());
                double numero2 = Double.parseDouble(txtnm2.getText().toString());
                double resultado = numero1 + numero2;
                txtresultado.setText("El resultado es : " + resultado);
            }

        });

        btnResta.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                double numero1 = Double.parseDouble(txtnum1.getText().toString());
                double numero2 = Double.parseDouble(txtnm2.getText().toString());
                double resultado = numero1 - numero2;
                txtresultado.setText("El resultado es : " + resultado);
            }

        });

        btnProducto.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                double numero1 = Double.parseDouble(txtnum1.getText().toString());
                double numero2 = Double.parseDouble(txtnm2.getText().toString());
                double resultado = numero1 * numero2;
                txtresultado.setText("El resultado es : " + resultado);
            }

        });

        btnDiv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                double numero1 = Double.parseDouble(txtnum1.getText().toString());
                double numero2 = Double.parseDouble(txtnm2.getText().toString());
                double resultado = numero1 / numero2;
                txtresultado.setText("El resultado es : " + resultado);
            }

        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtnum1.setText("");
                txtnum1.invalidate();
                txtnm2.setText("");
                txtnm2.invalidate();
                txtresultado.setText("");
                txtresultado.invalidate();
            }
        });
        return view;
    }
}



