package com.modulo.aplicaciones.moviles.product.api.persistence;

import com.modulo.aplicaciones.moviles.product.api.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface ProductoRepository extends CrudRepository<Producto, Long> {
    List<Producto> findAll();
    Optional<Producto> findById(Long id);

}
