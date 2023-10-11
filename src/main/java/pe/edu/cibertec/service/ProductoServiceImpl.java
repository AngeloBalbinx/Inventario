package pe.edu.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.model.Producto;
import pe.edu.cibertec.repositoy.ProductoRepository;
@Service
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	private ProductoRepository repProd;

	@Override
	public List<Producto> listarProductos() {
		return repProd.findAll();
	}

	@Override
	public Producto buscarProductoPorId(Integer idProducto) {
		Producto producto = repProd.findById(idProducto).orElse(null);
		return producto;
	}

	@Override
	public Producto guardarProducto(Producto producto) {
		return repProd.save(producto);
		
	}

	@Override
	public void eliminarProductoPorId(Integer idProducto) {
		repProd.deleteById(idProducto);
		
	}

}
