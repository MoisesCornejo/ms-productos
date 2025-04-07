package cl.moises.springcloud.msproductos.controllers;

import cl.moises.springcloud.msproductos.entities.Producto;
import cl.moises.springcloud.msproductos.services.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/productos")
    public ResponseEntity<List<Producto>> findAll() {
        return ResponseEntity.ok().body(productoService.findAll());
    }

    @GetMapping("/producto/{id}")
    public ResponseEntity<Producto> findById(@PathVariable Long id) {
        Optional<Producto> productoOptional = productoService.findById(id);
        if (productoOptional.isPresent()) {
            return ResponseEntity.ok().body(productoOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

}
