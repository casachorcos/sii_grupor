package ejb;

import javax.ejb.Stateless;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ejb.excepciones.TrazabilidadException;
import jpa.entidades.Asignatura;

@Stateless
public class AsignaturaEJB implements GestionAsignaturas {
	
	@PersistenceContext(name="sii_grupor")
	private EntityManager em;
	
	
	@Override
	public void eliminarAsignatura(Asignatura asignatura) {
		
	}
	
	@Override
	public void actualizarAsignatura(Asignatura asignatura) {
		
	}
	
	@Override
	public void crearAsignatura(Asignatura asignatura) {
		
	}

	
	
}