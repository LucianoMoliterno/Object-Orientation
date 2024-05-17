package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Evento;

public class EventoDao {
	private static Session session;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

	public int agregar(Evento objeto) throws HibernateException {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
		return id;
	}

	public void actualizar(Evento objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
	}

	public void eliminar(Evento objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
	}

	public Evento traer(long idEvento) {
		Evento objeto = null;
		try {
			iniciaOperacion();
			objeto = (Evento) session.get(Evento.class, idEvento);
		} finally {
			session.close();
		}
		return objeto;
	}

	public Evento traer(int dni) {
		Evento objeto = null;
		try {
			iniciaOperacion();
			objeto = (Evento) session.createQuery("from Evento c where c.dni=:dni").setParameter("dni", dni)
					.uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	public List<Evento> traer() {
		List<Evento> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Evento c order by c.idEvento", Evento.class).list();
		} finally {
			session.close();
		}
		return lista;
	}

	public Evento traerClienteYEventos(long idEvento) {
		Evento objeto = null;
		try {
			iniciaOperacion();
			objeto = (Evento) session.createQuery("from Evento c where c.idEvento=:idEvento")
					.setParameter("idEvento", idEvento).uniqueResult();
			Hibernate.initialize(objeto.getClientes());
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
		return objeto;
	}

}
