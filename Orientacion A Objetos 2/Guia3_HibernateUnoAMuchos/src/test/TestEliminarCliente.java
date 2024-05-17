package test;

import datos.Cliente;
import negocio.ClienteABM;

public class TestEliminarCliente {
public static void main(String[] args) {
	// TODO Auto-generated method stub
    ClienteABM abm = new ClienteABM();
    long id = 5;
    Cliente c = new Cliente();
    try {
        c = abm.traer(id);
    } catch (Exception e) {
        System.err.println(e);
    }
    try {
        abm.eliminar(id);
        System.out.println("Cliente eliminado -->" + c);
    } catch (Exception e) {
        System.err.println(e);
    }
}
}


