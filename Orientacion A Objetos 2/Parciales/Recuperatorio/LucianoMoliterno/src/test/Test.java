package test;

import java.time.LocalTime;

import datos.Ticket;
import negocio.TicketABM;
import negocio.VehiculoABM;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		VehiculoABM vehiculoABM = new VehiculoABM();
		TicketABM ticketABM = new TicketABM();

		System.out.println("1) Traer e imprimir todos los Vehiculos con todos sus atributos:");
		System.out.println(vehiculoABM.traerVehiculos());

		System.out.println("2) Traer e imprimir el Vehiculo patente: VC325OI");
		System.out.println(vehiculoABM.traerVehiculoPatente("VC325OI"));

		System.out.println(
				"3) Traer Ticket estacionado el Vehiculo patente: 166DIK, horaSalida=09:55, cerrar e imprimir ticket");
		//ticket estacionado
		Ticket ticketEstacionado;
		try {
			ticketEstacionado = ticketABM.traerTicketEstacionado(vehiculoABM.traerVehiculoPatente("166DIK"));
			// Si el ticket existe, imprime y cierra con la hora de salida
			if (ticketEstacionado != null) {
				System.out.println("Ticket estacionado:");
				System.out.println(ticketEstacionado);
				// Cierra el ticket con la hora de salida y el precio base
				ticketEstacionado.cerrarTicket(LocalTime.of(9, 55), 1500);
				// Imprime el ticket "cerrado"
				System.out.println("Ticket cerrado:");
				System.out.println(ticketEstacionado);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(
				"4) Traer Ticket estacionado el Vehiculo patente: 755DJK, horaSalida=13:40, cerrar e imprimir ticket");
		Ticket ticketEstacionado2;
		try {
			ticketEstacionado2 = ticketABM.traerTicketEstacionado(vehiculoABM.traerVehiculoPatente("755DJK"));
			if (ticketEstacionado2!= null) {
				System.out.println("Ticket estacionado:");
				System.out.println(ticketEstacionado2);
				ticketEstacionado2.cerrarTicket(LocalTime.of(13, 40), 1500);
				System.out.println("Ticket cerrado:");
				System.out.println(ticketEstacionado2);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(
				"5) Traer Ticket estacionado el Vehiculo patente: OI654EE, horaSalida=11:55, cerrar e imprimir ticket");
		Ticket ticketEstacionado3;
		try {
			ticketEstacionado3 = ticketABM.traerTicketEstacionado(vehiculoABM.traerVehiculoPatente("OI654EE"));
			if (ticketEstacionado3 != null) {
				System.out.println("Ticket estacionado:");
				System.out.println(ticketEstacionado3);
				ticketEstacionado3.cerrarTicket(LocalTime.of(11, 55), 1500);
				System.out.println("Ticket cerrado:");
				System.out.println(ticketEstacionado3);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(
				"6) Traer Ticket estacionado el Vehiculo patente: ES486GR, horaSalida=12:55, cerrar e imprimir ticket");
		Ticket ticketEstacionado4;
		try {
			ticketEstacionado4 = ticketABM.traerTicketEstacionado(vehiculoABM.traerVehiculoPatente("166DIK"));
			if (ticketEstacionado4 != null) {
				System.out.println("Ticket estacionado:");
				System.out.println(ticketEstacionado4);
				ticketEstacionado4.cerrarTicket(LocalTime.of(12, 55), 1500);
				System.out.println("Ticket cerrado:");
				System.out.println(ticketEstacionado4);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
