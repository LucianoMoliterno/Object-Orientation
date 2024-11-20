package datos;

public class Premium extends Plan {
	private String servicioAdicional;
	private double tarifaAdicional;

	public Premium() {
		super();
	}

	public Premium(String nombre, double costoBase, double descuento, String cobertura, String servicioAdicional,
			double tarifaAdicional) {
		super(nombre, costoBase, descuento, cobertura);
		this.servicioAdicional = servicioAdicional;
		this.tarifaAdicional = tarifaAdicional;
	}

	public String getServicioAdicional() {
		return servicioAdicional;
	}

	public void setServicioAdicional(String servicioAdicional) {
		this.servicioAdicional = servicioAdicional;
	}

	public double getTarifaAdicional() {
		return tarifaAdicional;
	}

	public void setTarifaAdicional(double tarifaAdicional) {
		this.tarifaAdicional = tarifaAdicional;
	}

	// Enmascaramiento De La Superclase
	@Override
	public String toString() {
		return "Premium [" + super.toString() + "servicioAdicional=" + servicioAdicional + ", tarifaAdicional="
				+ tarifaAdicional + "]";
	}

}
