package pe.edu.cibertec.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.cibertec.model.Producto;
import pe.edu.cibertec.service.ProductoService;

@RestController
@RequestMapping("inventario-app")
@CrossOrigin(value="http://localhost:4200")
public class ProductoController {
	

	
	@Autowired
	private ProductoService servProd;
	@GetMapping("/productos")
	public List<Producto> obtenerProductos(){
		List<Producto> productos = servProd.listarProductos();
		return productos;
		
	}
	@PostMapping("/agregarprod")
	public Producto agregarProducto(@RequestBody Producto producto) {
		return servProd.guardarProducto(producto);
		
	}
	
	@GetMapping("/productos/{id}")
	public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable int id){
		Producto producto = servProd.buscarProductoPorId(id);
		return ResponseEntity.ok(producto);
	}
	@PutMapping("/productos/{id}")
	public ResponseEntity<Producto> actualizarProducto(@PathVariable int id, @RequestBody Producto productoRecibido){
		Producto producto = servProd.buscarProductoPorId(id);
		producto.setDescripcion(productoRecibido.getDescripcion());
		producto.setPrecio(productoRecibido.getPrecio());
		producto.setExistencia(productoRecibido.getExistencia());
		servProd.guardarProducto(producto);
		return ResponseEntity.ok(producto);
		
	}
	
	@DeleteMapping("/productos/{id}")
	public void eliminarProducto(@PathVariable int id) {
		servProd.eliminarProductoPorId(id);
	}
}
