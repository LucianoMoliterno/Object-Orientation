package test;

import negocio.ClienteABM;

public class TestTraerClientesYEventos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteABM clienteABM = new ClienteABM();
		System.out.println(clienteABM.traerClienteYEventos(2L));
	}

}
