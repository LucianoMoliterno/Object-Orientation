package negocio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import dao.EventoDao;
import datos.Evento;

public class EventoABM {
	EventoDao dao = new EventoDao();

	public Evento traer(long idEvento) {
		Evento e = dao.traer(idEvento);
		return e;
	}

	public int agregar(String evento, LocalDate fecha, LocalTime hora) {
		Evento e = new Evento(evento, fecha, hora);
		return dao.agregar(e);
	}

	public void modificar(Evento e) {
		dao.actualizar(e);
	}

	public void eliminar(long idEvento) throws Exception {
		Evento e = dao.traer(idEvento);
		if (e == null) {
			throw new Exception("evento no encontrado");
		}
		dao.eliminar(e);
	}

	public List<Evento> traer() {
		return dao.traer();
	}
}
