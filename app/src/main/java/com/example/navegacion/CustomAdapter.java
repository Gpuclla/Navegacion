package com.example.navegacion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class CustomAdapter extends BaseAdapter {
    Context context;
    List<MaravillasModernas> lst;

    public CustomAdapter(Context context, List<MaravillasModernas> lst) {
        this.context = context;
        this.lst = lst;
    }

    @Override
    public int getCount() {
        return lst.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imagen;
        TextView nombre,ubica,decri;
        MaravillasModernas p=lst.get(i);

        if (view==null)
            view= LayoutInflater.from(context).inflate(R.layout.item,null);

        imagen=view.findViewById(R.id.imgmarv);
        nombre=view.findViewById(R.id.txtnombre);
        ubica=view.findViewById(R.id.txtubicacion);
        decri= view.findViewById(R.id.txtdecrip);

        imagen.setImageResource(p.imagen);
        nombre.setText(p.nombre);
        ubica.setText(p.ubicacion);
        decri.setText(p.descripcion);
        return view;
    }
}

