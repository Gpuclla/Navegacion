package com.example.navegacion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class MaravillaActivity extends AppCompatActivity {

    ImageView img;
    TextView txta,txtb,txtc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        img=findViewById(R.id.imgmarv);
        txta=findViewById(R.id.txtname);
        txtb=findViewById(R.id.txtubica);
        txtc=findViewById(R.id.txtdecripc);
        Intent i= getIntent();
        int image_link = getIntent().getIntExtra("imagen",1);
        String txt1= i.getStringExtra("nombre");
        String txt2= i.getStringExtra("ubicacion");
        String txt3= i.getStringExtra("descripcion");
        txta.setText(txt1);
        txtb.setText(txt2);
        txtc.setText(txt3);
        img.setImageResource(image_link);

    }
}
