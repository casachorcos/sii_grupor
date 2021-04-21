package ejb;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.ejb.Stateless;

import ejb.excepciones.EncuestaNoEncontradoException;
import ejb.excepciones.TrazabilidadException;
import jpa.entidades.Alumno;
import jpa.entidades.Encuesta;

@Stateless
public class EncuestaEJB implements GestionEncuestas{
	
	@PersistenceContext(name="sii_grupor")
	private EntityManager em;

	@Override
	public void crearEncuesta(Encuesta encuesta) throws TrazabilidadException {
		Encuesta en = em.find(Encuesta.class, encuesta.getFecha_de_envio());
		if(en==null) {
			throw new EncuestaNoEncontradoException();
		}
		em.persist(en);
		
	}

	@Override
	public void actualizarEncuesta(Encuesta encuesta) throws EncuestaNoEncontradoException {
		Encuesta en = em.find(Encuesta.class, encuesta.getFecha_de_envio());
		if(en==null) {
			throw new EncuestaNoEncontradoException();
		}
		em.persist(en);
		
	}

	@Override
	public void eliminarGrupo(Encuesta encuesta) throws EncuestaNoEncontradoException {
		Encuesta en = em.find(Encuesta.class, encuesta.getFecha_de_envio());
		if(en==null) {
			throw new EncuestaNoEncontradoException();
		}
		em.remove(en);
		
	}
}
	