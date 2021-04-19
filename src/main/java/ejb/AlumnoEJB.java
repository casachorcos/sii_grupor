package ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ejb.Stateless;

import ejb.excepciones.TrazabilidadException;
import jpa.entidades.Alumno;

@Stateless
public class AlumnoEJB implements GestionAlumnos {
	
	@PersistenceContext(name="sii_grupor")
	private EntityManager em;
	
	@Override
	public void actualizarAlumno(Alumno alumno) {
		
	}

	
	
}