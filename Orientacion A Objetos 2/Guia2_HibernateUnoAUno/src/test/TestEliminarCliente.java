package test;

import datos.Cliente;
import negocio.ClienteABM;

public class TestEliminarCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long id = 2;
		ClienteABM clienteABM = new ClienteABM();
		Cliente c = clienteABM.traer(id);
		System.out.println("Cliente a Borrar -->" + c);
		try {
			clienteABM.eliminar(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("El Cliente Fue eliminado : " + c.getNombre() + " " + c.getApellido());
	}

}
