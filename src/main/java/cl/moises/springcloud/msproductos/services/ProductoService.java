package cl.moises.springcloud.msproductos.services;

import cl.moises.springcloud.msproductos.entities.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    List<Producto> findAll();
    Optional<Producto> findById(Long id);

}
