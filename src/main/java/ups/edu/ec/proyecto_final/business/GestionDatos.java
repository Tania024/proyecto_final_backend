package ups.edu.ec.proyecto_final.business;

import java.util.Date;
import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import ups.edu.ec.proyecto_final.dao.CabeceraFacturaDAO;
import ups.edu.ec.proyecto_final.dao.ClienteDAO;
import ups.edu.ec.proyecto_final.dao.DetalleFacturaDAO;
import ups.edu.ec.proyecto_final.dao.ProductoDAO;
import ups.edu.ec.proyecto_final.model.CabeceraFactura;
import ups.edu.ec.proyecto_final.model.Cliente;
import ups.edu.ec.proyecto_final.model.DetalleFactura;
import ups.edu.ec.proyecto_final.model.Producto;


@Singleton
@Startup
public class GestionDatos {
	@Inject
	private ClienteDAO daoCliente;
	
	@Inject
	private DetalleFacturaDAO daoDetalleFactura;
	
	@Inject
	private ProductoDAO daoProducto;
	
	@Inject
	private CabeceraFacturaDAO daoCabeceraFactura;
	
	@PostConstruct
	public void init() {
		System.out.println("iniciando");
		
		Cliente cliente = new Cliente();
		cliente.setCli_codigo(1);
		cliente.setCli_cedula("0106717671");
		cliente.setCli_direccion("Monay");
		cliente.setCli_nombre("Tania");
		cliente.setCli_telefono("0993235895");
		cliente.setCli_apellido("Lojano");
		cliente.setCli_usuario("tlojano");
		cliente.setCli_contrasena("proyecto_final");
		cliente.setCli_estado("Activo");
		
		daoCliente.insert(cliente);
		
		Producto producto = new Producto();
		producto.setPro_codigo(1);
		producto.setPro_fecha_registro(null);
		producto.setPro_imagen(null);
		producto.setPro_iva(12);
		producto.setPro_nombre("Mortadela");
		producto.setPro_precio(12.4);
		producto.setPro_stock(13);
		producto.setDetallesFactura(null);
		
		daoProducto.insert(producto);
		
		DetalleFactura detalle = new DetalleFactura();
		detalle.setDet_codigo(1);
		detalle.setDet_cantidad(2);
		detalle.setDet_precio(13);
		detalle.setDet_subtotal(20);
		detalle.setProducto(null);
		detalle.setCliente(cliente);
		detalle.setCabeceraFactura(null);
		
		daoDetalleFactura.insert(detalle);
		
		CabeceraFactura cabecera = new CabeceraFactura();
		cabecera.setCab_codigo(1);
		cabecera.setCab_fecha(null);
		cabecera.setCab_iva(12);
		cabecera.setCab_subtotal(20);
		cabecera.setCab_total(23);
		cabecera.setCliente(cliente);
		cabecera.setDetalles(null);
		
		daoCabeceraFactura.insert(cabecera);
		}
	}

