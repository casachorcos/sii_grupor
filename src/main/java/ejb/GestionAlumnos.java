package ejb;

import ejb.excepciones.TrazabilidadException;
import jpa.entidades.Alumno;
import javax.ejb.Local;

@Local
public interface GestionAlumnos {
	
	/**
	 * Actualiza un alumno en la base de datos.
	 * Si no se encuentra al alumno en la base de datos, lanza la excepción AlumnoNoEncontradoException.
	 * @param alumno Alumno que se quiere actualizar.
	 */
	public void actualizarAlumno(Alumno alumno) throws TrazabilidadException;
	
}