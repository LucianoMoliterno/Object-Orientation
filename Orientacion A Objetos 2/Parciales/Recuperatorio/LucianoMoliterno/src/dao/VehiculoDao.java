package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Vehiculo;

public class VehiculoDao {
	private static Session session;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	@SuppressWarnings("unused")
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("Error en la capa de acceso a datos", he);
	}

	public List<Vehiculo> traer() {
		List<Vehiculo> vehiculos = null;
		try {
			iniciaOperacion();
			vehiculos = session.createQuery("from Vehiculo v", Vehiculo.class).list();
		} finally {
			session.close();
		}
		return vehiculos;
	}

	public Vehiculo traer(String patente) {
		Vehiculo vehiculo = null;
		try {
			iniciaOperacion();
			String hql = "from Vehiculo v where v.patente = :patente";
			vehiculo = (Vehiculo) session.createQuery(hql).setParameter("patente", patente).uniqueResult();
		} finally {
			session.close();
		}
		return vehiculo;
	}
}
