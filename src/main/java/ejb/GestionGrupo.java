package ejb;

import ejb.excepciones.TrazabilidadException;
import jpa.entidades.Grupo;
import javax.ejb.Local;

@Local
public interface GestionGrupo {

	/*
	 * A�ade el grupo a la base de datos.
	 * @param grupo Grupo que se va a a�adir.
	 */
	public void crearGrupo(Grupo grupo) throws TrazabilidadException;
	
	/*
	 * Actualiza un grupo en la base de datos.
	 * Si no se encuentra el grupo en la base de datos, lanza la excepci�n GrupoNoEncontradoException.
	 * @param grupo Grupo a actualizar.
	 */
	public void actualizarGrupo(Grupo grupo) throws TrazabilidadException;
	
	/*
	 * Elimina un grupo de la base de datos.
	 * Si no se encuentra el grupo en la base de datos, lanza la excepci�n GrupoNoEncontradoException.
	 * @param grupo Grupo a eliminar.*/
	public void eliminarGrupo(Grupo grupo) throws TrazabilidadException;
	
}
