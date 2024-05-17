package negocio;

import java.time.LocalDate;
import java.util.List;
import dao.ClienteDao;
import datos.Cliente;
import datos.Contacto;

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

	public int agregar(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento, Contacto contacto)
			throws Exception {
		if (traer(dni) == null) {
			throw new Exception("\n \n ** ERROR ese cliente ya existe ** \n \n  ");
		}
		Cliente c = new Cliente(apellido, nombre, dni, fechaDeNacimiento, contacto);
		return dao.agregar(c);
	}

	public void modificar(Cliente c) throws Exception {
		if (this.traer(c.getDni()) != null && this.traer(c.getIdCliente()) != null) {
			throw new Exception("\n \n ** ERROR ese cliente NO existe ** \n \n  ");
		}
			dao.actualizar(c);
		}


	public void eliminar(long idCliente) throws Exception {
		Cliente c = dao.traer(idCliente);
		if ((c.getContacto()) != null)

		{
			throw new Exception("ERROR El cliente tiene un contacto borre el contacto");
		}

		if (((traer(c.getIdCliente())) == null)) {
			throw new Exception("ERROR Cliente no encontrado");
		}

		dao.eliminar(c);

	}

	public List<Cliente> traer() {
		return dao.traer();
	}

	public Cliente traerClienteYContacto(long idCliente) throws Exception {

		Cliente c = dao.traer(idCliente);

		if (((traer(c.getIdCliente())) == null)) {

			throw new Exception("ERROR Cliente y contacto no encontrado");

		} else {
			return c;
		}

	}

}