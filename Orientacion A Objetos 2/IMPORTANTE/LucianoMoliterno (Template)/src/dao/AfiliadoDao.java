package dao;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datos.Afiliado;
import datos.Plan;

public class AfiliadoDao {
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

	public Afiliado traer(String nroAfiliado) {
		Afiliado afiliado = null;
		try {
			iniciaOperacion();
			String hql = "from Afiliado a inner join fetch a.plan p where a.nroAfiliado = :nroAfiliado";
			afiliado = (Afiliado) session.createQuery(hql).setParameter("nroAfiliado", nroAfiliado).uniqueResult();
		} finally {
			session.close();
		}
		return afiliado;
	}

	// traer todos los datos del afiliado y de su plan de forma completa
	public List<Afiliado> traer(Plan plan) {
	    List<Afiliado> afiliados = new ArrayList<>();
	    try {
	        iniciaOperacion();
	        String hql = "from Afiliado a inner join fetch a.plan p where p.idPlan = :idPlan order by a.idAfiliado asc";
	        Query<Afiliado> query = session.createQuery(hql, Afiliado.class).setParameter("idPlan", plan.getIdPlan());
	        afiliados = query.getResultList();
	    } finally {
	        session.close();
	    }
	    return afiliados;
	}


	// traer todos los datos del afiliado y de su plan de forma completa
	public List<Afiliado> traer(LocalDate fechaDesde, LocalDate fechaHasta) {
	    List<Afiliado> afiliados = new ArrayList<>();
	    try {
	        iniciaOperacion();
	        String hql = "from Afiliado a inner join fetch a.plan p where a.fechaAlta between :fechaDesde and :fechaHasta order by a.idAfiliado asc";
	        Query<Afiliado> query = session.createQuery(hql, Afiliado.class)
	                .setParameter("fechaDesde", fechaDesde)
	                .setParameter("fechaHasta", fechaHasta);
	        afiliados = query.getResultList();
	    } finally {
	        session.close();
	    }
	    return afiliados;
	}


	// traer todos los datos del afiliado y de su plan de forma completa
	public List<Afiliado> traer(LocalDate fechaDesde, LocalDate fechaHasta, Plan plan) {
	    List<Afiliado> afiliados = new ArrayList<>();
	    try {
	        iniciaOperacion();
	        String hql = "from Afiliado a inner join fetch a.plan p where p.idPlan = :idPlan and a.fechaAlta between :fechaDesde and :fechaHasta order by a.idAfiliado asc";
	        Query<Afiliado> query = session.createQuery(hql, Afiliado.class)
	                .setParameter("idPlan", plan.getIdPlan())
	                .setParameter("fechaDesde", fechaDesde)
	                .setParameter("fechaHasta", fechaHasta);
	        afiliados = query.getResultList();
	    } finally {
	        session.close();
	    }
	    return afiliados;
	}

	
	
}
