package negocio;

import java.time.LocalDate;
import java.util.List;

import datos.Afiliado;
import datos.Plan;
import dao.AfiliadoDao;

public class AfiliadoABM {
	AfiliadoDao dao = new AfiliadoDao();

	public double calcularCostoMensual(Afiliado afiliado) {
		if (afiliado == null || afiliado.getPlan() == null) {
			throw new IllegalArgumentException("Afiliado o Plan no pueden ser nulos.");
		}
		Plan plan = afiliado.getPlan();
		double costoBase = plan.getCostoBase();
		double descuento = plan.getDescuento();
		double costoMensual = costoBase - descuento;
		return costoMensual;
	}

	public Afiliado traer(String nroAfiliado) {
		return dao.traer(nroAfiliado);
	}

	public List<Afiliado> traer(Plan plan) {
		return dao.traer(plan);
	}

	public List<Afiliado> traer(LocalDate fechaDesde, LocalDate fechaHasta) {
		return dao.traer(fechaDesde, fechaHasta);
	}

	public List<Afiliado> traer(LocalDate fechaDesde, LocalDate fechaHasta, Plan plan) {
		return dao.traer(fechaDesde, fechaHasta, plan);
	}

}
