package ejb;

import javax.ejb.Stateless;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ejb.excepciones.AsignaturaExistenteException;
import ejb.excepciones.AsignaturaNoEncontradoException;
import ejb.excepciones.TrazabilidadException;
import jpa.entidades.Asignatura;

@Stateless
public class AsignaturaEJB implements GestionAsignaturas {
	
	@PersistenceContext(name="sii_grupor")
	private EntityManager em;
	
	
	@Override
	public void eliminarAsignatura(Asignatura asignatura) throws AsignaturaNoEncontradoException {
		Asignatura asig = em.find(Asignatura.class, asignatura.getReferencia());
		if (asig == null) {
			throw new AsignaturaNoEncontradoException();
		}
		em.remove(asig);
	}
	
	@Override
	public void actualizarAsignatura(Asignatura asignatura) throws AsignaturaNoEncontradoException {
		Asignatura asig = em.find(Asignatura.class, asignatura.getReferencia());
		if (asig == null) {
			throw new AsignaturaNoEncontradoException();
		}
		asig.setReferencia(asignatura.getReferencia());
		asig.setCodigo(asignatura.getCodigo());
		asig.setCreditos(asignatura.getCreditos());
		asig.setOfertada(asignatura.getOfertada());
		asig.setNombre(asignatura.getNombre());
		asig.setCurso(asignatura.getCurso());
		asig.setCaracter(asignatura.getCaracter());
		asig.setDuracion(asignatura.getDuracion());
		asig.setUnidad_temporal(asignatura.getUnidad_temporal());
		asig.setIdiomas(asignatura.getIdiomas());
		em.persist(asig);
	}
	
	@Override
	public void insertarAsignatura(Asignatura asignatura) throws TrazabilidadException {
		Asignatura asig = em.find(Asignatura.class, asignatura.getReferencia());
		if (asig != null) {
			throw new AsignaturaExistenteException();
		}
		em.persist(asig);
	}

	@Override
	public Asignatura obtenerAsignaturas(int ref) throws AsignaturaNoEncontradoException {
		Asignatura asignatura = em.find(Asignatura.class, ref);
		if (asignatura == null) {
			throw new AsignaturaNoEncontradoException();
		}
		return asignatura;
	}
	
	
}