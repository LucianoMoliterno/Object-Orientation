package test;

import negocio.PrestamoABM;

public class TestEliminarPrestamo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrestamoABM pABM = new PrestamoABM();
		long idPrestamo = 3;
		try {
			pABM.eliminar(idPrestamo);
			System.out.println("Prestamo eliminado -->" + pABM);
		} catch (Exception e) {
			System.err.println(e);

		}
	}
}