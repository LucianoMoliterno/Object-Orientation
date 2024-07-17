package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Funciones {
	public static boolean esBisiesto(int anio) {
		return (anio % 4 == 0 && !(anio % 100 == 0 && anio % 400 != 0));
	}

	public static int traerAnio(LocalDate fecha) {
		return fecha.getYear();
	}

	public static int traerMes(LocalDate fecha) {
		return fecha.getMonthValue();
	}

	public static int traerDia(LocalDate fecha) {
		return fecha.getDayOfMonth();
	}

	public static boolean esFechaValida(LocalDate fecha) {

		boolean valida = false;
		boolean bisiesto = esBisiesto(fecha.getDayOfYear());
		boolean treintaYUno = ((fecha.getMonthValue() % 2 != 0 && fecha.getMonthValue() <= 7)
				|| (fecha.getMonthValue() >= 8 && fecha.getMonthValue() % 2 == 0)) && fecha.getMonthValue() != 2;
		boolean treinta = ((fecha.getMonthValue() % 2 == 0 && fecha.getMonthValue() <= 6)
				|| (fecha.getMonthValue() % 2 != 0 && fecha.getMonthValue() >= 9)) && fecha.getMonthValue() != 2;
		if (treintaYUno && fecha.getDayOfMonth() >= 1 && fecha.getDayOfMonth() <= 31) {
			valida = true;
		} else if (treinta && fecha.getDayOfMonth() >= 1 && fecha.getDayOfMonth() <= 30) {
			valida = true;
		} else if (bisiesto && fecha.getDayOfMonth() >= 1 && fecha.getDayOfMonth() <= 29) {
			valida = true;
		} else if (fecha.getDayOfMonth() >= 1 && fecha.getDayOfMonth() <= 28) {
			valida = true;
		}
		return valida;

	}

	public static String traerFechaCorta(LocalDate f) {
		String fecha = "";
		if (f != null)
			fecha = traerDia(f) + "/" + traerMes(f) + "/" + traerAnio(f);
		return fecha;
	}

	public static int traerHora(LocalTime hora) {

		return hora.getHour();

	}

	public static int traerMinutos(LocalTime hora) {

		return hora.getMinute();

	}

	public static int traerSegundos(LocalTime hora) {

		return hora.getSecond();

	}

	public static String traerHoraCorta(LocalTime h) {
		String hora = "";
		if (h != null)
			hora = traerHora(h) + "/" + traerMinutos(h) + "/" + traerSegundos(h);
		return hora;
	}

	public static boolean esDiaHabil(LocalDate fecha) {
		boolean diaHabil = true;
		int dia = fecha.getDayOfMonth();// ver como traer un entero del dia de la semana que es
		if (dia == 1 || dia == 7) {
			diaHabil = false;
		}
		return diaHabil;
	}

	public static String traerDiaDeLaSemana(LocalDate fecha) {

		String dia = null;
		int diaSem = fecha.getDayOfWeek().getValue();
		switch (diaSem) {
		case 1:
			dia = "lunes";
			break;
		case 2:
			dia = "martes";
			break;
		case 3:
			dia = "miercoles";
			break;
		case 4:
			dia = "jueves";
			break;
		case 5:
			dia = "viernes";
			break;
		case 6:
			dia = "sabado";
			break;
		case 7:
			dia = "domingo";
			break;
		}

		return dia;
	}

	public static String traerMesEnLetras(LocalDate fecha) {

		int mes = fecha.getMonthValue();
		String month = "";
		switch (mes) {

		case 1:
			month = "Enero";
			break;
		case 2:
			month = "Febrero";
			break;
		case 3:
			month = "Marzo";
			break;
		case 4:
			month = "Abril";
			break;
		case 5:
			month = "Mayo";
			break;
		case 6:
			month = "Junio";
			break;
		case 7:
			month = "Julio";
			break;
		case 8:
			month = "Agosto";
			break;
		case 9:
			month = "Septiembre";
			break;
		case 10:
			month = "Octubre";
			break;
		case 11:
			month = "Noviembre";
			break;
		case 12:
			month = "Diciembre";
			break;
		}
		return month;

	}

	public static String traerFechaLarga(LocalDate fecha) {

		return traerDiaDeLaSemana(fecha) + " " + fecha.getDayOfMonth() + " de " + traerMesEnLetras(fecha) + " del "
				+ fecha.getYear();
	}

	public static int traerCantDiasDeUnMes(int anio, int mes) {

		int cantDiaMes;

		if (esBisiesto(anio) && mes == 2) {
			cantDiaMes = 29;
		} else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {

			cantDiaMes = 30;
		} else if (mes == 2) {

			cantDiaMes = 28;

		} else {
			cantDiaMes = 31;
		}
		return cantDiaMes;

	}

	public static double aproximar2Decimal(double valor) {
		double decimal = (valor * 100) - (Math.floor(valor * 100));
		if (decimal >= 0.5) {
			valor = (valor + 0.01) - (decimal / 100);
		} else {
			valor = valor - (decimal / 100);
		}
		return valor;
	}

	public static boolean esNumero(char c) {
		return Character.isDigit(c);
	}

	public static boolean esLetra(char c) {
		return Character.isLetter(c);
	}

	public static boolean esCadenaNros(String cadena) {
		boolean cadenaNros = true;
		int caracter = 0;
		while (cadenaNros && caracter < cadena.length()) {
			if (!esNumero(cadena.charAt(caracter))) {
				cadenaNros = false;
			}
			caracter++;
		}
		return cadenaNros;
	}

	public static boolean esCadenaLetras(String cadena) {
		boolean cadenaLtrs = true;
		int caracter = 0;
		while (cadenaLtrs && caracter < cadena.length()) {

			if (!Character.isLetter(cadena.charAt(caracter))) {
				cadenaLtrs = false;
			}
			caracter++;
		}
		return cadenaLtrs;
	}

	public static double convertirADouble(int n) {
		return ((double) n);

	}

}
