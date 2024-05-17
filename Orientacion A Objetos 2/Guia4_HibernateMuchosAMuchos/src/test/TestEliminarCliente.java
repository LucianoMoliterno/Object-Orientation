package test;

import datos.Cliente;
import negocio.ClienteABM;

public class TestEliminarCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteABM clienteABM = new ClienteABM();
		// Id A Borrar
		long idCliente = 3L;
		// traer el obj a modificar
		Cliente c = null;
		try {
			c = clienteABM.traer(idCliente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		// Cliente c = abm.traer(id);
		System.out.println("Cliente a Borrar -->" + c);

		try {
			clienteABM.eliminar(idCliente);
			System.out.println("\n \n *****Eliminado**** \n \n ");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
