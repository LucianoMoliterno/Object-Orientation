package negocio;

import java.util.List;

import dao.VehiculoDao;
import datos.Vehiculo;

public class VehiculoABM {

	VehiculoDao dao = new VehiculoDao();

	public List<Vehiculo> traerVehiculos() {
		return dao.traer();
	}

	public Vehiculo traerVehiculoPatente(String patente) {
		return dao.traer(patente);
	}

}
