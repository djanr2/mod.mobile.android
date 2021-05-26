package com.modulo.aplicaciones.moviles.activity.retrofit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.LayoutRes;

import com.modulo.aplicaciones.moviles.activity.retrofit.R;
import com.modulo.aplicaciones.moviles.activity.retrofit.model.Product;

import java.util.ArrayList;

public class ProductAdapter  extends ArrayAdapter<Product> {
    public ProductAdapter(Context con, @LayoutRes int res, ArrayList<Product> prod){
        super(con, res, prod);
    }

     @Override
    public View getView(int position, View view, ViewGroup parent){
        Product product = getItem(position);
        if(view == null)
            view = LayoutInflater.from(getContext()).inflate(R.layout.simple_product_source, parent, false);

         TextView auxView = (TextView)view.findViewById(R.id.product_id);
         String  auxString = ""+product.getId();
         auxView.setText(auxString);

         auxView = (TextView)view.findViewById(R.id.nombre);
         auxString = ""+product.getNombre();
         auxView.setText(auxString);

         auxView = (TextView)view.findViewById(R.id.descripcion);
         auxString = ""+product.getDescripcion();
         auxView.setText(auxString);

         auxView = (TextView)view.findViewById(R.id.precio);
         auxString = ""+product.getPrecio();
         auxView.setText(auxString);

         auxView = (TextView)view.findViewById(R.id.stock);
         auxString = ""+product.getStock();
         auxView.setText(auxString);

         auxView = (TextView)view.findViewById(R.id.descuento);
         auxString = ""+product.getNombre();
         auxView.setText(auxString);

         return view;
    }

}
