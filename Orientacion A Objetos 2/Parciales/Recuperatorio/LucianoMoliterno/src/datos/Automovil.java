package datos;

public class Automovil extends Vehiculo {
	private boolean esPickUp;

	public Automovil() {
		super();
	}

	public Automovil(String patente, boolean esPickUp) {
		super(patente);
		this.esPickUp = esPickUp;
	}

	public boolean isEsPickUp() {
		return esPickUp;
	}

	public void setEsPickUp(boolean esPickUp) {
		this.esPickUp = esPickUp;
	}

//Enmascaramiento De La Superclase
	@Override
	public String toString() {
		return "Automovil [" + super.toString() + "esPickUp=" + esPickUp + "]";
	}

}
