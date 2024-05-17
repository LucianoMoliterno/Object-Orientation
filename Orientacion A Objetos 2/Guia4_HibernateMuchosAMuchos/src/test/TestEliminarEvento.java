package test;

import datos.Evento;
import negocio.EventoABM;

public class TestEliminarEvento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventoABM eventoABM = new EventoABM();
		// Id A Borrar
		long idEvento = 3L;
		Evento evento = null;
		try {

			evento = eventoABM.traer(idEvento);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Evento a Borrar -->" + evento);
		try {
			eventoABM.eliminar(evento.getIdEvento());
			System.out.println("\n \n *****Eliminado**** \n \n ");

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
