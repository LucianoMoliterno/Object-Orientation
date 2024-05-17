package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.ClienteDao;
import datos.Cliente;

public class ClienteABM {
	ClienteDao dao = new ClienteDao();

	public Cliente traer(long idCliente) {
		Cliente c = dao.traer(idCliente);
		return c;
	}

	public Cliente traer(int dni) {
		Cliente c = dao.traer(dni);
		return c;
	}

	public int agregar(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento) throws Exception {
		if (this.traer(dni) != null) {
			throw new Exception("el cliente ya existe");
		}
		Cliente c = new Cliente(apellido, nombre, dni, fechaDeNacimiento, false);
		return dao.agregar(c);
	}

	public void modificar(Cliente c) throws Exception {
		if (this.traer(c.getIdCliente()) != null && this.traer(c.getDni()) != null) {
			throw new Exception("no existe cliente con el id" + c.getIdCliente() + "y con el dni " + c.getDni());
		}
		dao.actualizar(c);
	}

	public void eliminar(long idCliente) throws Exception {
		Cliente c = dao.traer(idCliente);
		if (c == null) {
			throw new Exception("no existe cliente con el id " + idCliente);
		}
		dao.eliminar(c);
	}

	public List<Cliente> traer() {
		return dao.traer();
	}
}
