package test;

import java.time.LocalDate;
import datos.Cliente;
import negocio.ClienteABM;

public class TestActualizarCliente {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long idCliente = 1;
		ClienteABM clienteABM = new ClienteABM();
		Cliente c = clienteABM.traer(idCliente);
		System.out.println("Cliente a Modificar -->" + c);
		LocalDate fecha = LocalDate.of(1995, 3, 16);
		c.setDni(38703312);
		c.setApellido("Velez");
		c.setNombre("Matias");
		c.setFechaDeNacimiento(fecha);
		try {

			clienteABM.traer(idCliente);
			System.out.println("\n \n *****Modificado Con exito**** \n \n ");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Cliente clienteModificado = clienteABM.traer(c.getDni());
		System.out.println("\n \n Cliente Modificado --> " + clienteModificado.getDni() + "\n \n ");
	}
}
