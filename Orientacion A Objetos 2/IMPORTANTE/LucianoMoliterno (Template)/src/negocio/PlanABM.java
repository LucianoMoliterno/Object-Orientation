package negocio;

import java.util.List;
import dao.PlanDao;
import datos.Plan;

public class PlanABM {
	PlanDao dao = new PlanDao();
	public List<Plan> traer() {
		return dao.traer();
	}

	public Plan traer(String nombre) {
		return dao.traer(nombre);
	}
}
