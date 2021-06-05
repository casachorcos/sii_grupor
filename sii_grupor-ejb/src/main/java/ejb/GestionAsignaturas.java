package ejb;

import java.util.List;

import ejb.excepciones.*;
import jpa.entidades.Asignatura;

public interface GestionAsignaturas {

	/**
	 * Elimina una asigignatura de la base de datos.
	 * Si no se encuentra la asignatura en la base de datos, lanza la excepcion AsignaturaNoEncontradoException.
	 * @param asignatura Asignatura que se quiere eliminar.
	 */
	public void eliminarAsignatura(Asignatura asignatura) throws AsignaturaNoEncontradoException;
	
	/**
	 * Actualiza una asignatura en la base de datos.
	 * Si no se encuentra la asignatura en la base de datos, lanza la excepcion AsignaturaNoEncontradoException.
	 * @param asignatura Asignatura que se quiere actualizar.
	 */
	public void actualizarAsignatura(Asignatura asignatura) throws AsignaturaNoEncontradoException;
	
	/**
	 * Insertar una asignatura en la base de datos.
	 * Si ya se encuentra la asignatura en la base de datos, lanza la excepcion AsignaturaExistenteException.
	 * @param asignatura Asignatura que se quiere insertar.
	 */
	public void insertarAsignatura(Asignatura asignatura) throws TrazabilidadException;

	/**
	 * Obtener una asignatura en la base de datos.
	 * Si no se encuentra la matricula en la base de datos, lanza la excepcion AsignaturaNoEncontradoException.
	 * @param ref int que se quiere obtener.
	 */
	public Asignatura obtenerAsignaturas(int ref) throws AsignaturaNoEncontradoException;

	public List<Asignatura> listaAsignatura() throws TrazabilidadException;
	
}
