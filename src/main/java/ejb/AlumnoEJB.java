package ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ejb.excepciones.TrazabilidadException;
import jpa.entidades.Alumno;

public class AlumnoEJB implements GestionAlumnos {
	
	@PersistenceContext(name="sii_grupor")
	private EntityManager em;
	
	@Override
	public void eliminarAlumno(Alumno alumno) {
		
	}
	
	@Override
	public void actualizarAlumno(Alumno alumno) {
		
	}

	
	
}