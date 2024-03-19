package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
//import java.util.ArrayList;
//import java.util.List;

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
	
	public boolean validarDni(Long dni) {
		boolean valido = false;
		String dniConvertido = String.valueOf(dni);
		if (dniConvertido.length() == 8) {
			valido = true;
		} else {
			valido = false;
		}
		return valido;
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
		return ((double)n);
	}
	
//---------------------------------------------------------------------------------------------------------------

//LA LISTA DE PARTICIPANTES  SE DEBE INICIALIZAR COMO UN ARRAYLIST DE PERSONAS VACIO (la lista de la clase tipica)

//-----EQUALS  CON ENTERO Y STRING-----
/*public boolean equals(Cliente c) { CON VALORES ENTEROS
	return this.getDni() == c.getDni();
}

/*public boolean equals(Empresa e) { CON STRINGS
		return this.getNombre().equalsIgnoreCase(e.getNombre());
	}

//-----VALIDACION PASO A PASO-----
//PASO 1: HACER LA VALIDACION DIRECTAMENTE EN EL SET O POR UN METODO EN UNA CLASE CONCRETA
//PASO 2: COLOCAR EL throws Exception (EN EL SET + Throw new Exception("Cantidad de Comensales supera la Capacidad"))
//PASO 3: EN EL CONSTRUCTOR throws Exception + this.setCantComensales(cantComensales); (EJEMPLO)

//-----TIPS CUANDO TENGO CLASE CON LISTA/S-----
//ATRIBUTO: private List<Cliente> lstClientes = new ArrayList<Cliente>();
//OTROS: CONSTRUCTOR VACIO, SI GETTERS Y SETTERS Y NO TO STRING

//-----TIPS PARA HERENCIA-----
//CLASE PADRE: VA protected LOS ATRIBUTOS
//CLASE HIJA/S: COMO CUALQUIER CLASE, SOLO QUE AL PRINCIPIO DEBE IR Extends (CLASE PADRE)
//METODO ABSTRACTO: 
	//EN PADRE: public abstract boolean contieneTexto(String buscar);
	//EN HIJA/S: public boolean contieneTexto(String buscar){} (@Override arriba)

//---------------------------------------------------------------------------------------------------------------

//-----TODOS LOS TRAER POSIBLES (INCLUYE CON LISTA E INSTANCE OF)-----

//TRAER CON ENTERO
	/*public Cliente traerCliente(long dni) {
		Cliente objeto = null;
		int i = 0;
		while (i < lstClientes.size() && objeto == null) {
		if (lstClientes.get(i).getDni() == dni) { 
		objeto = lstClientes.get(i);
			}
		i++;
		}
		return objeto;
		}
//TRAER CON STRING
	/*public Empresa traerEmpresa(String nombre) { 
		Empresa objeto = null;
		int i = 0;
		while (i < LstEmpresas.size() && objeto == null) {
			if (LstEmpresas.get(i).getNombre().equalsIgnoreCase(nombre)) { 
				objeto = LstEmpresas.get(i);
			}
			i++;
		}
		return objeto;
	}
//TRAER CON LISTA ENTRE 2 FECHAS (INCLUYE EXTREMOS)
	/*public List<Reserva> traerReservasPorFecha(LocalDate fechaDesde, LocalDate fechaHasta) {
		List<Reserva> lista = new ArrayList<Reserva>();
		for (int i = 0; i < lstReservas.size(); i++) {
			LocalDate fechaReserva = lstReservas.get(i).getFechaReserva();
			if ((fechaReserva.isAfter(fechaDesde)) || fechaReserva.isEqual(fechaDesde)
					&& (fechaReserva.isBefore(fechaHasta) || fechaReserva.isEqual(fechaHasta))) {
				lista.add(lstReservas.get(i));
			}
		}
		return lista;
	}
//TRAER CON LISTA ENTRE 2 FECHAS Y 1 HORA
/*public List<Publicacion> TraerPublicacionesPublicas(LocalTime hora, LocalDate fechadesde, LocalDate fechahasta) { //si incluye extremos, va el equals, caso contrario solo el isafter e isbefore (con el &&)
		  List<Publicacion> lista = new ArrayList<Publicacion>();
		  for (Publicacion publicacion: lstPublicaciones) {
				if ((publicacion.getFecha().isAfter(fechadesde) && publicacion.getHora().isAfter(hora)  || publicacion.getFecha().equals(fechadesde) && publicacion.getHora().equals(hora))
						&& (publicacion.getFecha().isBefore(fechahasta) && publicacion.getHora().isBefore(hora) || publicacion.getFecha().equals(fechahasta) && publicacion.getHora().equals(hora))) {
					lista.add(publicacion);
				}
		  }
		  return lista;
     }
// trae todas las metricas de un dispositivo en un rango de fechas (contempla los extremos) y que tengan un valor menor al que pasa por parametro
/*public List<Metrica> traerMetricas(Dispositivo dispositivo, LocalDate desde, LocalDate hasta, int menorAValor) {
		List<Metrica> lista = this.traerMetricas(desde, hasta);
		List<Metrica> nuevaLista = new ArrayList<Metrica>();
		for (Metrica metrica : lista) {
			if (metrica.getValor() < menorAValor && dispositivo.getCodigo().equalsIgnoreCase(dispositivo.getCodigo())) {
				nuevaLista.add(metrica);
			}
		}
		return nuevaLista;
	}
// devuelve una lista de Proyectos que hayan iniciado entre las fechas pasadas como parametro (incluye intervalos cerrados)
//y que tengan una cantidad minima de participantes mayor o igual al parametro cantMinParticipantes
	public List<Proyecto> traerProyectosPorFechaYParticipantes(LocalDate fechaInicioDesde, LocalDate fechaInicioHasta,
			int cantMinParticipantes) {
		List<Proyecto> lista = new ArrayList<Proyecto>();
		for (int i = 0; i < lstProyectos.size(); i++) {
			if ((lstProyectos.get(i).getFechaInicio().isAfter(fechaInicioDesde)
					|| lstProyectos.get(i).getFechaInicio().isEqual(fechaInicioDesde))
					&& lstProyectos.get(i).getFechaInicio().isBefore(fechaInicioHasta)
					|| lstProyectos.get(i).getFechaInicio().isEqual(fechaInicioHasta)
							&& lstProyectos.size() >= cantMinParticipantes) {
				lista.add(lstProyectos.get(i));
			}
		}
		return lista;
	}
//TRAER CON LISTA Q NO TENGAN UNA RESERVA PARA EL DIA INDICADO
	/*public List<Mesa> traerMesasLibresPorFecha(LocalDate fecha){
		List<Mesa> lista = new ArrayList<Mesa>();
		for (int i = 0; i < lstMesas.size(); i++) {
			if(this.traerReserva(lstMesas.get(i).getNumeroMesa(), fecha) == null) {
				lista.add(lstMesas.get(i));
			}
		}
		return lista;
	}
//TRAER PERO LA CLASE USA OTRA CLASE
	/*public Reserva traerReserva(int numeroMesa, LocalDate fechaReserva) {
		Reserva objeto = null;
		int i = 0;
		while (i < lstReservas.size() && objeto == null) {
		if (lstReservas.get(i).getMesa().getNumeroMesa() == numeroMesa && lstReservas.get(i).getFechaReserva().isEqual(fechaReserva)) { 
		objeto = lstReservas.get(i);
			}
		i++;
		}
		return objeto;
	}
//TRAER PERO CON LOCALS 
/*public Publicacion traerPublicacion(LocalDate fecha, LocalTime hora, String nombreUsuario) {
		Publicacion objeto = null;
		int i = 0;
		while (i < lstPublicaciones.size() && objeto == null) {
			if (lstPublicaciones.get(i).getCreador().getNombreUsuario().equalsIgnoreCase(nombreUsuario))
					&& lstPublicaciones.get(i).getFecha().isEqual(fecha)
					&& lstPublicaciones.get(i).getHora().equals(hora)) {
				objeto = lstPublicaciones.get(i);
			}
			i++;
		}
		return objeto;
	}
//TRAER DE LISTA CON 2 FECHAS + INSTANCEOF
/*public List<CuentaBancaria> traerCuentasSinCostoMantenimientoEntreFechas(LocalDate fechaDesde, LocalDate fechaHasta) {
		List<CuentaBancaria> lista = new ArrayList<CuentaBancaria>();
		for (CuentaBancaria cuentaBancaria : lstCuentasBancarias) {
			if (cuentaBancaria instanceof CuentaAhorro) {
				if(( (cuentaBancaria.getFechaAlta().isAfter(fechaDesde)
						|| cuentaBancaria.getFechaAlta().equals(fechaDesde))
						&& (cuentaBancaria.getFechaAlta().isBefore(fechaHasta) || cuentaBancaria.getFechaAlta().equals(fechaHasta)))) {
					lista.add(cuentaBancaria);
				}
			}
			
			if (cuentaBancaria instanceof CuentaCorriente) {
				CuentaCorriente cuentaCorriente = (CuentaCorriente) cuentaBancaria;
				if (((cuentaCorriente.isCobrarSueldo()) && (cuentaBancaria.getFechaAlta().isAfter(fechaDesde)
						|| cuentaBancaria.getFechaAlta().equals(fechaDesde))
						&& (cuentaBancaria.getFechaAlta().isBefore(fechaHasta) || cuentaBancaria.getFechaAlta().equals(fechaHasta)))) {
					lista.add(cuentaBancaria);
				}
			}
		}
		return lista;
	}
//TRAER LISTA DE TODA LA VIDA
/*public List<Comentario> TraerComentariosEnPosteosPorUsuario(Usuario usuario) {
		List<Comentario> lista = new ArrayList<Comentario>();
		for (int i = 0; i < lstComentarios.size(); i++) {
			if (lstComentarios.get(i).getUsuario().equals(usuario)) {
				lista.add(lstComentarios.get(i));
			}
		}
		return lista;
	}
//TRAER LISTA CON UN METODO ABSTRACTO
/*public List<Publicacion> traerPublicacionesQueContenganTexto(String texto) {
		List<Publicacion> lista = new ArrayList<Publicacion>();
		for (Publicacion publicacion : lstPublicaciones) {
			if (publicacion.contieneTexto(texto)) {
				lista.add(publicacion);
			}
		}
		return lista;

	}
//TRAER LISTA CON UN METODO ABSTRACTO MAS INSTANCE OF
/*public List<Campamento> traerCampamentosPorDias(int mayorIgualA) {
		List<Campamento> campamentosCoincidentes = new ArrayList<Campamento>();
		for (int i = 0; i < lstServicios.size(); i++) {
			if (lstServicios.get(i) instanceof Campamento) {
				Campamento auxiliar = (Campamento) lstServicios.get(i);
				if (auxiliar.cantidadDias() >= mayorIgualA) {
					campamentosCoincidentes.add(auxiliar);
				}
			}
		}
		return campamentosCoincidentes;
	}
//TRAER LISTA SOLO CON INSTANCEOF
/*public List<Cliente> traerClientes(boolean estadoCliente) {
		  List<Cliente> lista = new ArrayList<Cliente>();
		  for (int i = 0; i < lstPersonas.size(); i++) {
		   if (lstPersonas.get(i) instanceof Cliente) {
		    if (((Cliente) lstPersonas.get(i)).isActivo() == estadoCliente) {
		     lista.add((Cliente) lstPersonas.get(i));
		    }
		   }
		  }
		  return lista;
		  }
// devuelve una lista de Cursos que esta cursando el alumno, los cursos no deben estar finalizados
	public List<Curso> cursosPorAlumno(Alumno alumno) {
		List<Curso> lstAuxCur = new ArrayList<Curso>();
		for (int i = 0; i < lstCursos.size(); i++) {
			for (int j = 0; j < lstCursos.get(i).getLstAlumnos().size(); j++) {
				if (lstCursos.get(i).getLstAlumnos().get(j).equals(alumno)
						&& lstCursos.get(i).isFinalizado() == false) {
					lstAuxCur.add(lstCursos.get(i));
				}
			}
		}
		return lstAuxCur;
	}
//TRAER QUE CUMPLA CONDICION (SE DEBE CREAR OBJETO AUXILIAR)
/*public Tarifa traerTarifa(int consumo) {
		Tarifa objeto = null;
		int i = 0;
		while (i < lstTarifas.size() && objeto == null) {
			Tarifa auxiliar = lstTarifas.get(i);
			if (auxiliar.getConsumoDesde() <= consumo && consumo <= auxiliar.getConsumoHasta()) {
				objeto = auxiliar;
			}

			i++;
		}
		return objeto;
	}
//TRAER CON VARIOS PARAMETROS
/*public Lectura traerLectura(int mes, int anio, Cliente cliente) {
		Lectura objeto = null;
		int i = 0;
		while (i < lstLecturas.size() && objeto == null) {
			if (lstLecturas.get(i).getFecha().getMonthValue() == mes && lstLecturas.get(i).getFecha().getYear() == anio
					&& lstLecturas.get(i).getCliente().equals(cliente)) {
				objeto = lstLecturas.get(i);
			}
			i++;
		}
		return objeto;
	}
//TRAER TODAS LAS COMPRAS ENTRE FECHAS (REUTILIZO TRAER DE 2 FECHAS CON EXTREMOS) Q TENGAN UN ARTICULO CON CLASE DESCUENTO IGUAL A DESCUENTO POR CANTIDAD
/*public List<Compra> traerComprasDescuentoPorCantidad(LocalDateTime desde, LocalDateTime hasta) {
		List<Compra> lista = this.traerCompras(desde, hasta);
		List<Compra> nuevaLista = new ArrayList<Compra>();
		for (Compra compra : lista) {
			if (compra.getArticulo().getDescuento() instanceof DescuentoPorCantidad) {
				nuevaLista.add(compra);
			}
		}
		return nuevaLista;
	}
//TRAER SIN INSTANCEOF PORQUE SALIA SOLO CON ATRIBUTOS DE CLASE
/*public List<Articulo> traerArticulosConDescuento(boolean activo) {
		List<Articulo> lista = new ArrayList<Articulo>();
		for (Articulo articulo : lstArticulos) {
			if (articulo.getDescuento().isActivo() == activo) {
				lista.add(articulo);
			}
		}
		return lista;
	}
//TRAER QUE RETORNA UNA LISTA DE TODOS LOS TITULARES QUE TENGAN UNA CUENTACORRIENTE PREMIUM
/*public List<Titular> traerTitularesConCuentaPremium() {
		List<Titular> lista = new ArrayList<Titular>();
		for (CuentaBancaria cuentaBancaria : lstCuentasBancarias) {
			if (cuentaBancaria instanceof CuentaCorriente) {
				CuentaCorriente cuentaCorriente = (CuentaCorriente) cuentaBancaria;
				if(cuentaCorriente.isEsPremium() && (cuentaBancaria.getSaldo() > 1000000 & cuentaBancaria.getSaldo() < 2000000)) {
					lista.add(cuentaBancaria.getTitular());
				}
			}
		}
		return lista;
	}
//---------------------------------------------------------------------------------------------------------------

//-----TODOS LOS AGREGAR POSIBLES-----

// agrega una Persona, ya sea un Alumno o Docente
	public boolean incorporarParticipante(Persona participante) {
		return lstParticipantes.add(participante);
	}
// agrega un alumno a un curso
	public boolean matricularAlumno(Alumno alumno) {
		return lstAlumnos.add(alumno);
	}
//AGREGAR CON EXCEPCION (USA VALIDACION)
	/*public boolean agregarDispositivo(String nombre, String codigo, Empresa empresa) throws Exception {
		Dispositivo objeto = null;
		if (LstDispositivos.isEmpty()) {
			objeto = new Dispositivo(1, nombre, codigo, empresa);
		} else {
			objeto = new Dispositivo(LstDispositivos.get(LstDispositivos.size() - 1).getId() + 1, nombre, codigo,
					empresa);

		}
		return LstDispositivos.add(objeto);
	}
//AGREGAR CON EXCEPCION (SI X DATO YA EXISTE)
	/*public boolean agregarCliente(String nombre, String apellido, long dni, String telefono) throws Exception {
		Cliente objeto = null;
		if(this.traerCliente(dni) != null){ 
		throw new Exception("Este DNI ya existe"); }
		if (lstClientes.isEmpty()) {
			objeto = new Cliente(1, nombre, apellido, dni, telefono);
		} else {
			objeto = new Cliente(lstClientes.get(lstClientes.size() - 1).getIdCliente() + 1, nombre, apellido, dni, telefono);

		}
		return lstClientes.add(objeto);
	}
//AGREGAR CON EXCEPCION LLAMANDO A OTRO LADO
	/*public boolean agregarReserva(Cliente cliente, LocalDate fechaReserva, Mesa mesa, int cantComensales) throws Exception {
		Reserva objeto = null;
		if(this.traerReserva(mesa.getNumeroMesa(), fechaReserva) != null){ 
		throw new Exception("Esta Mesa ya esta Reservada para la Fecha Indicada"); 
		}
		if (lstReservas.isEmpty()) {
			objeto = new Reserva(1, cliente, fechaReserva, mesa, cantComensales);
		} else {
			objeto = new Reserva(lstReservas.get(lstReservas.size() - 1).getIdReserva() + 1, cliente , fechaReserva, mesa, cantComensales);

		}
		return lstReservas.add(objeto);
	}
//AGREGAR DE UNA CLASE HIJA RELACIONADA CON CLASE PADRE (CON ID)
public boolean agregarPosteo(LocalDate fecha, LocalTime hora, Usuario creador, String texto, boolean publico)
			throws Exception {
		Posteo objeto = null;
		if (this.traerPublicacion(fecha, hora, creador.getNombreUsuario()) != null) {
			throw new Exception("Ya existe una Pùblicacion con esa fecha, hora y creador");
		}
		if (lstPublicaciones.isEmpty()) {
			objeto = new Posteo(1, fecha, hora, creador, texto, publico);
		} else {
			objeto = new Posteo(lstPublicaciones.get(lstPublicaciones.size() - 1).getIdPublicacion() + 1, fecha, hora,
					creador, texto, publico);

		}
		return lstPublicaciones.add(objeto);
	}
//AGREGAR DE UNA CLASE HIJA RELACIONADA CON CLASE PADRE (SIN ID)
public boolean agregarServicio(String codMercancia, String servicio, double presupuesto, double porcentajeDescuento,
			boolean enPromocion) throws Exception {
		if (this.traerMercancia(codMercancia) != null) {
			throw new Exception("Este Servicio ya existe");
		}
		return lstMercancias.add(new Servicio(codMercancia, servicio, presupuesto, porcentajeDescuento, enPromocion));
	}
//---------------------------------------------------------------------------------------------------------------

//-----TODAS LAS VALIDACIONES POSIBLES VISTAS-----

//CONVERTIR A STRING
/*public String convertirAString () {
	return String.valueOf(this.getN());
}
// CONVERTIR A DOUBLE
public Double ConvertirDouble() {
	String cadena = this.convertirAString();
	double cadenaConvertida = Double.parseDouble(cadena);
	return cadenaConvertida;
	
}
//CALCULAR EL DIGITO DE VERIFICADOR
public boolean esValidoDigitoControl(String codIngreso) {
		int suma = 0;
		boolean valido = false;
		char[] auxiliar = codIngreso.toCharArray();
		for (int i = 0; i < codIngreso.length() - 1; i++) {
			suma += Character.getNumericValue(auxiliar[i]);
		}
		int dVerificador = suma % 10;
		if (dVerificador == Character.getNumericValue(auxiliar[6])) {
			valido = true;
		}
		return valido;
	}
//SABER LA LONGITUD EN DIGITOS DE UN INT
public boolean validarNumero(int numero){
		String numeroConvertido = String.valueOf(numero);
		return numeroConvertido.length() == 10;
	}
//SI APLICARDESCUENTO ESTE ACTIVO (TRUE) SE APLICA DESCUENTO PARTICULAR, CASO CONTRARIO DESCUENTO SERA 0
/*public double aplicarDescuento(int cantidad, double precio) {
		double precioFinal = cantidad * precio;
		double descuento = 0;

		if (this.isActivo()) {
			descuento = this.calcularDescuentoParticular(cantidad, precio);
		}

		return precioFinal - descuento;
	}
//DEVUELVE EL PRECIO TOTAL DE LA COMPRA INCLUYENDO EL CALCULO DEL DESCUENTO
/*public double precioTotal() {
		double precioTotal = articulo.getDescuento().aplicarDescuento(cantidad, articulo.getPrecio());
		return precioTotal;
	}
//RETORNA EL CONSUMO, DIFERENCIA ENTRE ESTADOMEDIDOR DE LAS DOS LECTURAS (CLASE LECTURA)
/*public int calcularConsumo(Lectura lecturaAnterior) {
		return this.getEstadoMedidor() - lecturaAnterior.getEstadoMedidor();
	}
//METODO QUE REQUIERE MUCHOS PASOS
//1° Recupera el objeto Lectura según parámetros (int mes, int anio, Cliente cliente)
//2° Recupera el objeto Lectura del mes anterior (1°). //utilizar minusMonths(1)
//3° Calcular el consumo del cliente entre las lecturas
//4° Determinar la tarifa según el consumo.
//5° totalVariable = cargoVariable * consumo
//6° Si el cliente es ClienteResidencial en el caso de tener subsidio aplica descuento=cargoVariable*kWhSubsidio
//Si totalVariable >= descuento entonces totalVariable=totalVariable - descuento en caso contrario totalVariable=0.
//7° Retorna la suma cargoFijo + totalVariable
/*public float calcularTotalACobrar(int mes, int anio, Cliente cliente) {
		Lectura lecturaActual = this.traerLectura(mes, anio, cliente);
		Lectura lecturaAnterior = this.traerLectura(lecturaActual.getFecha().minusMonths(1).getMonthValue(),
				lecturaActual.getFecha().minusYears(1).getYear(), cliente);
		float descuento = 0;
		int consumo = lecturaActual.calcularConsumo(lecturaAnterior);
		Tarifa tarifa = traerTarifa(consumo);
		float total = (tarifa.getCargoVariable() * consumo);
		if (cliente instanceof ClienteResidencial && ((ClienteResidencial) cliente).getKwhSubsidio() > 0) {
			descuento = tarifa.getCargoVariable() * ((ClienteResidencial) cliente).getKwhSubsidio();
			if (total >= descuento) {
				total = total - descuento;
			} else {
				total = 0;
			}
		}
		return (tarifa.getCargoFijo() + total);

	}

//----------------------------------------------------------------------------------------------------

//-----TODOS LOS METODOS ABSTRACTOS POSIBLES VISTOS-----

//Si tiene descuento en la 2° unidad, para calcular el precio final aplica la mitad del porcentajeDescuento ya que tiene que comprar 2 artículos.
@Override
	public double calcularPrecioFinal() {
		double precioFinal = 0;
		if(esDescuentoEn2daUnidad) {
		precioFinal = porcentajeDescuento / 2;
		}
		return precioFinal;
	}
//Si está en promoción, el precio final aplica porcentajeDescuento
@Override
	public double calcularPrecioFinal() {
		double precioFinal = 0;
		if(enPromocion) {
		precioFinal = porcentajeDescuento;
		}
		return precioFinal;
	}
//DEVOLVERA VERDADERO SI EL TEXTO A BUSCAR EXISTE EN EL TITULO O CUERPO DE AVISOGENERAL
@Override
public boolean contieneTexto(String buscar) {
		return cuerpo.indexOf(buscar) != -1 || titulo.indexOf(buscar) != -1;	
	}
//METODO ABSTRACTO HIJO DE VALIDAR TAMAÑO Y COMIENZO DE CARACTERES (SI ES ENTERO U OTRO, CONVETIRLO A STRING PRIMERO)
/*@Override 
	public boolean esNumeroCuentaValido(String nroCuenta) {
		boolean valido = false;
		if(nroCuenta.length() == 10 && nroCuenta.startsWith("CA")) {
			valido = true;
		}
		return valido;
	}
//CADAUNIDADES SE REGALA UNIDADESGRATIS, EL DESCUENTO SERIA 4(UNIDADES A REGALAR) * PRECIO DEL ARTICULO (SACAR DIVISOR: PARTE ENTERO / DIVISOR)
/*@Override
	public double calcularDescuentoParticular(int cantidad, double precio) {
		int parteEntera = cantidad / cadaUnidades;
		double descuento = parteEntera * unidadesGratis * precio;
		return descuento;
	}
//TOTAL A PAGAR MAYOR O IGUAL APLICARDESDEVALOR SE CALCULA EL DESCUENTO DE PORCENTAJEDESCUENTO
/*@Override
	public double calcularDescuentoParticular(int cantidad, double precio) {
		double descuento = 0;

		if (cantidad * precio >= aplicarDesdeValor) {
			descuento = ((cantidad * precio) * porcentajeDescuento) / 100;
		}
		return descuento;
	}

//----------------------------------------------------------------------------------------------------------------

//-----TODAS LAS OPERACIONES BASICAS VISTAS POSIBLES-----

//CALCULAR SUB TOTAL (BASICO)
/*public float subtotal() {
	return ((float) this.producto.getPrecio() * this.cantidad);
}
//CALCULAR TOTAL (BASICO)
/*public float calcularTotal() {
	float total = 0;
	for (int i = 0; i < LstItem.size(); i++) {
		total += (LstItem.get(i).subtotal());
	}
	return total;
}
//SUMAR
	/*public int sumar(int n1) {
		return this.getN()+n1;
	}
	//Multiplicar
	public int multiplicar(int n1) {
		return this.getN()*n1;
	}
	//EsPar
	public boolean esPar() {
		return this.getN()%2==0;
	}
//ES PRIMO
	public boolean esPrimo() {
		int contador = 2;

		boolean primo = true;

		while ((primo) && (contador != this.n)) {
			if (this.n % contador == 0) {
				primo = false;
			}
			contador++;
		}
		return primo;
	}
//CALCULAR POTENCIA
	public Double CalcularPotencia(int exp) {
		return Math.pow (this.getN(), exp);
	}
//CALCULAR FACTORIAL
	public int calcularFactorial() {
			int factorial = 1;
			int i = 1;
			if (this.getN() == 0) {
				factorial = 1;
			} else if (this.getN() < 0) {
				factorial = 1;
			} else {
				for (i = 1; i <= this.getN(); i++) {
					factorial = factorial * i;
				}
			}

			return factorial;
}
*/
}





	