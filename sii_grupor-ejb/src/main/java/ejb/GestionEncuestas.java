package ejb;

import ejb.excepciones.EncuestaNoEncontradoException;
import ejb.excepciones.TrazabilidadException;
import jpa.entidades.Encuesta;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

@Local
public interface GestionEncuestas {
	
	/**
	 * Obtiene la encuesta de la base de datos.
	 * @param encuesta Encuesta que se va a añadir.
	 */
	public Encuesta obtenerEncuesta(Date fecha) throws TrazabilidadException;

	/**
	 * Añade la encuesta la base de datos.
	 * @param encuesta Encuesta que se va a añadir.
	 */
	public void insertarEncuesta(Encuesta encuesta) throws TrazabilidadException;
	
	/**
	 * Actualiza una encuesta en la base de datos.
	 * Si no se encuentra la encuesta en la base de datos, lanza la excepcion EncuestaNoEncontradoException.
	 * @param encuesta Encuesta a actualizar.
	 */
	public void actualizarEncuesta(Encuesta encuesta) throws TrazabilidadException;
	
	/**
	 * Elimina una encuesta de la base de datos.
	 * Si no se encuentra la encuesta en la base de datos, lanza la excepcion EncuestaNoEncontradoException.
	 * @param encuesta Encuesta a eliminar.*/
	public void eliminarEncuesta(Encuesta encuesta) throws TrazabilidadException;

	public List<Encuesta> listaEncuesta() throws TrazabilidadException;
}
