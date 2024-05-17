package test;

import datos.Cliente;
import negocio.ClienteABM;

public class TestTraerClienteYContacto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteABM abmCliente = new ClienteABM();
		long idCliente = 1;
		try {
			Cliente c = abmCliente.traerClienteYContacto(idCliente);
			System.out.println(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}

}
