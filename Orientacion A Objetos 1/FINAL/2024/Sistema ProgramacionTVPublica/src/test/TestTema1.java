package test;

import java.time.LocalDate;
import java.time.LocalTime;

import modelo.SistemaTVPublica;

public class TestTema1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SistemaTVPublica SistemaTVPublica = new SistemaTVPublica();

		System.out.println("1");
		try {
			System.out.println(SistemaTVPublica.agregarPelicula("45683", "Permitidos", 90, "COMEDIA"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			System.out.println(
					SistemaTVPublica.agregarPelicula("52894", "Copa America 2024 Argentina vs Canada", 120, "DEPORTE"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			System.out
					.println(SistemaTVPublica.agregarPelicula("51680", "Television Publica Noticias", 60, "NOTICIAS"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			System.out.println(SistemaTVPublica.agregarPelicula("51231", "Documentales en TVP", 60, "DOCUMENTAL"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			System.out.println(
					SistemaTVPublica.agregarPelicula("25489", "Revolucion Cruce De Los Andes", 90, "HISTORICO"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			System.out.println(SistemaTVPublica.agregarPelicula("17323", "Esperando La Carroza", 80, "COMEDIA"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("2");
		System.out.println(SistemaTVPublica.traerContenido("51680"));
		System.out.println("3");
		System.out.println(SistemaTVPublica.agregarCalendario(LocalDate.of(2024, 07, 01), LocalTime.of(16, 0),
				SistemaTVPublica.traerContenido("51231")));
		System.out.println(SistemaTVPublica.agregarCalendario(LocalDate.of(2024, 07, 15), LocalTime.of(18, 0),
				SistemaTVPublica.traerContenido("45683")));
		System.out.println(SistemaTVPublica.agregarCalendario(LocalDate.of(2024, 07, 15), LocalTime.of(18, 0),
				SistemaTVPublica.traerContenido("52894")));
		System.out.println(SistemaTVPublica.agregarCalendario(LocalDate.of(2024, 8, 01), LocalTime.of(18, 0),
				SistemaTVPublica.traerContenido("25489")));
		System.out.println(SistemaTVPublica.agregarCalendario(LocalDate.of(2024, 8, 14), LocalTime.of(18, 0),
				SistemaTVPublica.traerContenido("51680")));
		System.out.println(SistemaTVPublica.agregarCalendario(LocalDate.of(2024, 8, 14), LocalTime.of(20, 0),
				SistemaTVPublica.traerContenido("17323")));
		System.out.println("4");
		System.out.println(SistemaTVPublica.traerPelicula("COMEDIA"));
		System.out.println("5");
		try {
			System.out.println(SistemaTVPublica.agregarPrograma("73241", "9 Reinas", 120, "SUSPENSO"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
