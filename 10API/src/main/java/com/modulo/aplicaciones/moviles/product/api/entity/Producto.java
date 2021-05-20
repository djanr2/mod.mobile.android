package com.modulo.aplicaciones.moviles.product.api.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;
    private double descuento;

}
