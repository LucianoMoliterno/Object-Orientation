package test;

import java.time.LocalDate;

import datos.Cliente;
import negocio.ClienteABM;
import negocio.ContactoABM;

public class TestAgregarCliente {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nombre = " pedro";
		String apellido = "gomez";
		String email = "gomezcarlos@aaa.com";
		String movil = "12315466";
		String fijo = "+5412315466";
		int dni = 3245299;

		// tu fecha de nacimiento
		LocalDate fechaDeNacimiento = LocalDate.now();

		ClienteABM clienteABM = new ClienteABM();
		ContactoABM contactoABM = new ContactoABM();
		Cliente c = new Cliente();

		long ultimoIdCliente = 0;

		try {

			clienteABM.agregar(apellido, nombre, dni, fechaDeNacimiento, null);
			c = clienteABM.traer(dni);
			contactoABM.agregar(email, movil, fijo, c);

			ultimoIdCliente = c.getDni();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Nuevo Cliente Agregado ID:" + ultimoIdCliente);
	}
}
