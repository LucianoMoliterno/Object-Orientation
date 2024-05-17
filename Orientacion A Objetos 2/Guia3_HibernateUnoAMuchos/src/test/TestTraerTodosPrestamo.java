package test;

import negocio.ClienteABM;
import negocio.PrestamoABM;

public class TestTraerTodosPrestamo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrestamoABM abm = new PrestamoABM();
		ClienteABM abm2 = new ClienteABM();
		System.out.println(abm.traerPrestamo(abm2.traer(1L)));
	}

}