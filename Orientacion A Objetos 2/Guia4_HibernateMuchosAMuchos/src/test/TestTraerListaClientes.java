package test;

import negocio.ClienteABM;
import negocio.EventoABM;

public class TestTraerListaClientes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteABM clienteABM = new ClienteABM();
		EventoABM eventoABM = new EventoABM();
		System.out.println("\n \n \n");
		System.out.println(clienteABM.traer());
		System.out.println("\n \n \n");
		System.out.println(eventoABM.traer());
	}
}
