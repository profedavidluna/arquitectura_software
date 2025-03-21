package com.curso.soa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

public class SoaApplication {

	private static final String AUTH_URL = "http://localhost:8080/auth/login";
	private static final String CATALOG_URL = "http://localhost:8081/catalog/productos";
	private static final String ORDER_URL = "http://localhost:8082/orders";
	private static final String PAYMENT_URL = "http://localhost:8083/payments";
	private static final String NOTIFICATION_URL = "http://localhost:8084/notifications";

	private RestTemplate restTemplate = new RestTemplate();

	public static void main(String[] args) {
		SoaApplication proceso = new SoaApplication();
		proceso.ejecutarProceso();
	}

	public void ejecutarProceso() {
		// 1. Autenticación del Cliente
		Cliente cliente = autenticarCliente("davidrlunag@gmail.com", "12345678");
		if (cliente == null) {
			System.out.println("Error: Autenticación fallida.");
			return;
		}
		System.out.println("Cliente autenticado: " + cliente.getNombre());

		// 2. Búsqueda de Productos
		List<Producto> productos = buscarProductos();
		if (productos.isEmpty()) {
			System.out.println("Error: No se encontraron productos.");
			return;
		}
		System.out.println("Productos encontrados: " + productos);

		// 3. Creación del Pedido
		Pedido pedido = crearPedido(cliente.getId(), "1,2"); // IDs de productos
		if (pedido == null) {
			System.out.println("Error: No se pudo crear el pedido.");
			return;
		}
		System.out.println("Pedido creado: " + pedido.getId());

		// 4. Procesamiento del Pago
		Pago pago = procesarPago(pedido.getId(), 2000.00); // Monto del pedido
		if (pago == null || !"Procesado".equals(pago.getEstado())) {
			System.out.println("Error: No se pudo procesar el pago.");
			return;
		}
		System.out.println("Pago procesado: " + pago.getId());

		// 5. Notificación al Cliente
		Notificacion notificacion = notificarCliente(cliente.getEmail(), "Su pedido ha sido procesado correctamente.");
		if (notificacion == null) {
			System.out.println("Error: No se pudo enviar la notificación.");
			return;
		}
		System.out.println("Notificación enviada: " + notificacion.getId());
	}

	private Cliente autenticarCliente(String email, String password) {
		try {
			AuthRequest authRequest = new AuthRequest(email, password);
			ResponseEntity<Cliente> response =
					restTemplate.postForEntity(AUTH_URL+"?email="+email+"&password="+password, null, Cliente.class);
			return response.getBody();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private List<Producto> buscarProductos() {
		try {
			ResponseEntity<Producto[]> response = restTemplate.getForEntity(CATALOG_URL, Producto[].class);
			return Arrays.asList(response.getBody());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private Pedido crearPedido(Long clienteId, String productosIds) {
		try {
			PedidoRequest pedidoRequest = new PedidoRequest(clienteId, productosIds, "Pendiente");
			ResponseEntity<Pedido> response = restTemplate.postForEntity(ORDER_URL, pedidoRequest, Pedido.class);
			return response.getBody();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private Pago procesarPago(Long pedidoId, Double monto) {
		try {
			PagoRequest pagoRequest = new PagoRequest(pedidoId, monto, "Pendiente");
			ResponseEntity<Pago> response = restTemplate.postForEntity(PAYMENT_URL, pagoRequest, Pago.class);
			return response.getBody();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private Notificacion notificarCliente(String email, String mensaje) {
		try {
			NotificacionRequest notificacionRequest = new NotificacionRequest(email, mensaje);
			ResponseEntity<Notificacion> response = restTemplate.postForEntity(NOTIFICATION_URL+"?email="+email+"&mensaje="+mensaje, null, Notificacion.class);
			return response.getBody();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}

// Clases de Solicitud (Request)
class AuthRequest {


	private String email;
	private String password;

	public AuthRequest(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}}

class PedidoRequest {
	private Long clienteId;
	private List<Long> productosIds;


	private String estado;

	public PedidoRequest(Long clienteId, String productosId, String estado) {
		this.clienteId = clienteId;
		this.productosIds = productosIds;
		this.estado = estado;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public List<Long> getProductosIds() {
		return productosIds;
	}

	public void setProductosIds(List<Long> productosIds) {
		this.productosIds = productosIds;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}

class PagoRequest {
	private Long pedidoId;
	private Double monto;


	private String estado;

	public PagoRequest(Long pedidoId, Double monto, String estado) {
		this.pedidoId = pedidoId;
		this.monto = monto;
		this.estado = estado;
	}

	public Long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}

class NotificacionRequest {


	private String email;
	private String mensaje;

	public NotificacionRequest(String email, String mensaje) {
		this.email = email;
		this.mensaje = mensaje;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}}

// Clases de Respuesta (Response)
class Cliente {
	private Long id;
	private String nombre;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private String email;

}

class Producto {


	private Long id;
	private String nombre;
	private Double precio;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
}

class Pedido {
	private Long id;
	private Long clienteId;
	private List<Long> productosIds;
	private String estado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public List<Long> getProductosIds() {
		return productosIds;
	}

	public void setProductosIds(List<Long> productosIds) {
		this.productosIds = productosIds;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}

class Pago {


	private Long id;
	private Long pedidoId;
	private Double monto;
	private String estado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}}

class Notificacion {
	private Long id;
	private String email;
	private String mensaje;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	// Getters y Setters
}