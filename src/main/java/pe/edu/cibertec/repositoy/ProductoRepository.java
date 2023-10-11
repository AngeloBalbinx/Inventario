package pe.edu.cibertec.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.cibertec.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{

}
