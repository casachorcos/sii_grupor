package ejb;

import ejb.excepciones.TrazabilidadException;
import jpa.entidades.Alumno;
import javax.ejb.Local;

@Local
public interface GestionAlumnos {
	
	public void actualizarAlumno(Alumno alumno) throws TrazabilidadException;
	
}