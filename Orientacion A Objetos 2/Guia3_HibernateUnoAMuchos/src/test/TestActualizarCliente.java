package test;

import java.time.LocalDate;

import datos.Cliente;
import negocio.ClienteABM;

public class TestActualizarCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteABM abm = new ClienteABM();
		Cliente c = new Cliente();
		long id = 1;
		try {
			c = abm.traer(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		LocalDate fecha = LocalDate.of(1994, 01, 16);
		// modificar por set los atributos
		c.setDni(38079225);
		c.setApellido("Diego H.");
		c.setNombre("Ibanez");
		c.setFechaDeNacimiento(fecha);
		try {
			abm.modificar(c); // update del objeto
			int dni = 38079225;
			Cliente cModif = abm.traer(dni);
			System.out.println("Cliente a Modificar -->" + c);
			System.out.println("Cliente Modificado -->" + cModif);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
