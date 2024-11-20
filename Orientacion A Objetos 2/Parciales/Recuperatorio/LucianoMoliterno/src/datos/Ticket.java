package datos;

import java.time.LocalDate;
import java.time.LocalTime;

public class Ticket {
	private int idTicket;
	private LocalDate fecha;
	private LocalTime horaIngreso;
	private LocalTime horaEgreso;
	private float monto;
	private Vehiculo vehiculo;

	public Ticket() {
		super();
	}

	public Ticket(LocalDate fecha, LocalTime horaIngreso, LocalTime horaEgreso, float monto, Vehiculo vehiculo) {
		super();
		this.fecha = fecha;
		this.horaIngreso = horaIngreso;
		this.horaEgreso = horaEgreso;
		this.monto = monto;
		this.vehiculo = vehiculo;
	}

	public int getIdTicket() {
		return idTicket;
	}

	protected void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHoraIngreso() {
		return horaIngreso;
	}

	public void setHoraIngreso(LocalTime horaIngreso) {
		this.horaIngreso = horaIngreso;
	}

	public LocalTime getHoraEgreso() {
		return horaEgreso;
	}

	public void setHoraEgreso(LocalTime horaEgreso) {
		this.horaEgreso = horaEgreso;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public int calcularTiempoMinutos(LocalTime horaSalida) {
		// Calculo la diferencia en minutos entre la hora de ingreso y la hora de salida
		int horaIngresoMinutos = horaIngreso.getHour() * 60 + horaIngreso.getMinute();
		int horaSalidaMinutos = horaSalida.getHour() * 60 + horaSalida.getMinute();
		return horaSalidaMinutos - horaIngresoMinutos;
	}

	public Ticket cerrarTicket(LocalTime horaSalida, float precioBase) {
		// Actualizo la hora de salida del ticket
		this.horaEgreso = horaSalida;
		// Calculo el tiempo transcurrido en minutos entre la hora de ingreso y la hora
		// de salida
		int tiempoMinutos = calcularTiempoMinutos(horaSalida);
		// Calculo el monto a cobrar según las reglas de negocio
		float monto;
		float precioMinimo = precioBase;
		int tiempoTicket;
		if (vehiculo instanceof Automovil) {
			Automovil automovil = (Automovil) vehiculo;
			if (automovil.isEsPickUp()) {
				precioMinimo *= 1.5f; // Aumenta el precio base en un 50%
			}
		} else if (vehiculo instanceof Moto) {
			precioMinimo *= 0.25f; // Reduce el precio base en un 75%
			tiempoTicket = tiempoMinutos / 15; // Redondea el tiempo a intervalos de 15 minutos
		}
		tiempoTicket = tiempoMinutos / 60; // Redondea el tiempo a horas
		// Calculo el monto total
		monto = Math.max(tiempoTicket, 1) * precioMinimo; // El tiempo mínimo a cobrar es 1 hora
		// Actualizo el monto del ticket
		this.monto = monto;
		return this;
	}

//Imprime Unicamente Datos Internos
	@Override
	public String toString() {
		return "Ticket [idTicket=" + idTicket + ", fecha=" + fecha + ", horaIngreso=" + horaIngreso + ", horaEgreso="
				+ horaEgreso + ", monto=" + monto + "]";
	}

//Imprime Datos Internos (Reutiliza el de arriba) + Datos Entidades Relacionadas
	public String toStringConProducto() {
		return toString() + "" + vehiculo;
	}
}
