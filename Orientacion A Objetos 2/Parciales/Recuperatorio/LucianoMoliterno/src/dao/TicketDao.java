package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Ticket;
import datos.Vehiculo;

public class TicketDao {
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

	public Ticket traerTicketEstacionado(Vehiculo vehiculo) throws HibernateException {
		Ticket ticket = null;
		try {
			iniciaOperacion();
			String hql = "from Ticket t inner join fetch t.vehiculo v where v.idVehiculo = :idVehiculo";
			ticket = (Ticket) session.createQuery(hql).setParameter("idVehiculo", vehiculo.getIdVehiculo())
					.uniqueResult();
		} finally {
			session.close();
		}
		return ticket;
	}
}
