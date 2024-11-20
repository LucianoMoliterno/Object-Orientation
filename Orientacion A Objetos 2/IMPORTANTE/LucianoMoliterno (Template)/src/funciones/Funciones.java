package funciones;

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
//------------------------------------------------------------------------------------

/*MANY TO ONE
<class name="datos.Lote" table="lote">
		<id column="id_lote" name="idLote">
			<generator class="identity" />
		</id>
		<property name="codigo" column="codigo" type="string" />
		<many-to-one name="producto" class="datos.Producto" column="id_producto" not-null="true" />
	</class>

UNA ENTIDAD
<class name="datos.Producto" table="producto">
		<id name="idProducto" column="id_producto">
			<generator class="identity" />
		</id>
		<property name="codigo" column="codigo" type="string" />
		<property name="nombre" column="nombre" type="string" />
		<property name="precio" column="precio" type="double" />
	</class>
	
ONE TO MANY
<class name="datos.Venta" table="Venta">
		<id column="idVenta" name="idVenta">
			<generator class="identity" />
		</id>
		<property column="fecha" name="fecha" type="LocalDate" />
		<property column="cliente" name="cliente" type="string" />
		<property column="descuento" name="descuento" type="float" />
		<set name="itemsVenta" table="ItemVenta" order-by="idItemVenta asc"
			inverse="true" lazy="true" fetch="select" cascade="save-update">
			<key column="idVenta" not-null="true" />
			<one-to-many class="datos.ItemVenta" />
		</set>
	</class>

MANY TO MANY
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-mapping PUBLIC "-//Hibernate/Hibernate Mapping DTD 3.0//EN" "http://www.hibernate.org/hibernate-mapping-3.0.dtd">
<hibernate-mapping>
	<class name="datos.Cliente" table="cliente">
		<id column="idCliente" name="idCliente">
			<generator class="identity" />
		</id>
		<property column="apellido" name="apellido" type="string" />
		<property column="nombre" name="nombre" type="string" />
		<property column="dni" name="dni" type="int" />
		<property column="fechaDeNacimiento" name="fechaDeNacimiento"
			type="LocalDate" />
		<property column="baja" name="baja" type="boolean" />
		<set table="eventoxcliente" name="eventos" outer-join="true">
			<key column="idCliente" />
			<many-to-many column="idEvento" class="datos.Evento" />
		</set>
	</class>
</hibernate-mapping>

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-mapping PUBLIC "-//Hibernate/Hibernate Mapping DTD 3.0//EN" "http://www.hibernate.org/hibernate-mapping-3.0.dtd">
<hibernate-mapping>
	<class name="datos.Evento" table="evento">
		<id column="idEvento" name="idEvento">
			<generator class="identity" />
		</id>
		<property column="evento" name="evento" type="string" />
		<property column="fecha" name="fecha" type="LocalDate" />
		<property column="hora" name="hora" type="LocalTime" />

		<set table="eventoxcliente" name="clientes" outer-join="true">
			<key column="idEvento" />
			<many-to-many column="idCliente" class="datos.Cliente" />
		</set>

	</class>

</hibernate-mapping> 
-------------------------------------------------------------------------------------------------

// calcula el total por itemVenta siendo el producto entre cantidad y precio del audio (fue en itemventa)
	public float calcularTotalItem() {
		return audio.getPrecio() * cantidad;
	}
	
	TODO ESTO EN VENTA
// calcula la sumatoria del total por cada itemVenta
	public float calcularTotal() {
		float total = 0;
		for (ItemVenta itemVenta : itemsVenta) {
			total = total + itemVenta.calcularTotalItem();
		}
		return total;
	}

	// diferencia entre el subtotal y el descuento
	public float calcularTotalAPagar() {
		return calcularTotal() - descuento;
	}

	// calcula el 50% de descuento en la 2da unidad
	// aplica descuento hasta 6 unidades de compra (si son mayores a 6, el descuento
	// solo se calcula sobre las primeras 6 unidades)
	// setea el atributo descuento
	public void calcularDescuento502daax6() {
		float descuentoACalcular = 0;
		for (ItemVenta itemVenta : itemsVenta) {
			int validador = itemVenta.getCantidad() / 2;
			if (validador > 3) {
				descuentoACalcular = (float) (descuentoACalcular + (itemVenta.calcularTotalItem() * 0.5));
			}
		}
		this.setDescuento(descuentoACalcular);
	}

TO STRING CAMBIA: (OJO QUE ALGUNAS VECES SE DEE QUITAR EN UN TO STRING ALGUN DATO QUE GENERA BUCLE INFINITO)
// Imprime Unicamente Datos Internos
	@Override
	public String toString() {
		return "Venta [idVenta=" + idVenta + ", fecha=" + fecha + ", cliente=" + cliente + ", descuento=" + descuento
				+ ", itemsVenta=" + itemsVenta + "]" + "total: $" + calcularTotal() + "Descuento: $" + descuento
				+ "total a pagar: $" + calcularTotalAPagar();
	}
	
	*/
