package test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import datos.Cliente;
import negocio.ClienteABM;
import negocio.EventoABM;

public class TestAgregarEvento {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClienteABM clienteABM = new ClienteABM();
		EventoABM eventoABM = new EventoABM();
		Set<Cliente> clientes = new HashSet<Cliente>();
		Long idCliente = 6l;
		Cliente c = null;
		try {
			c = clienteABM.traer(idCliente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		clientes.add(c);
		try {
			c = clienteABM.traer(4l);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		clientes.add(c);
		try {
			c = clienteABM.traer(3l);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		clientes.add(c);

		String evento = "despedida de soltero";
		LocalDate fecha = LocalDate.now();
		LocalTime hora = LocalTime.now();

		long ultimoIdEvento = eventoABM.agregar(evento, fecha, hora);

		System.out.println("Nuevo Evento Agregado ID:" + ultimoIdEvento);

	}
}
