package datos;

import java.time.LocalDate;

public class Afiliado {
	private int idAfiliado;
	private String nombre;
	private String apellido;
	private String nroAfiliado;
	private LocalDate fechaAlta;
	private Plan plan;

	public Afiliado() {
		super();
	}

	public Afiliado(String nombre, String apellido, String nroAfiliado, LocalDate fechaAlta, Plan plan) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.nroAfiliado = nroAfiliado;
		this.fechaAlta = fechaAlta;
		this.plan = plan;
	}

	public int getIdAfiliado() {
		return idAfiliado;
	}

	protected void setIdAfiliado(int idAfiliado) {
		this.idAfiliado = idAfiliado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNroAfiliado() {
		return nroAfiliado;
	}

	public void setNroAfiliado(String nroAfiliado) {
		this.nroAfiliado = nroAfiliado;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	// Imprime Unicamente Datos Internos
	@Override
	public String toString() {
		return "Afiliado [idAfiliado=" + idAfiliado + ", nombre=" + nombre + ", apellido=" + apellido + ", nroAfiliado="
				+ nroAfiliado + ", fechaAlta=" + fechaAlta + ", plan=" + plan + "]";
	}

	// Imprime Datos Internos (Reutiliza el de arriba) + Datos Entidades
	// Relacionadas
	public String toStringConProducto() {
		return toString() + "" + plan;
	}

}
