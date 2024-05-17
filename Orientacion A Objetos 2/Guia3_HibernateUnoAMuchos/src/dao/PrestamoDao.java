package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Cliente;
import datos.Prestamo;

public class PrestamoDao {
	private static Session session;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("error en la capa de acceso a datos", he);
	}

	public int agregar(Prestamo objeto) throws HibernateException {
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

	public void actualizar(Prestamo objeto) throws HibernateException {
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

	public void eliminar(Prestamo objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.delete(objeto);
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
	}

	public Prestamo traerSinCliente(long idObjeto) {
		Prestamo objeto = null;
		try {
			iniciaOperacion();
			objeto = (Prestamo) session.get(Prestamo.class, idObjeto);
		} finally {
			session.close();
		}
		return objeto;
	}

	public Prestamo traer(long idPrestamo) {
		Prestamo objeto = null;
		try {
			iniciaOperacion();
			objeto = (Prestamo) session
					.createQuery("from Prestamo p inner join fetch p.cliente c where p.idPrestamo=:idPrestamo")
					.setParameter("idPrestamo", idPrestamo).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	public List<Prestamo> traer(Cliente c) {
		List<Prestamo> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Prestamo p inner join fetch p.cliente c where c.idCliente=:idCliente",
					Prestamo.class).setParameter("idCliente", c.getIdCliente()).list();
		} finally {
			session.close();
		}
		return lista;
	}

}