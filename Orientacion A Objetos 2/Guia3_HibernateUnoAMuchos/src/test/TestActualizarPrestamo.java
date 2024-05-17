package test;

import java.time.LocalDate;

import datos.Prestamo;
import negocio.PrestamoABM;

public class TestActualizarPrestamo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrestamoABM abm = new PrestamoABM();
		Prestamo p = new Prestamo();
		long idPrestamo = 1;
		try {
			p = abm.traerPrestamo(idPrestamo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		LocalDate fecha = LocalDate.now();
		p.setCantCuotas(11);
		p.setFecha(fecha);
		p.setInteres(35);
		p.setMonto(2000);
		try {
			abm.modificar(p);
			Prestamo pModif = abm.traerPrestamo(idPrestamo);
			System.out.println("Prestamo sin modificar -->" + p);
			System.out.println("Prestamo modificado -->" + pModif);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}