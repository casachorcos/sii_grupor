package ejb;

import ejb.excepciones.TrazabilidadException;
import jpa.entidades.Matricula;
import javax.ejb.Local;

@Local
public interface GestionMatricula {

	/**
	 * Actualiza una matricula en la base de datos.
	 * Si no se encuentra la matricula en la base de datos, lanza la excepción MatriculaNoEncontradoException.
	 * @param matricula Matricula que se quiere actualizar.
	 */
	public void actualizarMatricula(Matricula matricula) throws TrazabilidadException;
	
}
