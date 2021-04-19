package ejb;

import ejb.excepciones.*;
import jpa.entidades.Alumno;

public interface GestionAlumnos {

	public void eliminarAlumno(Alumno alumno) throws TrazabilidadException;
	
	public void actualizarAlumno(Alumno alumno) throws TrazabilidadException;
	
}
