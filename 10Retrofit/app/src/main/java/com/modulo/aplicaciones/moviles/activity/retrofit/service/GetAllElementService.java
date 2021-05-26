package com.modulo.aplicaciones.moviles.activity.retrofit.service;

import com.modulo.aplicaciones.moviles.activity.retrofit.model.Product;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GetAllElementService {
    String ALL_PRODUCTS = "/producto/all";
    @GET(ALL_PRODUCTS)
    Call<List<Product>> getAllProducts();
}
