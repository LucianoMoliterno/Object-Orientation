package test;

import java.time.LocalDate;

import negocio.ClienteABM;

public class TestAgregarCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String apellido = "wassa";
		String nombre = "sigmah";
		int dni = 56898532;
		LocalDate fechaDeNacimiento = LocalDate.now();
		ClienteABM abm = new ClienteABM();
		try {
			abm.agregar(apellido, nombre, dni, fechaDeNacimiento);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
