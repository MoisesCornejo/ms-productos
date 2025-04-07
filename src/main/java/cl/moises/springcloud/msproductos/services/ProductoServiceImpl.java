package cl.moises.springcloud.msproductos.services;

import cl.moises.springcloud.msproductos.entities.Producto;
import cl.moises.springcloud.msproductos.repositories.ProductoRepository;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements ProductoService{

    private final ProductoRepository productoRepository;
    private final Environment environment;

    public ProductoServiceImpl(ProductoRepository productoRepository, Environment environment) {
        this.productoRepository = productoRepository;
        this.environment = environment;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll() {
        return productoRepository.findAll().stream().map(producto -> {
            producto.setPort(Integer.parseInt(Objects.requireNonNull(environment.getProperty("local.server.port"))));
            return producto;
        }).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id).map(producto -> {
            producto.setPort(Integer.parseInt(Objects.requireNonNull(environment.getProperty("local.server.port"))));
            return producto;
        });
    }

}
