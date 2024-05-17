package test;

import datos.Cliente;
import negocio.ClienteABM;

public class TestActualizarCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteABM abm = new ClienteABM();
		long id = 1;
		Cliente c = abm.traer(id);
		System.out.println("cliente a modificar: " + c);
	}

}
