package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Plan;

public class PlanDao {
	private static Session session;
	private Transaction tx;

	@SuppressWarnings("unused")
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	@SuppressWarnings("unused")
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("Error en la capa de acceso a datos", he);
	}

	public List<Plan> traer() {
		List<Plan> planes = null;
		try {
			iniciaOperacion();
			planes = session.createQuery("from Plan p", Plan.class).list();
		} finally {
			session.close();
		}
		return planes;
	}

	public Plan traer(String nombre) {
		Plan plan = null;
		try {
			iniciaOperacion();
			String hql = "from Plan p where p.nombre = :nombre";
			plan = (Plan) session.createQuery(hql).setParameter("nombre", nombre).uniqueResult();
		} finally {
			session.close();
		}
		return plan;
	}

	
}
