package ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ejb.Stateless;

import ejb.excepciones.EncuestaNoEncontradoException;
import ejb.excepciones.TrazabilidadException;
import jpa.entidades.Encuesta;

@Stateless
public class EncuestaEJB implements GestionEncuestas{
	
	@PersistenceContext(name="sii_grupor")
	private EntityManager em;

	@Override
	public void crearEncuesta(Encuesta encuesta) throws TrazabilidadException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarEncuesta(Encuesta encuesta) throws EncuestaNoEncontradoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarGrupo(Encuesta encuesta) throws EncuestaNoEncontradoException {
		// TODO Auto-generated method stub
		
	}
}
	