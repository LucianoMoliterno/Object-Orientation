package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Calendario {
	private int idCalendario;
	private LocalDate fecha;
	private LocalTime hora;
	private Contenido contenido;

	public Calendario(int idCalendario, LocalDate fecha, LocalTime hora, Contenido contenido) {
		super();
		this.idCalendario = idCalendario;
		this.fecha = fecha;
		this.hora = hora;
		this.contenido = contenido;
	}

	public int getIdCalendario() {
		return idCalendario;
	}

	public void setIdCalendario(int idCalendario) {
		this.idCalendario = idCalendario;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public Contenido getContenido() {
		return contenido;
	}

	public void setContenido(Contenido contenido) {
		this.contenido = contenido;
	}

	@Override
	public String toString() {
		return "Calendario [idCalendario=" + idCalendario + ", fecha=" + fecha + ", hora=" + hora + ", contenido="
				+ contenido + "]";
	}

}
