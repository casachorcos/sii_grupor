package ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import ejb.excepciones.EncuestaExistenteException;
import ejb.excepciones.EncuestaNoEncontradoException;
import ejb.excepciones.TrazabilidadException;
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
		en.setNexpediente(encuesta.getNexpediente());
		en.setAsignaturas(encuesta.getAsignaturas());
		en.setGr_preferente(encuesta.getGr_preferente());
		en.setAsig_ingles(encuesta.getAsig_ingles());
		em.persist(en);
	}

	@Override
	public void eliminarEncuesta(Encuesta encuesta) throws EncuestaNoEncontradoException {
		Encuesta en = em.find(Encuesta.class, encuesta.getFecha_de_envio());
		if (en==null) {
			throw new EncuestaNoEncontradoException();
		}
		em.remove(en);
	}
	
	@Override
	public List<Encuesta> listaEncuesta() throws TrazabilidadException {
		return em.createNamedQuery("Encuesta.todos", Encuesta.class).getResultList();
	}
}
	