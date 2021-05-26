package com.modulo.aplicaciones.moviles.activity.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.modulo.aplicaciones.moviles.activity.retrofit.adapter.ProductAdapter;
import com.modulo.aplicaciones.moviles.activity.retrofit.model.Product;
import com.modulo.aplicaciones.moviles.activity.retrofit.service.GetAllElementService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Product> productList;
    private ProductAdapter productAdapter;
    private ListView productListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productList = new ArrayList<>();
        productAdapter = new ProductAdapter(this,R.layout.simple_product_source, productList);
        productListView = (ListView) findViewById(R.id.productlist);

        productListView.setAdapter(productAdapter);

        getAllProduct();

    }

    private void getAllProduct(){
        Retrofit retrofit  = new Retrofit.Builder()
                                .baseUrl("http://192.168.1.101:8080")
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();

        GetAllElementService getAllElementService = retrofit.create(GetAllElementService.class);
        Call<List<Product>> call = getAllElementService.getAllProducts();

        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                for(Product p: response.body()){
                    productAdapter.add(p);
                }
                productAdapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
            }
        });
    }
}