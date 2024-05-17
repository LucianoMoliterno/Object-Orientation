package test;

import java.time.LocalDate;

import negocio.ClienteABM;
import negocio.PrestamoABM;

public class TestAgregarPrestamo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteABM cABM = new ClienteABM();

		PrestamoABM pABM = new PrestamoABM();

		long ultimoPrestamo = pABM.agregar(LocalDate.now(), 200, 25, 12, cABM.traer(1L));

		System.out.println("Cliente donde se agrego el prestamo: \n" + cABM.traer(1L).getApellido());
		System.out.println("Ultimo prestamo agregado: " + ultimoPrestamo);
	}

}
