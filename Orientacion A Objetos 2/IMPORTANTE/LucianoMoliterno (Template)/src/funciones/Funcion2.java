package funciones;


public class Funcion2 {

/*
 
 public abstract class Stock {

	protected int idStock;
	protected int cantidad;
	protected Producto producto;
	protected Lote lote;

	public Stock() {
	}

	public Stock(int cantidad, Producto producto, Lote lote) {
		super();
		this.cantidad = cantidad;
		this.producto = producto;
		this.lote = lote;
	}

	public int getIdStock() {
		return idStock;
	}

	protected void setIdStock(int idStock) {
		this.idStock = idStock;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Lote getLote() {
		return lote;
	}

	public void setLote(Lote lote) {
		this.lote = lote;
	}

	// Imprime Unicamente Datos Internos
	@Override
	public String toString() {
		return "Stock [cantidad=" + cantidad + "]";
	}

	// Imprime Datos Internos (Reutiliza el de arriba) + Datos Entidades
	// Relacionadas
	public String toStringConProductoYLote() {
		return toString() + "" + producto + "" + lote;
	}
	
	-------------------------------------------------------------------------------
	public class Almacen extends Stock {

	private String ubicacion;

	public Almacen() {
	}

	public Almacen(int cantidad, Producto producto, Lote lote, String ubicacion) {
		super(cantidad, producto, lote);
		this.ubicacion = ubicacion;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	// Enmascaramiento De La Superclase
	@Override
	public String toString() {
		return "Almacen [idAlmacen=" + idStock + "," + super.toString() + "ubicacion=" + ubicacion + "]";
	}
	
	------------------------------------------------------------------------------------------
	public class Pedido extends Stock {

	private LocalDate fecha;
	private String cliente;

	public Pedido() {
	}

	public Pedido(int cantidad, Producto producto, Lote lote, LocalDate fecha, String cliente) {
		super(cantidad, producto, lote);
		this.fecha = fecha;
		this.cliente = cliente;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

//Enmascaramiento De La Superclase
	@Override
	public String toString() {
		return "Pedido [idPedido=" + idStock + "," + super.toString() + "fecha=" + fecha + ", cliente=" + cliente + "]";
	}
	
	----------------------------------------------------------------------------------------------------------------
	public class Lote {

	private int idLote;
	private String codigo;
	private Producto producto;

	public Lote() {
	}

	public Lote(String codigo, Producto producto) {
		super();
		this.codigo = codigo;
		this.producto = producto;
	}

	public int getIdLote() {
		return idLote;
	}

	protected void setIdLote(int idLote) {
		this.idLote = idLote;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	// Imprime Unicamente Datos Internos
	@Override
	public String toString() {
		return "Lote [idLote=" + idLote + ", codigo=" + codigo + "]";
	}

	// Imprime Datos Internos (Reutiliza el de arriba) + Datos Entidades
	// Relacionadas
	public String toStringConProducto() {
		return toString() + "" + producto;
	}
	
	--------------------------------------------------------------------------------
	
	public class Producto {

	private int idProducto;
	private String codigo;
	private String nombre;
	private double precio;

	public Producto() {
	}

	public Producto(String codigo, String nombre, double precio) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
	}

	public int getIdProducto() {
		return idProducto;
	}

	protected void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio
				+ "]";
	}

 // Enmascaramiento De La Superclase (si no esta la ID en la clase hija)
	@Override
	public String toString() {
		return "Auricular [" + super.toString() + "tipoUso=" + tipoUso + ", microfonoIncorporado="
				+ microfonoIncorporado + "]";
	}
		
 */
	
}
