package modelo;

import java.time.LocalDate;

public class Funciones {

	public static boolean esDiaHabil(LocalDate fecha) {
		int d = fecha.getDayOfWeek().getValue();
		/*
		 * Help: LocalDate fecha=LocalDate.of (2019,9,30); int
		 * nroDiaSem=fecha.getDayOfWeek().getValue(); //nroDiaSem=1,from 1 (Monday) to 7
		 * (Sunday)
		 */
		return ((d >= 1) && (d <= 5));
	}

	public static double convertirADouble(int n) {
		return ((double) n);
	}

}
