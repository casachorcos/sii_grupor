package ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.Date;

import javax.ejb.Stateless;

import ejb.excepciones.AlumnoNoEncontradoException;
import ejb.excepciones.EncuestaExistenteException;
import ejb.excepciones.EncuestaNoEncontradoException;
import ejb.excepciones.TrazabilidadException;
import jpa.entidades.Alumno;
import jpa.entidades.Encuesta;

@Stateless
public class EncuestaEJB implements GestionEncuestas{
	
	@PersistenceContext(name="sii_grupor")
	private EntityManager em;
	
	@Override
	public Encuesta obtenerEncuesta(Date fecha) throws EncuestaNoEncontradoException {
		Encuesta en = em.find(Encuesta.class, fecha);
		if (en == null) throw new EncuestaNoEncontradoException();
		
		return en;
	}

	@Override
	public void insertarEncuesta(Encuesta encuesta) throws TrazabilidadException {
		Encuesta en = em.find(Encuesta.class, encuesta.getFecha_de_envio());
		if (en != null) throw new EncuestaExistenteException();
		
		em.persist(encuesta);
	}

	@Override
	public void actualizarEncuesta(Encuesta encuesta) throws EncuestaNoEncontradoException {
		Encuesta en = em.find(Encuesta.class, encuesta.getFecha_de_envio());
		if (en==null) {
			throw new EncuestaNoEncontradoException();
		}
		en.setFecha_de_envio(encuesta.getFecha_de_envio());
		
	}

	@Override
	public void eliminarGrupo(Encuesta encuesta) throws EncuestaNoEncontradoException {
		Encuesta en = em.find(Encuesta.class, encuesta.getFecha_de_envio());
		if (en==null) {
			throw new EncuestaNoEncontradoException();
		}
		
		em.remove(en);
	}
}
	