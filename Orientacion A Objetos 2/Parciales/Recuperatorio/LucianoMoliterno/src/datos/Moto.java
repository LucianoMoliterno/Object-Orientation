package datos;

public class Moto extends Vehiculo {
	private boolean esMensajeria;

	public Moto() {
		super();
	}

	public Moto(String patente, boolean esMensajeria) {
		super(patente);
		this.esMensajeria = esMensajeria;
	}

	public boolean isEsMensajeria() {
		return esMensajeria;
	}

	public void setEsMensajeria(boolean esMensajeria) {
		this.esMensajeria = esMensajeria;
	}

//Enmascaramiento De La Superclase
	@Override
	public String toString() {
		return "Moto [" + super.toString() + "esMensajeria=" + esMensajeria + "]";
	}

}
