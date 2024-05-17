package test;

import java.time.LocalDate;

import datos.Cliente;
import negocio.ClienteABM;

public class TestActualizarCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteABM clienteABM = new ClienteABM();
		long idCliente = 5L;
		Cliente cliente = null;

		try {
			cliente = clienteABM.traer(idCliente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println(cliente);

		cliente.setDni(44444445);
		cliente.setApellido("Julian");
		cliente.setNombre("Ramirez");
		cliente.setFechaDeNacimiento(LocalDate.now());
		try {
			clienteABM.modificar(cliente);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println("\n*cliente modificado* \n" + clienteABM.traer(idCliente));

	}
}