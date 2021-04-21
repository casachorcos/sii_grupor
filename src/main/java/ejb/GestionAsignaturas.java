package ejb;

import ejb.excepciones.*;
import jpa.entidades.Asignatura;

public interface GestionAsignaturas {

	/**
	 * Elimina una asigignatura de la base de datos.
	 * Si no se encuentra la asignatura en la base de datos, lanza la excepcion AsignaturaNoEncontradoException.
	 * @param asignatura Asignatura que se quiere eliminar.
	 */
	public void eliminarAsignatura(Asignatura asignatura) throws TrazabilidadException;
	
	/**
	 * Actualiza una matricula en la base de datos.
	 * Si no se encuentra la matricula en la base de datos, lanza la excepcion AsignaturaNoEncontradoException.
	 * @param asignatura Matricula que se quiere actualizar.
	 */
	public void actualizarAsignatura(Asignatura asignatura) throws TrazabilidadException;
	
	/**
	 * Crear una matricula en la base de datos.
	 * Si ya se encuentra la asignatura en la base de datos, lanza la excepcion AsignaturaExistenteException.
	 * @param asignatura Asignatura que se quiere crear.
	 */
	public void crearAsignatura(Asignatura asignatura) throws TrazabilidadException;
	
}
