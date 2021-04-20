package ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ejb.Stateless;

import ejb.excepciones.MatriculaNoEncontradoException;
import ejb.excepciones.TrazabilidadException;
import jpa.entidades.Matricula;

@Stateless
public class MatriculaEJB implements GestionMatricula{

	@PersistenceContext(name="sii_grupor")
	private EntityManager em;
	
	@Override
	public void actualizarMatricula(Matricula matricula) throws MatriculaNoEncontradoException {
		// TODO Auto-generated method stub
		
	}

}
