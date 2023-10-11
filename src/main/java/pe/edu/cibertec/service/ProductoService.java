package pe.edu.cibertec.service;

import java.util.List;

import pe.edu.cibertec.model.Producto;

public interface ProductoService {
	public List<Producto> listarProductos();
	public Producto buscarProductoPorId(Integer idProducto);
	public Producto guardarProducto(Producto producto);
	public void eliminarProductoPorId(Integer idProducto);
}
