package test;

import java.time.LocalDate;

import negocio.ClienteABM;

public class TestAgregarCliente {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ClienteABM clienteABM = new ClienteABM();
        
        // Datos del cliente a agregar
        String apellido = "Mr";
        String nombre = "X";
        int dni = 44444445;
        LocalDate fechaNacimiento = LocalDate.of(2000, 03, 22);
        boolean baja = false;
        
        try {
            // Agregar el cliente
           clienteABM.agregar(apellido, nombre, dni, fechaNacimiento, baja); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
