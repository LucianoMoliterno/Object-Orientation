package datos;

public abstract class Vehiculo {
	protected int idVehiculo;
	protected String patente;

	public Vehiculo() {
		super();
	}

	public Vehiculo(String patente) {
		super();
		this.patente = patente;
	}

	public int getIdVehiculo() {
		return idVehiculo;
	}

	protected void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	// Imprime Unicamente Datos Internos
	@Override
	public String toString() {
		return "Vehiculo [patente=" + patente + "]";
	}

}
