package negocio;

import dao.TicketDao;
import datos.Ticket;
import datos.Vehiculo;

public class TicketABM {

	TicketDao dao = new TicketDao();

	public Ticket traerTicketEstacionado(Vehiculo vehiculo) throws Exception {
		Ticket ticket = dao.traerTicketEstacionado(vehiculo);
		if (ticket != null && ticket.getHoraEgreso() == null) {
			return ticket;
		} else {
			throw new Exception("El vehículo no está estacionado o el ticket no existe.");
		}
	}

}
