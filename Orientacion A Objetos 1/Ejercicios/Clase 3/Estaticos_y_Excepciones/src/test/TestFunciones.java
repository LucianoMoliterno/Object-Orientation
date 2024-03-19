package test;

import java.time.LocalDate;
import modelo.Funciones;

public class TestFunciones {
	public static void main(String[] args) {
		System.out.println(Funciones.esDiaHabil(LocalDate.of(2019, 9, 18)));
	}
}
