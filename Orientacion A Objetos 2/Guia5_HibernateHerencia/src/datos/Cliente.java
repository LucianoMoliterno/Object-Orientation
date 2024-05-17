package datos;

import java.util.Objects;

public abstract class Cliente {
	protected int idCliente;
	protected String nroCliente;

	public Cliente() {
	}

	public Cliente(String nroCliente) {
		super();
		this.nroCliente = nroCliente;
	}

	public int getIdCliente() {
		return idCliente;
	}

	protected void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNroCliente() {
		return nroCliente;
	}

	public void setNroCliente(String nroCliente) {
		this.nroCliente = nroCliente;
	}

	@Override
	public String toString() {
		return "idCliente=" + idCliente + ", nroCliente=" + nroCliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nroCliente);
	}

	@Override
	public boolean equals(Object obj) {
		Cliente other = (Cliente) obj;
		return Objects.equals(nroCliente, other.nroCliente);
	}

}
