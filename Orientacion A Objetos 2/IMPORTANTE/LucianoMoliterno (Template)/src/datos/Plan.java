package datos;

public abstract class Plan {
	protected int idPlan;
	protected String nombre;
	protected double costoBase;
	protected double descuento;
	protected String cobertura;

	public Plan() {
		super();
	}

	public Plan(String nombre, double costoBase, double descuento, String cobertura) {
		super();
		this.nombre = nombre;
		this.costoBase = costoBase;
		this.descuento = descuento;
		this.cobertura = cobertura;
	}

	public int getIdPlan() {
		return idPlan;
	}

	protected void setIdPlan(int idPlan) {
		this.idPlan = idPlan;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCostoBase() {
		return costoBase;
	}

	public void setCostoBase(double costoBase) {
		this.costoBase = costoBase;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public String getCobertura() {
		return cobertura;
	}

	public void setCobertura(String cobertura) {
		this.cobertura = cobertura;
	}

	// Imprime Unicamente Datos Internos
	@Override
	public String toString() {
		return "Plan [nombre=" + nombre + ", costoBase=" + costoBase + ", descuento=" + descuento + ", cobertura="
				+ cobertura + "]";
	}

}
