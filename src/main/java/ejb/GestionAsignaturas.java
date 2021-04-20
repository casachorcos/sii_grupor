package ejb;

import ejb.excepciones.*;
import jpa.entidades.Asignatura;

public interface GestionAsignaturas {

	public void eliminarAsignatura(Asignatura asignatura) throws TrazabilidadException;
	
	public void actualizarAsignatura(Asignatura asignatura) throws TrazabilidadException;
	
	public void crearAsignatura(Asignatura asignatura) throws TrazabilidadException;
	
}
