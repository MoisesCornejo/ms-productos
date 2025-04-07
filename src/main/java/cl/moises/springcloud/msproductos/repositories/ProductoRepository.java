package cl.moises.springcloud.msproductos.repositories;

import cl.moises.springcloud.msproductos.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
