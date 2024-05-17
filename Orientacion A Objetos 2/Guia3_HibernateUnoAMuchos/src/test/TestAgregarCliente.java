package test;

import java.time.LocalDate;

import negocio.ClienteABM;

public class TestAgregarCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String apellido = "mr";
		String nombre = "x";
		int documento = 22334455;
		LocalDate fechaDeNacimiento = LocalDate.now();
		boolean baja = false;
		ClienteABM abm = new ClienteABM();
		try {
			long ultimoIdCliente = abm.agregar(apellido, nombre, documento, fechaDeNacimiento, baja);
			System.out.println(ultimoIdCliente);
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
