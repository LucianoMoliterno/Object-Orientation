package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.PrestamoDao;
import datos.Cliente;
import datos.Prestamo;

public class PrestamoABM {
	private PrestamoDao dao = new PrestamoDao();

	public Prestamo traerPrestamo(long idPrestamo){
		return dao.traer(idPrestamo);
		}

	public List<Prestamo> traerPrestamo(Cliente c) {
		return dao.traer(c);
	}

	public int agregar(LocalDate fecha,double monto, double interes, int cantCuotas, Cliente cliente) {
		Prestamo p = new Prestamo(fecha,monto,interes,cantCuotas,cliente);
		return dao.agregar(p);
	}

	public void modificar(Prestamo p) throws Exception {
		if (this.traerPrestamo(p.getIdPrestamo()) == null) {
			throw new Exception("No se puede actualizar. No existe un prestamo con ese Id");
		}
		dao.actualizar(p);
	}

	public void eliminar(long idPrestamo) throws Exception {
		Prestamo p = dao.traer(idPrestamo);
		if (p == null) {
			throw new Exception("No se puede eliminar. No existe un prestamo con ese id.");
		}
		dao.eliminar(p);
	}
}