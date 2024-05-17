package test;

import java.time.LocalDate;
import java.time.LocalTime;

import datos.Evento;
import negocio.EventoABM;

public class TestActualizarEvento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventoABM eventoABM = new EventoABM();
		Long idEvento = 3L;

		Evento evento = null;
		try {
			evento = eventoABM.traer(idEvento);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println(evento);

		evento.setEvento("bautismo");
		evento.setFecha(LocalDate.now());
		evento.setHora(LocalTime.now());
		eventoABM.modificar(evento);
		try {
			System.out.println("\n*evento modificado* \n" + eventoABM.traer(idEvento));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

}