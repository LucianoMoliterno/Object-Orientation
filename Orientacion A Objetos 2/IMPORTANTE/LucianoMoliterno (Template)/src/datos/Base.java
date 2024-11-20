package datos;

public class Base extends Plan {
	private int limiteConsultasGratis;
	private double costoAdicional;

	public Base() {
		super();
	}

	public Base(String nombre, double costoBase, double descuento, String cobertura, int limiteConsultasGratis,
			double costoAdicional) {
		super(nombre, costoBase, descuento, cobertura);
		this.limiteConsultasGratis = limiteConsultasGratis;
		this.costoAdicional = costoAdicional;
	}

	public int getLimiteConsultasGratis() {
		return limiteConsultasGratis;
	}

	public void setLimiteConsultasGratis(int limiteConsultasGratis) {
		this.limiteConsultasGratis = limiteConsultasGratis;
	}

	public double getCostoAdicional() {
		return costoAdicional;
	}

	public void setCostoAdicional(double costoAdicional) {
		this.costoAdicional = costoAdicional;
	}

	// Enmascaramiento De La Superclase
	@Override
	public String toString() {
		return "Base [" + super.toString() + "limiteConsultasGratis=" + limiteConsultasGratis
				+ "costoAdicional=" + costoAdicional + "]";
	}

}
