package com.modulo.aplicaciones.moviles.product.api.rest;


import com.modulo.aplicaciones.moviles.product.api.entity.Producto;
import com.modulo.aplicaciones.moviles.product.api.persistence.ProductoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/producto",
        produces = "application/json")
public class ProductoController {
 
    private ProductoRepository productoRepo;


    public ProductoController(ProductoRepository productoRepo) {
        this.productoRepo = productoRepo;
    }

    @GetMapping("/all")
    public List<Producto> getAll(){
        return productoRepo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Producto> getProductById(@PathVariable(name = "id") int id){
        return productoRepo.findById(Long.parseLong(""+id));
    }

    @PostMapping()
    public Producto postPorduct(@RequestBody Producto p){
        productoRepo.save(p);
        return p;
    }

    @DeleteMapping("/{id}")
    public Producto deleteProduct(@PathVariable(name = "id") int id){
        productoRepo.delete(productoRepo.findById(Long.parseLong(""+id)).get());
        Producto p = new Producto();
        p.setDescripcion("");
        p.setNombre("Elemento eliminado");
        return p;
    }

    @PatchMapping("/{id}")
    public Producto patchProduct(@PathVariable(name = "id") int id, @RequestBody Producto p){
        p.setId(id);
        productoRepo.save(p);
        return p;
    }
}
