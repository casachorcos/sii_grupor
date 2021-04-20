package ejb;

import ejb.excepciones.TrazabilidadException;
import jpa.entidades.Encuesta;
import javax.ejb.Local;

@Local
public interface GestionEncuestas {

	/**
	 * Añade la encuesta la base de datos.
	 * @param encuesta Encuesta que se va a añadir.
	 */
	public void crearEncuesta(Encuesta encuesta) throws TrazabilidadException;
	
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
	public void eliminarGrupo(Encuesta encuesta) throws TrazabilidadException;
}
